package br.unifor.dtec.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifor.dtec.contatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
