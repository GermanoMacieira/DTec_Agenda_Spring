package br.unifor.dtec.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.dtec.contatos.model.Contato;
import br.unifor.dtec.contatos.model.dto.ContatoDto;
import br.unifor.dtec.contatos.service.ContatoService;

/* A camada de controle é responsável por intermediar as requisições enviadas pelo View com as respostas 
 * fornecidas pelo Model, processando os dados que o usuário informou e repassando para outras camadas.
 * Observe que a classe ContatoController utiliza-se em seus métodos (GET, POST, DELETE e UPDATE) funções
 * provenientes da interface CotatoService, que por sua vez possuem somente as assinaturas dessas funções;
 */

@RestController		// Anotação do JPA que indica um controlador Rest: vai responder por requisições;
@RequestMapping(value = "/contatos")
public class ContatoController {
	
	@Autowired		// Anotação do JPA que indica "injeção de dependência". Instancia automaticamente;
	private ContatoService contatoService;
	
	// END POINTS:
	// ==========
	
	// Listar todos:
	@GetMapping	(value = "/list")	// Anotação do JPA que indica o "verbo" http, no caso, é um GET/id;	// Anotação do JPA que indica o "verbo" http, no caso, é um GET;
	public List<Contato> listarContatosCadastrados() {
		return this.contatoService.listarContatosCadastrados();
	}
	
	// Listar contato por id:
	@GetMapping	("{idContato}")	// Anotação do JPA que indica o "verbo" http, no caso, é um GET/id;
	public ContatoDto listarContato(@PathVariable("idContato") long idContato) {
		return this.contatoService.listarContato(idContato);
	}
	
	// Cadastrar contato:
	@PostMapping(value = "/list/new")	// Anotação do JPA que indica o "verbo" http, no caso, é um POST;
	public Contato inserirContato(@RequestBody Contato contato) {
		return this.contatoService.inserirContato(contato);
	}
	
	// Excluir contato por id:
	@DeleteMapping("/delete/{idContato}")	// Anotação do JPA que indica o "verbo" http, no caso, é um DELETE/id;
	public void apagarContato(@PathVariable("idContato") Long idContato) {
		this.contatoService.apagarContato(idContato);
		
	}
	
	// Atualizar contato por id:
	@PutMapping(value = "/update/{idContato}")	// Anotação do JPA que indica o "verbo" http, no caso, é um POST;
	public void atualizarContato(@PathVariable("idContato") long idContato, @RequestBody Contato contato) {
		this.contatoService.atualizarContato(idContato, contato);
		
	}

}
