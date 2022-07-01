package br.com.serasascore.service;

import br.com.serasascore.entity.Pessoa;
import br.com.serasascore.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> getPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public static String calculateScore(int score) {
        if (score <= 200) return "Insuficiente";
        if (score <= 500) return "Inaceitável";
        if (score <= 700) return "Aceitável";
        return "Recomendável";
    }
}
