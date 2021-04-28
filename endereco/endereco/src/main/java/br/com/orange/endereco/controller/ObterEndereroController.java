package br.com.orange.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.endereco.model.EnderecoDTO;
import br.com.orange.endereco.service.EnderecoService;

@RequestMapping("/obter-endereco")
@RestController
public class ObterEndereroController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<EnderecoDTO> getEndereco(@PathVariable String cep) {
		EnderecoDTO endereco = enderecoService.buscarCep(cep);
		return ResponseEntity.ok(endereco);
	}

}
