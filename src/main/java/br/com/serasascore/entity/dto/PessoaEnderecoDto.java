package br.com.serasascore.entity.dto;

import br.com.serasascore.entity.Pessoa;
import br.com.serasascore.service.PessoaService;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaEnderecoDto {

    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;

    public PessoaEnderecoDto(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.cidade = pessoa.getCidade();
        this.estado = pessoa.getEstado();
        this.scoreDescricao = PessoaService.calculateScore(pessoa.getScore());
    }
}
