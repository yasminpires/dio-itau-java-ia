package com.itau.api_inteligente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransacaoService transacaoService;

    public TransactionController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody TransacaoDTO dto) {
        Transacao salva = transacaoService.registrarTransacao(dto);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        return ResponseEntity.ok(transacaoService.listarTodas());
    }

    @GetMapping("/resumo")
    public ResponseEntity<Map<String, Object>> obterResumoOrçamento() {
        Map<String, Object> resumo = new HashMap<>();
        resumo.put("saldoTotal", transacaoService.calcularSaldoTotal());
        resumo.put("totalTransacoes", transacaoService.listarTodas().size());
        return ResponseEntity.ok(resumo);
    }
}