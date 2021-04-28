package br.com.orange.usuario.controllers.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.orange.usuario.entities.Usuario;



public class UsuarioNovoDTO {
	private Long id;
	private String nome;
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataNascimento;

	public UsuarioNovoDTO(Usuario usuario) {	
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
}
