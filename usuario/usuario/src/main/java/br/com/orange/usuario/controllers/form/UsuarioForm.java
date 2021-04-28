package br.com.orange.usuario.controllers.form;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.orange.usuario.entities.Usuario;




public class UsuarioForm {
	
	@NotBlank
	private String nome;

	@NotBlank(message = "Campo obrigatório")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataNascimento;
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "E-mail inválido")
	private String email;
		
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	
	public Usuario converter() {
		return new Usuario(nome, cpf, email, dataNascimento);
	}
	
}
