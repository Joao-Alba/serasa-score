package br.com.serasascore.controller;

import br.com.serasascore.entity.Pessoa;
import br.com.serasascore.entity.dto.PessoaDto;
import br.com.serasascore.entity.dto.PessoaEnderecoDto;
import br.com.serasascore.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaEnderecoDto>> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> getAllPessoas(@PathVariable Long id) {
        return pessoaService.getPessoaById(id);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> savePessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.savePessoa(pessoa);
    }
}
