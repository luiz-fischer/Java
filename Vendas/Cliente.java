package Vendas;

public class Cliente extends Usuario{
    protected String cep;
    protected String endereco;
    protected int numero;
    protected int telefone;

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

    public Cliente(String nome, String senha) {
        this(nome, senha, "", "", 0, 0);
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
      String print =  this.cep + super.nome;
      return print;
  }
}
