package modulo5;

public class Sms implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[SMS] Enviando mensagem: " + mensagem);
    }
}