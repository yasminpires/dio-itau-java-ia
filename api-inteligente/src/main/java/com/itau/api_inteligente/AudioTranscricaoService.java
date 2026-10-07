package com.itau.api_inteligente;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Service
public class AudioTranscricaoService {

    private final TransacaoService transacaoService;

    public AudioTranscricaoService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public String transcreverAudio(MultipartFile file) {
        if (file.isEmpty()) {
            return "Erro: Nenhum arquivo de áudio foi enviado.";
        }
        
        String nomeArquivo = file.getOriginalFilename();
        return "Áudio '" + nomeArquivo + "' processado com sucesso. Transcrição simulação: 'Gastei 50 reais no mercado'.";
    }

    public String processarComandoTexto(String comando) {
        String comandoLc = comando.toLowerCase();

        if (comandoLc.contains("gastei") || comandoLc.contains("comprei") || comandoLc.contains("paguei")) {
            TransacaoDTO dto = new TransacaoDTO("Gasto via Voz/IA", new BigDecimal("50.00"), TipoTransacao.DESPESA, "Alimentacao");
            Transacao salva = transacaoService.registrarTransacao(dto);
            return "Transação registrada com sucesso: " + salva.getDescricao() + " no valor de R$ " + salva.getValor();
        } else if (comandoLc.contains("recebi") || comandoLc.contains("ganhei") || comandoLc.contains("deposito")) {
            TransacaoDTO dto = new TransacaoDTO("Recebimento via Voz/IA", new BigDecimal("100.00"), TipoTransacao.RECEITA, "Renda");
            Transacao salva = transacaoService.registrarTransacao(dto);
            return "Receita registrada com sucesso: R$ " + salva.getValor();
        } else if (comandoLc.contains("saldo")) {
            return "Seu saldo atual é de R$ " + transacaoService.calcularSaldoTotal();
        }

        return "Comando recebido: '" + comando + "'. Assistente pronto para registrar receitas, despesas ou consultar o saldo.";
    }
}