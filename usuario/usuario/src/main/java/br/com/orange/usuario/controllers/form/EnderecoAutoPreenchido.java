package br.com.orange.usuario.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.orange.usuario.controllers.dto.EnderecoDTO;
import br.com.orange.usuario.entities.Endereco;

public class EnderecoAutoPreenchido {
	
	@NotNull @NotEmpty
	private String cep;
	@NotNull @NotEmpty
	private String complemento;
	@NotNull @NotEmpty
	private String numero;
	@NotNull @NotEmpty
	private String tipo;
	@NotNull
	private Long usuarioId;
	
	public EnderecoAutoPreenchido() {		
	}

	public EnderecoAutoPreenchido(@NotNull @NotEmpty String cep, @NotNull @NotEmpty String complemento,
			@NotNull @NotEmpty String numero, @NotNull @NotEmpty String tipo,@NotNull Long usuarioId) {
		this.cep = cep;
		this.complemento = complemento;
		this.numero = numero;
		this.tipo = tipo;
		this.usuarioId = usuarioId;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Endereco converter(EnderecoDTO dto) {
		return new Endereco(dto.getLogradouro(), numero, complemento, dto.getBairro(), dto.getCidade(), 
				dto.getUf(), cep, tipo);
	}
	
	
	
	
	
	

}
