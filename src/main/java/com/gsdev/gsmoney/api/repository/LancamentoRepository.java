package com.gsdev.gsmoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsdev.gsmoney.api.model.Lancamento;
import com.gsdev.gsmoney.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{
    
}
