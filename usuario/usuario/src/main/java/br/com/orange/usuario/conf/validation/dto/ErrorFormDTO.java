package br.com.orange.usuario.conf.validation.dto;

public class ErrorFormDTO {
	
	private String campo;
	private String mensagem;
	
	public ErrorFormDTO(String campo, String mensagem) {	
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}


	
	
	
}
