package com.gsdev.gsmoney.api.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gsdev.gsmoney.api.model.TipoLancamento;

public class ResumoLancamento {
    
    private Long codigo;
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private TipoLancamento tipo;
    private String categoria;
    private String pessoa;
    
    public ResumoLancamento(Long codigo, String descricao, BigDecimal valor, LocalDate dataVencimento,
            LocalDate dataPagamento, TipoLancamento tipo, String categoria, String pessoa) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.tipo = tipo;
        this.categoria = categoria;
        this.pessoa = pessoa;
    }
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public TipoLancamento getTipo() {
        return tipo;
    }
    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getPessoa() {
        return pessoa;
    }
    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
}
