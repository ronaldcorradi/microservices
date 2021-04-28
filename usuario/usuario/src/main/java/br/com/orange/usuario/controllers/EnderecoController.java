package br.com.orange.usuario.controllers;

import java.net.URI;

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

import br.com.orange.usuario.controllers.dto.EnderecoDTO;
import br.com.orange.usuario.controllers.form.EnderecoAutoPreenchido;
import br.com.orange.usuario.entities.Endereco;
import br.com.orange.usuario.feignclients.EnderecoFeignClient;
import br.com.orange.usuario.services.EnderecoService;
import br.com.orange.usuario.services.UsuarioService;
import javassist.NotFoundException;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EnderecoFeignClient feignClient;
	
	@PostMapping
	public ResponseEntity<EnderecoDTO> salvar(@RequestBody @Valid EnderecoAutoPreenchido enderecoForm,
			                                  UriComponentsBuilder builder){
		try {
			Endereco endereco = enderecoService.salvar(enderecoForm, usuarioService);
			URI uri = builder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
			return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}		
	}	
	
	@GetMapping("/endereco/{id}")
	public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id){
		try {
			Endereco endereco = enderecoService.buscarPorId(id);
			return ResponseEntity.ok(new EnderecoDTO(endereco));
		} catch (NotFoundException e) {			
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<EnderecoDTO> buscarPorCep(@PathVariable String cep){
		EnderecoDTO endereco = feignClient.getEndereco(cep).getBody();
		return ResponseEntity.ok(endereco);
	}

}
