package modulo4;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean eAdministrador;

    public Usuario(String nome, String email, String senha, boolean eAdministrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.eAdministrador = eAdministrador;
    }

    public void realizarLogin() {
        System.out.println(nome + " realizou login.");
    }

    public void realizarLogoff() {
        System.out.println(nome + " realizou logoff.");
    }

    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Dados alterados com sucesso!");
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso!");
    }

    public String getNome() { 
        return nome; 
    }

    public String getEmail() { 
        return email; 
    }

    public String getSenha() { 
        return senha; 
    }

    public boolean isEAdministrador() { 
        return eAdministrador; 
    }
}