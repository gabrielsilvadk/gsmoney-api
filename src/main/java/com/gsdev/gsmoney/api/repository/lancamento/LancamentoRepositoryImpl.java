package com.gsdev.gsmoney.api.repository.lancamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.gsdev.gsmoney.api.model.Lancamento;
import com.gsdev.gsmoney.api.model.Lancamento_;
import com.gsdev.gsmoney.api.repository.filter.LancamentoFilter;
import com.gsdev.gsmoney.api.repository.projection.ResumoLancamento;

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
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
    }

    private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder,
            Root<Lancamento> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(lancamentoFilter.getDescricao())) {
            predicates.add(builder.like(
                    builder.lower(root.get(Lancamento_.descricao)), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"
            ));
        }
        if (lancamentoFilter.getDataVencimentoDe() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get(Lancamento_.dataVencimento), lancamentoFilter.getDataVencimentoDe()));

        }
        if (lancamentoFilter.getDataVencimentoAte() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get(Lancamento_.dataVencimento), lancamentoFilter.getDataVencimentoAte()));

        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    @Override
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoLancamento> criteria = builder.createQuery(ResumoLancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        criteria.select(builder.construct(ResumoLancamento.class,
                root.get(Lancamento_.codigo),
                root.get(Lancamento_.descricao),
                root.get(Lancamento_.valor),
                root.get(Lancamento_.dataVencimento),
                root.get(Lancamento_.dataPagamento),
                root.get(Lancamento_.tipo),
                root.get(Lancamento_.categoria).get("nome"),
                root.get(Lancamento_.pessoa).get("nome")));

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<ResumoLancamento> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
    }
}
