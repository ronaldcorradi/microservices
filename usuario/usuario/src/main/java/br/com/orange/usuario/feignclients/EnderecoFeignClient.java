package br.com.orange.usuario.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.orange.usuario.controllers.dto.EnderecoDTO;

@Component
@FeignClient(name = "endereco",url = "localhost:8081",path = "/obter-endereco")
public interface EnderecoFeignClient {
	
	@GetMapping("/cep/{cep}")
	ResponseEntity<EnderecoDTO> getEndereco(@PathVariable String cep);

}
