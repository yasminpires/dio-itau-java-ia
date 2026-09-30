package modulo4;

public class TestaUsuarios {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Ana", "ana@empresa.com", "1234");
        Vendedor vendedor = new Vendedor("Carlos", "carlos@empresa.com", "abcd");
        Atendente atendente = new Atendente("Mariana", "mariana@empresa.com", "qwerty");

        System.out.println("=== TESTE DE USUÁRIOS ===");
        
        gerente.realizarLogin();
        gerente.gerarRelatorioFinanceiro();
        System.out.println("Gerente é admin? " + gerente.isEAdministrador());

        System.out.println("--------------------");

        vendedor.realizarLogin();
        vendedor.realizarVenda();
        vendedor.consultarVendas();
        System.out.println("Vendedor é admin? " + vendedor.isEAdministrador());

        System.out.println("--------------------");

        atendente.realizarLogin();
        atendente.receberPagamentos(150.0);
        atendente.fecharCaixa();
        System.out.println("Atendente é admin? " + atendente.isEAdministrador());
    }
}