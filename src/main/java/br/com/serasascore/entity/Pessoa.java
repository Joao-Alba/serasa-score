package br.com.serasascore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pessoa")
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String telefone;

    @NonNull
    private int idade;

    @NonNull
    private String cidade;

    @NonNull
    private String estado;

    @NonNull
    private int score;

    public String getScoreDescricao() {
        if (this.score <= 200) return "Insuficiente";
        if (this.score <= 500) return "Inaceitável";
        if (this.score <= 700) return "Aceitável";
        return "Recomendável";
    }
}
