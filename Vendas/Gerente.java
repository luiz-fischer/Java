package Vendas;

public class Gerente extends Usuario{
    private String setor;
    private double orcamento;

    public Gerente(
        String nome,
        String senha,
        String setor, 
        double orcamento
    ) {
        super(nome, senha);
        this.setor = setor;
        this.orcamento = orcamento;

    }
   
    // ======= SETS =======
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    // ======= GETS =======
    // public String getSetor() {
    //     return setor;
    // }
    // public double getOrcamento() {
    //     return orcamento;
    // }

  // ======== Impressão ========
  @Override
  public String toString() {
      super.toString();
    String print = "========== GERENTE ==========" + "\n" +
                   "Usuario: " + super.nome + "\n" +
                   "Setor: " + this.setor + "\n" +
                   "Salário R$:  " + this.orcamento + "\n" ;
    return print;
  }
}
