package br.unifor.dtec.contatos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.dtec.contatos.model.Contato;
import br.unifor.dtec.contatos.model.dto.ContatoDto;
import br.unifor.dtec.contatos.repository.ContatoRepository;
import br.unifor.dtec.contatos.service.ContatoService;

/* Classe que faz a implementação dos métodos assinados na interface ContatoService.
 * Ela herda da interface seus métodos e aqui são feitas as implementações pertinentes;
 */

@Service
public class ContatoImpl implements ContatoService {

	@Autowired // Anotação do JPA que indica "injeção de dependência". Instancia automaticamente;
	private ContatoRepository repository;

	@Override
	public ContatoDto listarContato(long idContato) {
			ContatoDto contato = new ContatoDto(repository.getById(idContato));
			return contato;
	}
	
	@Override
	public List<Contato> listarContatosCadastrados() {
		return this.repository.findAll();
	}

	@Override
	public Contato inserirContato(Contato contato) {
		return this.repository.save(contato);
	}

	@Override
	public void atualizarContato(long idContato, Contato contato) {
		Optional<Contato> cadastrar = repository.findById(idContato);

		if (cadastrar.isPresent()) {
			cadastrar.get().setIdContato(contato.getIdContato());
			cadastrar.get().setNomeContato(contato.getNomeContato());
			repository.save(cadastrar.get());
		}

	}

	@Override
	public void apagarContato(long idContato) { 
		try {
			this.repository.deleteById(idContato); 
		} catch(Exception e){
			System.out.println("Id não encontrado!");
		
		}
		
	}
	
}
