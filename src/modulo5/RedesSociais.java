package modulo5;

public class RedesSociais implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[Redes Sociais] Publicando mensagem: " + mensagem);
    }
}