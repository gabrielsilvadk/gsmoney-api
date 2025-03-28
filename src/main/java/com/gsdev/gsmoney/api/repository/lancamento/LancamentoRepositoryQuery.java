package com.gsdev.gsmoney.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gsdev.gsmoney.api.model.Lancamento;
import com.gsdev.gsmoney.api.repository.filter.LancamentoFilter;
import com.gsdev.gsmoney.api.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
    
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
