package modulo6;

import java.util.Scanner;

public class FormatadorTelefone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FORMATADOR E VALIDADOR DE TELEFONES ===");
        System.out.println("Digite o número de telefone:");
        String entrada = scanner.nextLine();

        processarTelefone(entrada);

        scanner.close();
    }

    public static void processarTelefone(String entrada) {
        // Remove tudo que não for dígito
        String apenasNumeros = entrada.replaceAll("\\D", "");

        int qtdDigitos = apenasNumeros.length();

        if (qtdDigitos != 8 && qtdDigitos != 9 && qtdDigitos != 10 && qtdDigitos != 11) {
            System.out.println("Erro: Entrada inválida. Quantidade de dígitos (" + qtdDigitos + ") não corresponde a um telefone válido.");
            return;
        }

        String tipo = "";
        String formatado = "";

        switch (qtdDigitos) {
            case 8:
                tipo = "Telefone Fixo (sem DDD)";
                formatado = apenasNumeros.substring(0, 4) + "-" + apenasNumeros.substring(4);
                break;
            case 9:
                tipo = "Celular (sem DDD)";
                formatado = apenasNumeros.substring(0, 5) + "-" + apenasNumeros.substring(5);
                break;
            case 10:
                tipo = "Telefone Fixo (com DDD)";
                formatado = "(" + apenasNumeros.substring(0, 2) + ") " 
                          + apenasNumeros.substring(2, 6) + "-" + apenasNumeros.substring(6);
                break;
            case 11:
                tipo = "Celular (com DDD)";
                formatado = "(" + apenasNumeros.substring(0, 2) + ") " 
                          + apenasNumeros.substring(2, 7) + "-" + apenasNumeros.substring(7);
                break;
        }

        System.out.println("Tipo detectado: " + tipo);
        System.out.println("Número formatado: " + formatado);
    }
}