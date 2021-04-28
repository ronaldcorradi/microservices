package br.com.orange.endereco.service;

import java.io.IOException;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

import br.com.orange.endereco.model.EnderecoConsultado;
import br.com.orange.endereco.model.EnderecoDTO;

@Service
public class EnderecoService {
	
	public EnderecoDTO buscarCep(String cep) {
		EnderecoConsultado endereco;
		ViaCEPClient viaCEPClient = new ViaCEPClient();
		try {
			ViaCEPEndereco viaCEPEndereco = viaCEPClient.getEndereco(cep);
			endereco = new EnderecoConsultado(viaCEPEndereco);
			return new EnderecoDTO(endereco);
		} catch (IOException e) {			
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}
	}
	

}
