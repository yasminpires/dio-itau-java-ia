package modulo2;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número (menor): ");
        int inicio = scanner.nextInt();

        System.out.println("Digite o segundo número (maior que o primeiro): ");
        int fim = scanner.nextInt();

        // Garantir que o segundo número seja maior que o primeiro
        if (fim <= inicio) {
            System.out.println("Erro: O segundo número precisa ser maior que o primeiro!");
            scanner.close();
            return; // Encerra o programa se o usuário digitar errado
        }

        System.out.println("\nEscolha o tipo de número desejado:");
        System.out.println("1 - Pares");
        System.out.println("2 - Ímpares");
        System.out.println("Opção: ");
        int opcao = scanner.nextInt();

        System.out.println("\n--- Resultado em ordem decrescente---");

        // O loop começa no maior número ('fim') e vai voltando até o menor número ('inicio')
        for (int i = fim; i >= inicio; i--) {
            if (opcao == 1 && i % 2 == 0){
                // Opção 1: Queremos PARES (resto da divisão por 2 é zero)
                System.out.println(i);
            } else if (opcao == 2 && i % 2 != 0) {
                // Opção 2: Queremos ÍMPARES (resto da divisão por 2 é difetente do zero)
                System.out.println(i);
            }
        }
        
        scanner.close();
    }
}