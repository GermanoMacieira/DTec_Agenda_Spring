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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class ContatoImplTest {

    public static final String GERMANO = "Germano";
    public static final String NOME_CONTATO = GERMANO;
    public static final String EMAIL_CONTATO = "germano@gmail.com";
    public static final long ID_CONTATO = 1L;
    public static final String TELEFONE_CONTATO = "33334444";
    public static final String ENDERECO_CONTATO = "Rua A, 10";
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

        Mockito.when(this.repository.findById(Mockito.anyLong())).thenReturn(Optional.of(contato));
        ContatoDto response = service.listarContato(anyLong());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(ID_CONTATO, response.getIdContato());
        Assertions.assertEquals(GERMANO, response.getNomeContato());
        Assertions.assertEquals(EMAIL_CONTATO,response.getEmailContato());
        Assertions.assertEquals(ContatoDto.class, response.getClass());
    }

    @Test
    void listarContatosCadastrados() {
        when(repository.findAll()).thenReturn(List.of(contato));
        List<Contato> response = service.listarContatosCadastrados();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(ID_CONTATO, response.get(0).getIdContato());
        assertEquals(NOME_CONTATO, response.get(0).getNomeContato());
        assertEquals(EMAIL_CONTATO, response.get(0).getEmailContato());
        assertEquals(TELEFONE_CONTATO, response.get(0).getTelefoneContato());
        assertEquals(ENDERECO_CONTATO, response.get(0).getEnderecoContato());
        assertEquals(Contato.class, response.get(0).getClass());
    }

    @Test
    void inserirContato() {
        when(repository.save(contato)).thenReturn(contato);
        Contato response = service.inserirContato(contato);

        assertNotNull(response);
        assertEquals(ID_CONTATO, response.getIdContato());
        assertEquals(NOME_CONTATO, response.getNomeContato());
        assertEquals(EMAIL_CONTATO, response.getEmailContato());
        assertEquals(TELEFONE_CONTATO, response.getTelefoneContato());
        assertEquals(ENDERECO_CONTATO, response.getEnderecoContato());
        assertEquals(Contato.class, response.getClass());
    }

    @Test
    void atualizarContato() {
        Mockito.when(this.repository.findById(1L)).thenReturn(Optional.of(contato));
        Mockito.when(this.repository.save(contato)).thenReturn(contato);
        this.service.atualizarContato(1L,contato);

        Contato response = service.inserirContato(contato);

        assertNotNull(response);
        assertEquals(ID_CONTATO, response.getIdContato());
        assertEquals(NOME_CONTATO, response.getNomeContato());
        assertEquals(EMAIL_CONTATO, response.getEmailContato());
        assertEquals(TELEFONE_CONTATO, response.getTelefoneContato());
        assertEquals(ENDERECO_CONTATO, response.getEnderecoContato());
        assertEquals(Contato.class, response.getClass());
    }

    @Test
    void apagarContato() {
        when(repository.findById(anyLong())).thenReturn(optionalContato);
        Mockito.doNothing().when(repository).deleteById(anyLong());
        service.apagarContato(anyLong());
        Mockito.verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteExcepion() {
        when(repository.findById(anyLong()))
                .thenThrow(new ObjectNotFoundExcepion("Id não encontrado!"));
        try {
            service.apagarContato(ID_CONTATO);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundExcepion.class, ex.getClass());
            assertEquals("Id não encontrado!", ex.getMessage());
        }
    }

    private void startContato() {
        contato = new Contato(ID_CONTATO, NOME_CONTATO, EMAIL_CONTATO, TELEFONE_CONTATO,
                ENDERECO_CONTATO);
        contatoDto = new ContatoDto(contato);
        optionalContato = Optional.of(contato);
       // when(repository.getById(Mockito.anyLong())).thenReturn(contato);

    }
}

