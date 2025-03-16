package com.gsdev.gsmoney.api.repository.lancamento;

import java.util.List;

import com.gsdev.gsmoney.api.model.Lancamento;
import com.gsdev.gsmoney.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
    
    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

    
}
