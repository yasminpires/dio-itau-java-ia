package com.desafio.designpatterns.controller;

import com.desafio.designpatterns.model.Pedido;
import com.desafio.designpatterns.repository.PedidoRepository;
import com.desafio.designpatterns.service.PedidoFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoFacadeService pedidoFacadeService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(
            @RequestParam String cliente,
            @RequestParam Double valor,
            @RequestParam String cep,
            @RequestParam String formaPagamento) {
        
        Pedido pedido = pedidoFacadeService.criarPedido(cliente, valor, cep, formaPagamento);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }
}