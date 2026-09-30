package modulo3;

import java.util.Scanner;

public class PetShop {
    private int agua = 0; // máximo 10L
    private int shampoo = 0; // máximo 2L
    private boolean petNaMaquina = false;
    private int banhosRealizados = 0;
    private boolean maquinaSuja = false;

    public void abastecerAgua(int quantidade) {
        if (quantidade > 2) {
            System.out.println("Só é possível abastecer no máximo 2 litros de água por vez.");
            return;
        }
        if (agua + quantidade > 10) {
            System.out.println("Capacidade máxima de água atingida (10L). Água atual: " + agua + "L");
        } else {
            agua += quantidade;
            System.out.println("Abastecido com sucesso! Água atual: " + agua + "L");
        }
    }

    public void abastecerShampoo(int quantidade) {
        if (quantidade > 2) {
            System.out.println("Só é possível abastecer no máximo 2 litros de shampoo por vez.");
            return;
        }
        if (shampoo + quantidade > 2) {
            System.out.println("Capacidade máxima de shampoo atingida (2L). Shampoo atual: " + shampoo + "L");
        } else {
            shampoo += quantidade;
            System.out.println("Abastecido com sucesso! Shampoo atual: " + shampoo + "L");
        }
    }

    public void colocarPet() {
        if (petNaMaquina) {
            System.out.println("Já existe um pet dentro da máquina.");
        } else {
            petNaMaquina = true;
            System.out.println("Pet colocado na máquina com sucesso!");
        }
    }

    public void retirarPet() {
        if (!petNaMaquina) {
            System.out.println("Não há nenhum pet na máquina.");
        } else {
            petNaMaquina = false;
            System.out.println("Pet retirado da máquina!");
        }
    }

    public void darBanho() {
        if (!petNaMaquina) {
            System.out.println("Não é possível dar banho: coloque o pet na máquina primeiro.");
            return;
        }
        if (maquinaSuja) {
            System.out.println("A máquina está suja! Faça a limpeza antes de dar outro banho.");
            return;
        }
        if (agua < 10) {
            System.out.println("Água insuficiente para o banho. Necessário 10L (Atual: " + agua + "L).");
            return;
        }
        if (shampoo < 2) {
            System.out.println("Shampoo insuficiente para o banho. Necessário 2L (Atual: " + shampoo + "L).");
            return;
        }

        agua -= 10;
        shampoo -= 2;
        banhosRealizados++;
        System.out.println("Banho concluído com sucesso!");

        if (banhosRealizados % 3 == 0) {
            maquinaSuja = true;
            System.out.println("A máquina atingiu 3 banhos e agora precisa de limpeza!");
        }
    }

    public void limparMaquina() {
        if (!maquinaSuja) {
            System.out.println("A máquina já está limpa.");
            return;
        }
        if (agua < 3 || shampoo < 1) {
            System.out.println("Insumos insuficientes para limpar a máquina (Necessário: 3L de água e 1L de shampoo).");
            return;
        }

        agua -= 3;
        shampoo -= 1;
        maquinaSuja = false;
        System.out.println("Máquina limpa com sucesso!");
    }

    public void verificarStatus() {
        System.out.println("\n--- STATUS DA MÁQUINA ---");
        System.out.println("Água: " + agua + "L / 10L");
        System.out.println("Shampoo: " + shampoo + "L / 2L");
        System.out.println("Pet na máquina: " + (petNaMaquina ? "Sim" : "Não"));
        System.out.println("Banhos realizados: " + banhosRealizados);
        System.out.println("Status da máquina: " + (maquinaSuja ? "Suja (precisa de limpeza)" : "Limpa"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetShop maquina = new PetShop();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU MÁQUINA DE BANHO PET SHOP ===");
            System.out.println("1 - Colocar pet na máquina");
            System.out.println("2 - Retirar pet da máquina");
            System.out.println("3 - Abastecer água (máx 2L)");
            System.out.println("4 - Abastecer shampoo (máx 2L)");
            System.out.println("5 - Dar banho no pet");
            System.out.println("6 - Limpar máquina");
            System.out.println("7 - Verificar status da máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> maquina.colocarPet();
                case 2 -> maquina.retirarPet();
                case 3 -> {
                    System.out.print("Quantidade de água a abastecer (litros): ");
                    maquina.abastecerAgua(scanner.nextInt());
                }
                case 4 -> {
                    System.out.print("Quantidade de shampoo a abastecer (litros): ");
                    maquina.abastecerShampoo(scanner.nextInt());
                }
                case 5 -> maquina.darBanho();
                case 6 -> maquina.limparMaquina();
                case 7 -> maquina.verificarStatus();
                case 0 -> System.out.println("Saindo do sistema do Pet Shop...");
                default -> System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}