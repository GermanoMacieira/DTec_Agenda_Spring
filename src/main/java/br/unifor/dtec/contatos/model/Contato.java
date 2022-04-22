package br.unifor.dtec.contatos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		//Anotação do JPA que indica que a classe será uma entidade no banco (será uma tabela no banco de dados);
@Table(name = "tb_contato")	//Anotação do JPA que nomeia o nome da tabela no banco;
public class Contato {
	
	// ATRIBUTOS:
	@Id		// Anotação que indica informa que o atributo será a chave primária da tabela;
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Anotação que indica o Auto incremento do id na tabela do banco de dados;
	private Long idContato;
	// @NotEmpty(message = "Nome do contato é obrigatório")
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
