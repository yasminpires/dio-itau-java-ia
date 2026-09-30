package modulo4;

public class Gerente extends Usuario {

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true); // Administrador é sempre true
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Gerando relatório financeiro...");
    }

    public void consultarVendas() {
        System.out.println("Consultando vendas do sistema...");
    }
}