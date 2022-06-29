package br.com.serasascore.entity.dto;

import br.com.serasascore.entity.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaDto {

    private String nome;
    private String telefone;
    private int idade;
    private String scoreDescricao;

    public PessoaDto(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
        this.idade = pessoa.getIdade();
        this.scoreDescricao = pessoa.getScoreDescricao();
    }
}
