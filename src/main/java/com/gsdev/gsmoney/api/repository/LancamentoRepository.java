package com.gsdev.gsmoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsdev.gsmoney.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
    
}
