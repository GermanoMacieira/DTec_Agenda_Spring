package br.unifor.dtec.Contatos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.dtec.Contatos.Entity.Contato;
import br.unifor.dtec.Contatos.Repository.ContatoRepository;

@RestController		// Anotação do JPA que indica um controlador Rest: vai responder por requisições;
@RequestMapping(value = "/contatos")
public class ContatoController {
	
	@Autowired	// Anotação do JPA que indica "injeção de dependência". Instancia automaticamente;
	private ContatoRepository repository;
	
	@GetMapping		// Anotação do JPA que indica o "verbo" http, no caso, é um GET;
	public List<Contato> findAll() {
		List<Contato> resultado = repository.findAll();
		return resultado;
	}
	
	@GetMapping	(value = "/{id}")	// Anotação do JPA que indica o "verbo" http, no caso, é um GET/id;
	public Contato findById(@PathVariable Long id) {
		Contato resultado = repository.findById(id).get();
		return resultado;
	}
	
	@PostMapping	(value = "/{id}")	// Anotação do JPA que indica o "verbo" http, no caso, é um POST;
	public Contato insert(@RequestBody Contato contato) {
		Contato resultado = repository.save(contato);
		return resultado;
	}

}
