package modulo5;

public class Email implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[E-mail] Enviando mensagem: " + mensagem);
    }
}