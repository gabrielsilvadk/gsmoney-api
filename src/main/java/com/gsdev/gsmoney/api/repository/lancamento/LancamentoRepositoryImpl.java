package com.gsdev.gsmoney.api.repository.lancamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gsdev.gsmoney.api.model.Lancamento;
import com.gsdev.gsmoney.api.repository.filter.LancamentoFilter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
                criteria.where(predicates);
        
        
                TypedQuery<Lancamento> query = manager.createQuery(criteria);
                return query.getResultList();
            }
        
            private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder,
                    Root<Lancamento> root) {
                    
                    List<Predicate> predicates = new ArrayList<>();

                    if(!StringUtils.hasText(lancamentoFilter.getDescricao())){
                        predicates.add(builder.like(
                            builder.lower(root.get("descricao")), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"
                        ));
                    }
                    if(lancamentoFilter.getDataVencimentoDe() != null){

                    }
                    if (lancamentoFilter.getDataVencimentoAte() != null) {
                        
                    }
                    return predicates.toArray(new Predicate[predicates.size()]);
            }
}
