package br.unifor.dtec.contatos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unifor.dtec.contatos.entity.Contato;
import br.unifor.dtec.contatos.entity.dto.ContatoDto;
import br.unifor.dtec.contatos.repository.ContatoRepository;
import br.unifor.dtec.contatos.service.impl.ContatoImpl;

@Service
public class ContatoService implements ContatoImpl{

	@Autowired	// Anotação do JPA que indica "injeção de dependência". Instancia automaticamente;
	private ContatoRepository repository;
	
	@Override
	public ContatoDto listarContatosCadastrados(long idContato) {
		ContatoDto contato = new ContatoDto(repository.getById(idContato));
		return contato;
	}

	@Override
	public List<Contato> listarContato() {
		return this.repository.findAll();
		}

	@Override
	public Contato inserirContato(Contato contato) {
		return this.repository.save(contato);
	}

	@Override
	public void atualizarContato(long idContato, Contato contato) {
		Optional<Contato> cadastrar = repository.findById(idContato);
		if(cadastrar.isPresent()) {
			cadastrar.get().setIdContato(contato.getIdContato());
			cadastrar.get().setNomeContato(contato.getNomeContato());
			repository.save(cadastrar.get());
		}
		
	}

	@Override
	public void apagarContato(long idContato) {
		this.repository.deleteById(idContato);
		
	}

}
