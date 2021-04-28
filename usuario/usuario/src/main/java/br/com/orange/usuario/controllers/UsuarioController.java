package br.com.orange.usuario.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orange.usuario.controllers.dto.UsuarioDTO;
import br.com.orange.usuario.controllers.dto.UsuarioNovoDTO;
import br.com.orange.usuario.controllers.form.UsuarioForm;
import br.com.orange.usuario.entities.Usuario;
import br.com.orange.usuario.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioNovoDTO> save(@RequestBody @Valid UsuarioForm usuarioForm,
										  UriComponentsBuilder uriComponentsBuilder) {
		UsuarioNovoDTO usuario = usuarioService.salvar(usuarioForm);
		URI uri = uriComponentsBuilder.path("/client/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	

	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTO> getClientById(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDTO(usuario.get()));			
		}
		return ResponseEntity.notFound().build();
	}
	



}
