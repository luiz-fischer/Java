package Vendas;

public class Usuario {
    protected  String nome;
    protected  String senha;
    
    public Usuario(
        String nome, 
        String senha
    ) { 
        
        this.nome = nome;
        this.senha = senha;
    } 

   

	// ======= SETS =======
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    // public void setUsuario(Usuario usuario) {
    //     this.usuario = usuario;
    // }

    // ======= GETS =======
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }

  // ======== Impressão ========
  @Override
  public String toString() {
        String print = "Nome: " + getNome() + "\n" +
                       "Senha: " + getSenha()+ "\n";
        return print;
      
  }
}
