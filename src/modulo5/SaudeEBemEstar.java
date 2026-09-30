package modulo5;

public class SaudeEBemEstar implements Tributavel {
    private double valor;

    public SaudeEBemEstar(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.015;
    }
}