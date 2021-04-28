package br.com.orange.usuario.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome",length = 150,nullable = false)
	private String nome;
	@Column(name = "email",length = 60,nullable = false,unique = true)
	private String email; 
	@Column(name = "cpf",length = 15,nullable = false,unique = true)
	private String cpf;
	@Column(name = "data_nasc",nullable = false)	
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER,orphanRemoval = true)	
	private List<Endereco> enderecos;
	
	public Usuario() {		
	}
	
	public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {	
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	

	
	
	

}
