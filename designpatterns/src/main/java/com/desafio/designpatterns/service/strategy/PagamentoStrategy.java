package com.desafio.designpatterns.service.strategy;

public interface PagamentoStrategy {
    String processarPagamento(Double valor);
}