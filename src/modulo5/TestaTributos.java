package modulo5;

import java.util.ArrayList;
import java.util.List;

public class TestaTributos {
    public static void main(String[] args) {
        List<Tributavel> produtos = new ArrayList<>();
        produtos.add(new Alimentacao(100.0));
        produtos.add(new SaudeEBemEstar(100.0));
        produtos.add(new Vestuario(100.0));
        produtos.add(new Cultura(100.0));

        System.out.println("=== CÁLCULO DE TRIBUTOS ===");
        produtos.forEach(p -> System.out.println("Imposto do produto: R$ " + p.calcularImposto()));
    }
}