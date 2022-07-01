package br.com.serasascore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private int score;

    public String getScoreDescricao() {
        if (this.score <= 200) return "Insuficiente";
        if (this.score <= 500) return "Inaceitável";
        if (this.score <= 700) return "Aceitável";
        return "Recomendável";
    }
}
