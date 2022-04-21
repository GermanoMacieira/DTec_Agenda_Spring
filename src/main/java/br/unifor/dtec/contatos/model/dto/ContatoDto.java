package br.unifor.dtec.contatos.model.dto;

import br.unifor.dtec.contatos.model.Contato;

public class ContatoDto {
	
	// ATRIBUTOS:
	private Long idContato;
	private String nomeContato;
	private String emailContato;
	
	// CONSTRUTOR:
	public ContatoDto(Contato contato) {
		super();
		this.idContato = contato.getIdContato();
		this.nomeContato = contato.getNomeContato();
		this.emailContato = contato.getEmailContato();
	}

	// GET and SET:
	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
		
}
