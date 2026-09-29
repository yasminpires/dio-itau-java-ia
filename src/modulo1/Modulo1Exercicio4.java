package modulo1;

import java.util.Scanner;

public class Modulo1Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dados da primeira pessoa
        System.out.println("Digite o nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();

        System.out.println("Digite a idade de " + nome1 + ": ");
        int idade1 = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner após ler o número

        // Dados da segunda pessoa
        System.out.println("\n Digite o nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();

        System.out.println("Digite a idade de " + nome2 + ": ");
        int idade2 = scanner.nextInt();

        // Calculando a diferença de idade com Math.abs (para o resultado não dar negativo)
        int diferenca = Math.abs(idade1 - idade2);

        System.out.println("\nA diferença de idade entre " + nome1 + " e " + nome2 + " é de " + diferenca + " anos.");

        scanner.close();
    }
}