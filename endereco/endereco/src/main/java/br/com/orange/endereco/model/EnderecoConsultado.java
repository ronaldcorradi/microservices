package br.com.orange.endereco.model;

import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

public class EnderecoConsultado {
	
	 private String cep;
     private String logradouro;
     private String complemento;
     private String bairro;
     private String localidade;
     private String uf;
     
     public EnderecoConsultado(ViaCEPEndereco viaCEPEndereco) {
 		this.cep = viaCEPEndereco.getCep();
 		this.logradouro = viaCEPEndereco.getLogradouro();
 		this.complemento = viaCEPEndereco.getComplemento();
 		this.bairro = viaCEPEndereco.getBairro();
 		this.localidade = viaCEPEndereco.getLocalidade();
 		this.uf = viaCEPEndereco.getUf();
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

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


}
