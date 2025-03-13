package com.gsdev.gsmoney.api.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gsdev.gsmoney.api.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long codigo);

    Pessoa save(Optional<Pessoa> pessoaSalva);
    
}
