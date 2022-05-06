package br.unifor.dtec.contatos.service.impl;

import br.unifor.dtec.contatos.model.Contato;
import br.unifor.dtec.contatos.model.dto.ContatoDto;
import br.unifor.dtec.contatos.repository.ContatoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContatoImplTest {

    @InjectMocks    // Precisa de uma instância real;
    private ContatoImpl service;

    @Mock   // Simulação do repository;
    ContatoRepository repository;

    private Contato contato;
    private ContatoDto contatoDto;
    private Optional<Contato> optionalContato;

    //private List<Contato> listaContato ;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startContato();
    }

    @Test
    void listarContato() {
        Long ID= 1L;

        ContatoDto response = service.listarContato(ID);
        Assertions.assertEquals(ContatoDto.class, response.getClass());
    }

    @Test
    void listarContatosCadastrados() {
        when(repository.findAll()).thenReturn(List.of(contato));
        List<Contato> response = service.listarContatosCadastrados();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Contato.class, response.get(0).getClass());
    }

    @Test
    void inserirContato() {
        when(repository.save(contato)).thenReturn(contato);
        Contato response = service.inserirContato(contato);

        assertNotNull(response);
        assertEquals(Contato.class, response.getClass());
    }

    @Test
    void atualizarContato() {
        when(repository.saveAndFlush(any())).thenReturn(contato);
        Contato response = service.atualizarContato(Mockito.anyLong(), optionalContato);

        assertNotNull(response);
        assertEquals(Contato.class, response.getClass());
    }

    @Test
    void apagarContato() {

    }

    private void startContato() {
        contato = new Contato(1L, "Germano", "germano@gmail.com", "33334444",
                "Rua A, 10");
        contatoDto = new ContatoDto(contato);
        optionalContato = Optional.of(contato);
       // when(repository.getById(Mockito.anyLong())).thenReturn(contato);

    }
}

