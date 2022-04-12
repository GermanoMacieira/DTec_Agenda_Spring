package br.unifor.dtec.Contatos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unifor.dtec.Contatos.Entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
