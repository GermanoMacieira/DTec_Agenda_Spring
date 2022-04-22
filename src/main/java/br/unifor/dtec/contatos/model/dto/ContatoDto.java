package br.unifor.dtec.contatos.model.dto;

import br.unifor.dtec.contatos.model.Contato;
/* DTO = data transfer object;
 * OBS: Não é uma boa prática devolver os dados das entidades/modelos (classe de domínio);
 * Geralmente, controi-se uma classe secundária(DTO) para retornar as informações apropriadas e com mais segurança.
 * Por exemplo, caso se tenha uma entidade contendo dados sensíveis, como senha, cpf, etc, não se retorna esses dados!
 * No exemplo abaixo, foi preservado o número do cpf;
 * No construtor, observa-se que a classe dto recebe como parâmetro a entidade inteira, porém escolhe-se somente os 
 * atributos desejados;
 */
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
