package modulo6;

import java.util.Scanner;

public class CalculadoraVirgula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA (SOMA E SUBTRAÇÃO) ===");
        System.out.println("Digite todos os números separados por vírgula (ex: 10, -5, 20, -2):");
        String entrada = scanner.nextLine();

        String[] partes = entrada.split(",");
        double soma = 0;
        double subtracao = 0;
        boolean primeiro = true;

        for (String parte : partes) {
            try {
                double num = Double.parseDouble(parte.trim());
                soma += num;

                if (primeiro) {
                    subtracao = num;
                    primeiro = false;
                } else {
                    subtracao -= num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Aviso: '" + parte.trim() + "' não é um número válido e foi ignorado.");
            }
        }

        System.out.println("\nResultado da Soma de todos os números: " + soma);
        System.out.println("Resultado da Subtração sequencial: " + subtracao);

        scanner.close();
    }
}