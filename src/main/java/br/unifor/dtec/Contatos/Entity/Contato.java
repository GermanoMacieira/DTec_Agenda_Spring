package br.unifor.dtec.Contatos.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contato")	//Anotação do JPA que nomeia o nome da tabela no banco;
public class Contato {
	
	// ATRIBUTOS:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Anotação do JPA que indica o Auto incremento do id na tabela do banco de dados;
	private Long idContato;
	private String nomeContato;
	private String emailContato;
	private String telefoneContato;
	private String enderecoContato;
	
	// CONSTRUTOR:
	public Contato() {

	}
	
	public Contato(Long idContato, String nomeContato, String emailContato, String telefoneContato,
			String enderecoContato) {
		super();
		this.idContato = idContato;
		this.nomeContato = nomeContato;
		this.emailContato = emailContato;
		this.telefoneContato = telefoneContato;
		this.enderecoContato = enderecoContato;
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


	public String getTelefoneContato() {
		return telefoneContato;
	}


	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}


	public String getEnderecoContato() {
		return enderecoContato;
	}


	public void setEnderecoContato(String enderecoContato) {
		this.enderecoContato = enderecoContato;
	}
	
	

}
