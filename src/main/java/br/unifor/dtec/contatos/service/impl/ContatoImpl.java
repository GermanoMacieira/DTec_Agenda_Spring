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

	@Autowired // Anotação do JPA que indica "injeção de dependência". Instancia
				// automaticamente;
	private ContatoRepository repository;


	@Override
	public ContatoDto listarContato(long idContato) {
		Optional<Contato> optionalContato = this.repository.findById(idContato);
		return new ContatoDto(optionalContato.get());
	}

	/*
	// OUTRA FORMA DE CONSTRUÇÃO DO MÉTODO:
	@Override
	public ContatoDto listarContato(long id) {
		Optional<Contato> optionalContato = this.repository.findById(id);
		return optionalContato.map(x -> new ContatoDto(optionalContato.get()));

	 */

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
		Optional<Contato> optionalContato = repository.findById(idContato);

		if (optionalContato.isPresent()) {
			optionalContato.get().setIdContato(contato.getIdContato());
			optionalContato.get().setNomeContato(contato.getNomeContato());
			optionalContato.get().setEnderecoContato(contato.getEnderecoContato());
			optionalContato.get().setTelefoneContato(contato.getTelefoneContato());
			repository.saveAndFlush(optionalContato.get());
		}

	}

	@Override
	public void apagarContato(long idContato) { 
		try {
			this.repository.deleteById(idContato); 
		} catch(Exception ex){
			System.out.println("Id não encontrado!");
		
		}
		
	}
	
}
