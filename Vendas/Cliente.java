package Vendas;

public class Cliente {
    protected String cep;
    protected String endereco;
    protected int numero;
    protected int telefone;
    Usuario usuario;
    Cliente cliente;
    // protected String nome;

    public Cliente(
        Usuario usuario,
        String cep, 
        String endereco,
        int numero, 
        int telefone
    ) {
        // super(nome);
        this.usuario = usuario;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
    }

    // public Cliente(String nome) {
    //     this(nome, "", "", 0, 0);
    // }

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
    public void setUsuario(Usuario usuario) {
        usuario.setUsuario(usuario);
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    public Usuario getUsuario() {
        return this.usuario;
    }

  // ======== Impressão ========
  @Override
  public String toString() {
    String print = usuario + "\n" +
                   "Endereço: " + this.endereco + "\n" +
                   "Cep: " + this.cep + "\n" +
                   "Numero: " + this.numero + "\n"+
                   "Telefone: " + this.telefone;
    return print;
  }
}
