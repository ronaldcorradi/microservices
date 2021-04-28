package br.com.orange.usuario.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.orange.usuario.entities.Endereco;


public class EnderecoForm {
	

	@NotNull @NotEmpty
	private String logradouro;
	@NotNull @NotEmpty
	private String numero;
	@NotNull @NotEmpty
	private String complemento;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private String cidade;
	@NotNull @NotEmpty
	private String uf;
	@NotNull @NotEmpty
	private String cep;
	private String tipo;
	private Long usuarioId;
	
	public EnderecoForm() {
		
	}
	
	public EnderecoForm(@NotNull @NotEmpty String logradouro, @NotNull @NotEmpty String numero,
			@NotNull @NotEmpty String complemento, @NotNull @NotEmpty String bairro, @NotNull @NotEmpty String cidade,
			@NotNull @NotEmpty String uf, @NotNull @NotEmpty String cep, String tipo,Long usuarioId) {
	
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.tipo = tipo;
		this.usuarioId = usuarioId;
	}	
	

	public EnderecoForm(@NotNull @NotEmpty String logradouro, @NotNull @NotEmpty String bairro,
			@NotNull @NotEmpty String cidade, @NotNull @NotEmpty String uf, @NotNull @NotEmpty String cep) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}





	public EnderecoForm(@NotNull @NotEmpty String numero, @NotNull @NotEmpty String complemento,
			@NotNull @NotEmpty String cep,Long usuarioId) {
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.usuarioId = usuarioId;
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
	
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}

	public Endereco converter() {		
		return new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep, tipo);
	}
	
	
	
	

}
