package modulo5;

public class WhatsApp implements Notificacao {
    @Override 
    public void enviar(String mensagem){
        System.out.println("[WhatsApp] Enviando mensagem: " + mensagem);
    }
}