package desafios;

import java.util.Scanner;

public class ValidacaoOperacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operacao = scanner.nextLine();

        boolean operacaoValida = operacao.equals("DEPOSITO") ||
                                 operacao.equals("SAQUE") ||
                                 operacao.equals("TRANSFERENCIA");
        System.out.println(operacaoValida ? "VALID" : "INVALID");
        
        scanner.close();
    }
}