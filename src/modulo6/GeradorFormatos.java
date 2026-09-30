package modulo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Campo {
    String nome;
    String valor;
    String tipo;

    public Campo(String nome, String valor, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }
}

public class GeradorFormatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Campo> campos = new ArrayList<>();

        System.out.println("=== GERADOR DE JSON, XML E YAML ===");
        System.out.println("Digite os dados no padrão: NOME_CAMPO;VALOR;TIPO");
        System.out.println("Exemplo: nome;Lucas;texto");
        System.out.println("Digite 'sair' para encerrar a leitura das entradas.\n");

        while (true) {
            System.out.print("Entrada: ");
            String linha = scanner.nextLine();

            if (linha.equalsIgnoreCase("sair")) {
                break;
            }

            String[] partes = linha.split(";");
            if (partes.length == 3) {
                campos.add(new Campo(partes[0].trim(), partes[1].trim(), partes[2].trim().toLowerCase()));
            } else {
                System.out.println("Formato inválido! Use: NOME_CAMPO;VALOR;TIPO");
            }
        }

        if (campos.isEmpty()) {
            System.out.println("Nenhum dado informado.");
            scanner.close();
            return;
        }

        System.out.println("\n--- SAÍDA JSON ---");
        System.out.println(gerarJson(campos));

        System.out.println("\n--- SAÍDA XML ---");
        System.out.println(gerarXml(campos));

        System.out.println("\n--- SAÍDA YAML ---");
        System.out.println(gerarYaml(campos));

        scanner.close();
    }

    private static String gerarJson(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < campos.size(); i++) {
            Campo c = campos.get(i);
            sb.append("  \"").append(c.nome).append("\": ");
            
            if (c.tipo.contains("texto")) {
                sb.append("\"").append(c.valor).append("\"");
            } else {
                sb.append(c.valor);
            }

            if (i < campos.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String gerarXml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("<dados>\n");
        for (Campo c : campos) {
            sb.append("  <").append(c.nome).append(">")
              .append(c.valor)
              .append("</").append(c.nome).append(">\n");
        }
        sb.append("</dados>");
        return sb.toString();
    }

    private static String gerarYaml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder();
        for (Campo c : campos) {
            sb.append(c.nome).append(": ");
            if (c.tipo.contains("texto")) {
                sb.append("\"").append(c.valor).append("\"\n");
            } else {
                sb.append(c.valor).append("\n");
            }
        }
        return sb.toString();
    }
}