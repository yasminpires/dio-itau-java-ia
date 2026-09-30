package modulo5;

import java.util.ArrayList;
import java.util.List;

public class TestaMensagens {
    public static void main(String[] args) {
        String mensagemMarketing = "Aproveite 20% de desconto na nossa loja hoje!";

        List<Notificacao> servicos = new ArrayList<>();
        servicos.add(new Sms());
        servicos.add(new Email());
        servicos.add(new RedesSociais());
        servicos.add(new WhatsApp());

        System.out.println("=== DISPARANDO MENSAGENS DE MARKETING ===");
        servicos.forEach(servico -> servico.enviar(mensagemMarketing));
    }
}