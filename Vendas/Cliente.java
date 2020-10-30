package Vendas;


public class Cliente extends Usuario {
    private String cep;
    private String endereco;
    private int numero;
    private int telefone;

    public Cliente(
        String nome,
        String senha,
        String cep,
        String endereco,
        int numero,
        int telefone
    ) {
        super(nome, senha);
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;

    }
   
    // ======= SETS =======
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

   // ======= GETS =======
    public String getCep() {
        return cep;
    }
    public String getEndereco() {
        return endereco;
    }
    public int getNumero() {
        return numero;
    }
    public int getTelefone() {
        return telefone;
    }

  // ======== Impressão ========
  @Override
  public String toString() {
      super.toString();
    String print = "========== CLIENTE ==========" + "\n" +
                   "Usuario: " + super.nome + "\n" +
                   "Endereço: " + this.endereco + "\n" +
                   "Cep: " + this.cep + "\n" +
                   "Numero: " + this.numero + "\n"+
                   "Telefone: " + this.telefone;
    return print;
  }
}
