package modulo1;

import java.util.Scanner;

public class Modulo1Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o seu ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        int anoAtual = 2026;
        int idade = anoAtual - anoNascimento;

        System.out.println("Olá " + nome + ", você tem " + idade + " anos.");

        scanner.close();
    }    
}