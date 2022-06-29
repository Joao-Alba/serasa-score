package br.com.serasascore.repository;

import br.com.serasascore.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);

    List<Pessoa> findAll();
}
