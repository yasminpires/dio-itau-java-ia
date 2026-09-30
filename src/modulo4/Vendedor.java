package modulo4;

public class Vendedor extends Usuario {
    private int quantidadeVendas = 0;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false); // Administrador é sempre false
    }

    public void realizarVenda() {
        quantidadeVendas++;
        System.out.println("Venda realizada! Total de vendas: " + quantidadeVendas);
    }

    public void consultarVendas() {
        System.out.println("Vendas realizadas por " + getNome() + ": " + quantidadeVendas);
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }
}