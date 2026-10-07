package com.desafio.designpatterns.service.strategy;

import org.springframework.stereotype.Component;

@Component("CARTAO")
public class PagamentoCartao implements PagamentoStrategy {
    @Override
    public String processarPagamento(Double valor) {
        return "PAGO VIA CARTAO DE CREDITO: R$ " + valor;
    }
}