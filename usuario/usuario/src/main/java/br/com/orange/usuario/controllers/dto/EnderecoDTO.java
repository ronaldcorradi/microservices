package br.com.orange.usuario.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.orange.usuario.controllers.form.EnderecoForm;
import br.com.orange.usuario.entities.Endereco;



public class EnderecoDTO {
	
	private String logradouro;	
	private String numero;	
	private String complemento;	
	private String bairro;	
	private String cidade;	
	private String uf;	
	private String cep;
	private String tipo;
	
	public EnderecoDTO() {		
	}
	
	public EnderecoDTO(Endereco endereco) {	
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
		this.cep = endereco.getCep();
		this.tipo = endereco.getTipo();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static List<EnderecoDTO> converter(List<Endereco> enderecos){
		return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());	
	}
	
	public EnderecoForm converterDtoParaForm() {
		return new EnderecoForm(logradouro, bairro, cidade, uf, cep);
	}
	
	

}
