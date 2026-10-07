package com.desafio.designpatterns.service.strategy;

import org.springframework.stereotype.Component;

@Component("PIX")
public class PagamentoPix implements PagamentoStrategy {

    @Override
    public String processarPagamento(Double valor) {
        double valorComDesconto = valor * 0.90;
        return "PAGO VIA PIX COM 10% DE DESCONTO: R$ " + valorComDesconto;
    }
}