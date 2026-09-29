package modulo2;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o númeor inicial: ");
        int numeroInicial = scanner.nextInt();

        System.out.println("\nAgora digite outros números.");
        System.out.println("O programa vai continuar enquanto os números forem múltiplos de " + numeroInicial + ".");
        System.out.println("(Números menores que " + numeroInicial + " serão ignorados)\n");

        while (true) {
            System.out.println("Digite um número: ");
            int numeroAtual = scanner.nextInt();

            // Regra 1: Números menores que o primeiro são ignorados
            if (numeroAtual < numeroInicial) {
                System.out.println("-> Número menos que o inicial (" + numeroInicial + "). Ignorado!");
                continue; // volta para o início do loop sem parar o programa
            }

            // Regra 2: Verifica se o resto da divisão é diferente de 0
            if (numeroAtual % numeroInicial !=0) {
                System.out.println("-> O número " + numeroAtual + " dividido por " + numeroInicial + " tem resto DIFERENTE de 0!");
                System.out.println("Programa encerrado.");
                break; // Para o loop e encerra a execução
            }

            System.out.println("-> " + numeroAtual + " é múltiplo de " + numeroInicial + ". Continue!");
        }

    scanner.close();
  }
}
