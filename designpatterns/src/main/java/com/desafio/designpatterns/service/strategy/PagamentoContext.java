package com.desafio.designpatterns.service.strategy;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PagamentoContext {

    private final Map<String, PagamentoStrategy> estrategias;

    public PagamentoContext(Map<String, PagamentoStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    public String executarPagamento(String tipo, Double valor) {
        if (tipo == null) {
            throw new IllegalArgumentException("A forma de pagamento não pode ser nula");
        }

        // Tenta encontrar por busca direta ou ignorando maiúsculas e minúsculas
        PagamentoStrategy strategy = estrategias.get(tipo);

        if (strategy == null) {
            for (Map.Entry<String, PagamentoStrategy> entry : estrategias.entrySet()) {
                String key = entry.getKey().toUpperCase();
                String target = tipo.toUpperCase();
                
                if (key.equals(target) || key.equals("PAGAMENTO" + target) || key.contains(target)) {
                    strategy = entry.getValue();
                    break;
                }
            }
        }

        if (strategy == null) {
            throw new IllegalArgumentException("Forma de pagamento não suportada: " + tipo);
        }

        return strategy.processarPagamento(valor);
    }
}