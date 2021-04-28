package br.com.orange.usuario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.orange.usuario.controllers.dto.EnderecoDTO;
import br.com.orange.usuario.controllers.form.EnderecoAutoPreenchido;
import br.com.orange.usuario.entities.Endereco;
import br.com.orange.usuario.entities.Usuario;
import br.com.orange.usuario.feignclients.EnderecoFeignClient;
import br.com.orange.usuario.repositories.EnderecoRepository;
import javassist.NotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EnderecoFeignClient feignClient;
	
	public Endereco salvar(EnderecoAutoPreenchido enderecoForm,UsuarioService usuarioService) throws NotFoundException {
		EnderecoDTO dto = feignClient.getEndereco(enderecoForm.getCep()).getBody();		
		Endereco endereco = enderecoForm.converter(dto);
		Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(enderecoForm.getUsuarioId());
		if(usuarioOptional.isPresent()) {
			endereco.setUsuario(usuarioOptional.get());
			enderecoRepository.save(endereco);
			return endereco;
		}
		throw new NotFoundException("Não foi possível cadastrar o endereço");
	}
	
	public Endereco buscarPorId(Long id) throws NotFoundException {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if(endereco.isPresent()) {
			return endereco.get();
		}else {
			throw new NotFoundException("Endereço não encontrado");
		}
	}

}
