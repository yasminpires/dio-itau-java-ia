package com.itau.api_inteligente;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public Transacao registrarTransacao(TransacaoDTO dto) {
        Transacao transacao = new Transacao(
                sequence.getAndIncrement(),
                dto.getDescricao(),
                dto.getValor(),
                dto.getTipo(),
                dto.getCategoria() != null ? dto.getCategoria() : "Geral"
        );
        transacoes.add(transacao);
        return transacao;
    }

    public List<Transacao> listarTodas() {
        return new ArrayList<>(transacoes);
    }

    public BigDecimal calcularSaldoTotal() {
        BigDecimal totalReceitas = transacoes.stream()
                .filter(t -> t.getTipo() == TipoTransacao.RECEITA)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesas = transacoes.stream()
                .filter(t -> t.getTipo() == TipoTransacao.DESPESA)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalReceitas.subtract(totalDespesas);
    }
}