package br.com.orange.endereco.model;

public class EnderecoDTO {
	
	private String logradouro;	
	private String complemento;	
	private String bairro;	
	private String cidade;	
	private String uf;	
	private String cep;	
     
    public EnderecoDTO() {
		
	}
     
	public EnderecoDTO(EnderecoConsultado enderecoConsultado) {
		this.cep = enderecoConsultado.getCep();
		this.logradouro = enderecoConsultado.getLogradouro();
		this.complemento = enderecoConsultado.getComplemento();
		this.bairro = enderecoConsultado.getBairro();
		this.cidade = enderecoConsultado.getLocalidade();
		this.uf = enderecoConsultado.getUf();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	
	
	
	
     
     

}
