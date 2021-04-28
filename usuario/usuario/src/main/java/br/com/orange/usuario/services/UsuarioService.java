package br.com.orange.usuario.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.orange.usuario.controllers.dto.UsuarioDTO;
import br.com.orange.usuario.controllers.dto.UsuarioNovoDTO;
import br.com.orange.usuario.controllers.form.UsuarioForm;
import br.com.orange.usuario.entities.Usuario;
import br.com.orange.usuario.repositories.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioNovoDTO salvar(UsuarioForm usuarioForm) {
		Usuario usuario = usuarioForm.converter();
		usuarioRepository.save(usuario);
		return new UsuarioNovoDTO(usuario);
	}


	public List<UsuarioDTO> buscarTodos() {
		return UsuarioDTO.convert(usuarioRepository.findAll());		
	}
	
	public List<UsuarioDTO> buscarPorNome(String nome) {
		return UsuarioDTO.convert(usuarioRepository.findByNomeContainingIgnoreCase(nome));		
	}

	public Optional<Usuario> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario;
		} else {
			return Optional.empty();
		}
	}

	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioForm usuarioForm) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			usuario.get().setDataNascimento(usuarioForm.getDataNascimento());
			usuario.get().setCpf(usuarioForm.getCpf());
			usuario.get().setNome(usuarioForm.getNome());
			usuario.get().setEmail(usuarioForm.getEmail());
			usuarioRepository.save(usuario.get());
			return ResponseEntity.ok(new UsuarioDTO(usuario.get()));
		}else {
			return ResponseEntity.notFound().build();			
		}
	}
	
	public ResponseEntity<?> deletar(@PathVariable Long id){		
		Optional<Usuario> client = usuarioRepository.findById(id);
		if(client.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();						
		}
		return ResponseEntity.notFound().build();		
	}

}
