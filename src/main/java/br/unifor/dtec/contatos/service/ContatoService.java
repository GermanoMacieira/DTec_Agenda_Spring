package br.unifor.dtec.contatos.service;

import java.util.List;

import br.unifor.dtec.contatos.model.Contato;
import br.unifor.dtec.contatos.model.dto.ContatoDto;

// Classe que contém as assinaturas dos métodos:
public interface ContatoService {
		
	List<Contato> listarContatosCadastrados();
	ContatoDto listarContato(long idContato);
	Contato inserirContato(Contato contato);
	void atualizarContato(long idContato, Contato contato);
	void apagarContato(long idContato);
	
}
