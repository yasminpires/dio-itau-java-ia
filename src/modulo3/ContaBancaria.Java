package modulo3;

import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double usoChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        // Se <= R$ 500, cheque especial de R$ 50. Acima de 500, 50% do valor depositado
        if (depositoInicial <= 500.0) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.50;
        }
        this.usoChequeEspecial = 0.0;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f\n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f | Em uso: R$ %.2f\n", 
            limiteChequeEspecial, usoChequeEspecial);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        
        // Cobra taxa de 20% do valor usado do cheque especial, se houver
        if (usoChequeEspecial > 0) {
            double taxa = usoChequeEspecial * 0.20;
            System.out.printf("Taxa cobrada pelo uso do cheque especial (20%%): R$ %.2f\n", taxa);
            valor -= taxa;
            
            if (valor < 0) {
                usoChequeEspecial += Math.abs(valor);
                System.out.println("O valor do depósito não cobriu a taxa do cheque especial.");
                return;
            }
        }

        // Abate o valor usado no cheque especial
        if (usoChequeEspecial > 0) {
            if (valor >= usoChequeEspecial) {
                valor -= usoChequeEspecial;
                usoChequeEspecial = 0;
            } else {
                usoChequeEspecial -= valor;
                valor = 0;
            }
        }

        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }

        double totalDisponivel = saldo + (limiteChequeEspecial - usoChequeEspecial);
        if (valor > totalDisponivel) {
            System.out.println("Saldo e cheque especial insuficientes para este saque.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
        } else {
            double restante = valor - saldo;
            saldo = 0;
            usoChequeEspecial += restante;
        }
        System.out.println("Saque realizado com sucesso!");
    }

    public void pagarBoleto(double valor) {
        System.out.println("Efetuando pagamento de boleto...");
        sacar(valor);
    }

    public void verificarUsoChequeEspecial() {
        if (usoChequeEspecial > 0) {
            System.out.printf("A conta ESTÁ utilizando o cheque especial (R$ %.2f em uso).\n", usoChequeEspecial);
        } else {
            System.out.println("A conta NÃO está utilizando o cheque especial.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o valor do depósito inicial para abrir a conta: R$ ");
        double depositoInicial = scanner.nextDouble();
        ContaBancaria conta = new ContaBancaria(depositoInicial);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU CONTA BANCÁRIA ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar se está usando cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> conta.consultarSaldo();
                case 2 -> conta.consultarChequeEspecial();
                case 3 -> {
                    System.out.print("Digite o valor para depósito: R$ ");
                    conta.depositar(scanner.nextDouble());
                }
                case 4 -> {
                    System.out.print("Digite o valor para saque: R$ ");
                    conta.sacar(scanner.nextDouble());
                }
                case 5 -> {
                    System.out.print("Digite o valor do boleto: R$ ");
                    conta.pagarBoleto(scanner.nextDouble());
                }
                case 6 -> conta.verificarUsoChequeEspecial();
                case 0 -> System.out.println("Encerrando o sistema da conta bancária...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}