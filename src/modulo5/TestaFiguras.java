package modulo5;

import java.util.ArrayList;
import java.util.List;

public class TestaFiguras {
    public static void main(String[] args) {
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Quadrado(4.0));
        figuras.add(new Retangulo(5.0, 3.0));
        figuras.add(new Circulo(2.0));

        System.out.println("=== CÁLCULO DAS ÁREAS ===");
        figuras.forEach(f -> System.out.println("Área da figura: " + f.calcularArea()));
    }
}