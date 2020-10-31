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
    public String getSetor() {
        return this.setor;
    }
    public double getOrcamento() {
        return this.orcamento;
    }

  // ======== Impressão ========
  @Override
  public String toString() {
      super.toString();
    String print = "========== GERENTE ==========" + "\n" +
                   "Usuario: " + getNome() + "\n" +
                   "Setor: " + getSetor() +  "\n" +
                   "Salário R$:  " + getOrcamento() + "\n" ;
    return print;
  }
}
