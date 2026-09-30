package modulo4;

public class IngressoFamilia extends Ingresso {
    private int numeroPessoas;

    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valor, nomeFilme, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    @Override 
    public double getValorReal() {
        double total = getValor() * numeroPessoas;
        if (numeroPessoas > 3) {
            total = total * 0.95; // 5% de desconto
        }
        return total;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }    
}
