package br.unifor.dtec.contatos.service.impl;

import java.util.List;

import br.unifor.dtec.contatos.entity.Contato;
import br.unifor.dtec.contatos.entity.dto.ContatoDto;

// Classe que contém as assinaturas dos métodos:
public interface ContatoImpl {
	
	ContatoDto listarContatosCadastrados(long idContato);
	List<Contato> listarContato();
	Contato inserirContato(Contato contato);
	void atualizarContato(long idContato, Contato contato);
	void apagarContato(long idContato);
	
}
