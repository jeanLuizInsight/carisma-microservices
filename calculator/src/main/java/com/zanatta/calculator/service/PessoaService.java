package com.zanatta.calculator.service;

import com.zanatta.calculator.model.Pessoa;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    public Pessoa buscarPeloId(Long id) {
        return new Pessoa();
    }

    public Pessoa criar(Pessoa pessoa) {
        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        return pessoa;
    }

    public void excluir(Long id) {
    }
}
