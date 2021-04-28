package br.com.orange.usuario.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.orange.usuario.entities.Usuario;



public class UsuarioDTO {

	private Long id;
	private String name;
	private String cpf;
	private List<EnderecoDTO> enderecos;
	
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.name = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.enderecos = EnderecoDTO.converter(usuario.getEnderecos());
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	
	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}
	
	public static List<UsuarioDTO> convert(List<Usuario> clients) {		
		return clients.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}	
	
	
}
