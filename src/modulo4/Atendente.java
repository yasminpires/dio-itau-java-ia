package modulo4;

public class Atendente extends Usuario {
    private double valorEmCaixa = 0.0;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false); // Administrador é sempre false
    }

    public void receberPagamentos(double valor) {
        if (valor > 0) {
            valorEmCaixa += valor;
            System.out.println("Pagamento de R$ " + valor + " recebido. Caixa atual: R$ " + valorEmCaixa);
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void fecharCaixa() {
        System.out.println("Caixa fechado com o saldo total de R$ " + valorEmCaixa);
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }
}