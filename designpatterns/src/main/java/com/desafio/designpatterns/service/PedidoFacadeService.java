package com.desafio.designpatterns.service;

import com.desafio.designpatterns.model.Endereco;
import com.desafio.designpatterns.model.Pedido;
import com.desafio.designpatterns.repository.EnderecoRepository;
import com.desafio.designpatterns.repository.PedidoRepository;
import com.desafio.designpatterns.service.strategy.PagamentoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoFacadeService {

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoContext pagamentoContext;

    public Pedido criarPedido(String cliente, Double valor, String cep, String formaPagamento) {
        // 1. Procura o endereço na base de dados ou consulta o ViaCEP
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.buscarCep(cep);
            return enderecoRepository.save(novoEndereco);
        });

        // 2. Processa o pagamento via Strategy
        String statusPagamento = pagamentoContext.executarPagamento(formaPagamento, valor);

        // 3. Cria e salva o pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setValor(valor);
        pedido.setFormaPagamento(formaPagamento);
        pedido.setStatusPagamento(statusPagamento);
        pedido.setEnderecoEntrega(endereco);

        return pedidoRepository.save(pedido);
    }
}