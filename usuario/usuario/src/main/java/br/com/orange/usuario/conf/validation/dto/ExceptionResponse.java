package br.com.orange.usuario.conf.validation.dto;

public class ExceptionResponse {
	
	
	private String message;
	private String details;

	public ExceptionResponse(String message, String details) {	
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}