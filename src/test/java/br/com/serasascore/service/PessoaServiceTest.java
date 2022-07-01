package br.com.serasascore.service;

import br.com.serasascore.entity.Pessoa;
import br.com.serasascore.repository.PessoaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository repository;

    @Test
    public void savePessoaTest() {
        Pessoa pessoa = new Pessoa();
        service.savePessoa(pessoa);
        Mockito.verify(repository, Mockito.times(1)).save(pessoa);
    }

    @Test
    public void getPessoaByIdTeste() {
        service.getPessoaById(1L);
        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void getAllPessoasTeste() {
        Mockito.verifyNoInteractions(repository);
        service.getAllPessoas();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldCalculateScoreDescricao() {
        Pessoa pessoa = new Pessoa(1L, "nome", "telefone", 1, "cidaed", "estado", 172);
        assertEquals(PessoaService.calculateScore(pessoa.getScore()), "Insuficiente");

        pessoa.setScore(367);
        assertEquals(PessoaService.calculateScore(pessoa.getScore()), "Inaceitável");

        pessoa.setScore(692);
        assertEquals(PessoaService.calculateScore(pessoa.getScore()), "Aceitável");

        pessoa.setScore(885);
        assertEquals(PessoaService.calculateScore(pessoa.getScore()), "Recomendável");
    }
}