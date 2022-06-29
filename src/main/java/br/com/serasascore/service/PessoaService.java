package br.com.serasascore.service;

import br.com.serasascore.entity.Pessoa;
import br.com.serasascore.entity.dto.PessoaDto;
import br.com.serasascore.entity.dto.PessoaEnderecoDto;
import br.com.serasascore.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public ResponseEntity<PessoaDto> savePessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<PessoaDto> getPessoaById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isPresent()) {
            return ResponseEntity.ok(new PessoaDto(pessoa.get()));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<List<PessoaEnderecoDto>> getAllPessoas() {
        List<Pessoa> pessoaList = pessoaRepository.findAll();

        if (pessoaList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pessoaList.stream().map(PessoaEnderecoDto::new).collect(Collectors.toList()));
    }
}
