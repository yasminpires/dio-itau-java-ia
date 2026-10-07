package com.itau.api_inteligente;

import java.math.BigDecimal;

public class TransacaoDTO {

    private String descricao;
    private BigDecimal valor;
    private TipoTransacao tipo;
    private String categoria;

    public TransacaoDTO() {}

    public TransacaoDTO(String descricao, BigDecimal valor, TipoTransacao tipo, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public TipoTransacao getTipo() { return tipo; }
    public void setTipo(TipoTransacao tipo) { this.tipo = tipo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}