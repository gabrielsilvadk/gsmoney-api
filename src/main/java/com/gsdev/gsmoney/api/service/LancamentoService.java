package com.gsdev.gsmoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsdev.gsmoney.api.model.Lancamento;
import com.gsdev.gsmoney.api.model.Pessoa;
import com.gsdev.gsmoney.api.repository.LancamentoRepository;
import com.gsdev.gsmoney.api.repository.PessoaRepository;
import com.gsdev.gsmoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }

}
