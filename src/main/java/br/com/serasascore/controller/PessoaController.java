package br.com.serasascore.controller;

import br.com.serasascore.entity.Pessoa;
import br.com.serasascore.entity.dto.PessoaDto;
import br.com.serasascore.entity.dto.PessoaEnderecoDto;
import br.com.serasascore.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaEnderecoDto>> getAllPessoas() {
        List<Pessoa> pessoaList = pessoaService.getAllPessoas();

        if (pessoaList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pessoaList.stream().map(PessoaEnderecoDto::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> getAllPessoas(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.getPessoaById(id);

        if (pessoa.isPresent()) {
            return ResponseEntity.ok(new PessoaDto(pessoa.get()));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoa) {
        try {
            pessoaService.savePessoa(pessoa);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataIntegrityViolationException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
