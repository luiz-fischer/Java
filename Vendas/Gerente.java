package Vendas;

public class Gerente extends Usuario{
    public String setor;
    public double orcamento;

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
    public Gerente(String nome, String senha) {
        this(nome, senha, "", 0);
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
        return setor;
    }
    public double getOrcamento() {
        return orcamento;
    }

  // ======== Impressão ========
  @Override
  public String toString() {
      String print = "Setor: " + getSetor() + "Orçamento: " + getOrcamento();
      return print;
  }
}
