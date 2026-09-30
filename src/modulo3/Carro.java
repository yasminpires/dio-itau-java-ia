package modulo3;

import java.util.Scanner;

public class Carro {
    private boolean ligado = false;
    private int velocidade = 0;
    private int marcha = 0; // 0 = ponto morto, 1 a 6 = marchas

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado com sucesso!");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
            return;
        }
        if (marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado com sucesso!");
        } else {
            System.out.println("O carro só pode ser desligado em ponto morto (marcha 0) e com velocidade a 0 km/h.");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }
        if (marcha == 0) {
            System.out.println("Não é possível acelerar em ponto morto.");
            return;
        }
        int velocidadeMaxima = getVelocidadeMaximaMarcha(marcha);
        if (velocidade < velocidadeMaxima && velocidade < 120) {
            velocidade++;
            System.out.println("Acelerou! Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Velocidade máxima para a " + marcha + "ª marcha atingida (" + velocidadeMaxima + " km/h). Troque a marcha!");
        }
    }

    public void desacelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }
        int velocidadeMinima = getVelocidadeMinimaMarcha(marcha);
        if (velocidade > velocidadeMinima && velocidade > 0) {
            velocidade--;
            System.out.println("Desacelerou! Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Velocidade mínima para a marcha atual atingida (" + velocidadeMinima + " km/h).");
        }
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }
        if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Não é permitido pular marchas!");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida!");
            return;
        }
        marcha = novaMarcha;
        System.out.println("Marcha alterada para: " + (marcha == 0 ? "Ponto Morto" : marcha + "ª marcha"));
    }

    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }
        if (velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para a " + direcao + " com sucesso!");
        } else {
            System.out.println("Para virar, a velocidade deve estar entre 1 km/h e 40 km/h. Velocidade atual: " + velocidade + " km/h");
        }
    }

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h | Marcha: " + marcha + " | Status: " + (ligado ? "Ligado" : "Desligado"));
    }

    private int getVelocidadeMinimaMarcha(int m) {
        return switch (m) {
            case 1 -> 0;
            case 2 -> 21;
            case 3 -> 41;
            case 4 -> 61;
            case 5 -> 81;
            case 6 -> 101;
            default -> 0;
        };
    }

    private int getVelocidadeMaximaMarcha(int m) {
        return switch (m) {
            case 1 -> 20;
            case 2 -> 40;
            case 3 -> 60;
            case 4 -> 80;
            case 5 -> 100;
            case 6 -> 120;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU CONTROLE DO CARRO ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Trocar marcha");
            System.out.println("6 - Virar (Esquerda/Direita)");
            System.out.println("7 - Verificar velocidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> carro.ligar();
                case 2 -> carro.desligar();
                case 3 -> carro.acelerar();
                case 4 -> carro.desacelerar();
                case 5 -> {
                    System.out.print("Informe a nova marcha (0 a 6): ");
                    carro.trocarMarcha(scanner.nextInt());
                }
                case 6 -> {
                    System.out.print("Informe a direção (esquerda/direita): ");
                    carro.virar(scanner.next());
                }
                case 7 -> carro.verificarVelocidade();
                case 0 -> System.out.println("Saindo do simulador de carro...");
                default -> System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}