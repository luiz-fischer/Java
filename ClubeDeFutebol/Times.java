package ClubeDeFutebol;

public class Times {
    private int id;
    private String nome;
    private String sigla;
    private String descricaoEscudo;
    private int anoDeFundacao;
    private double rendaMedia;
	public Object equals;

    public Times() {

    }

    public Times(int id, String nome, String sigla, String descricaoEscudo, int anoDeFundacao, double rendaMedia) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.anoDeFundacao = anoDeFundacao;
        this.descricaoEscudo = descricaoEscudo;
        this.rendaMedia = rendaMedia;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id    ) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricaoEscudo() {
        return this.descricaoEscudo;
    }
    
    public void setDescricaoEscudo(String descricaoEscudo) {
        this.descricaoEscudo = descricaoEscudo;
    }

    public int getAnoDeFundacao() {
        return this.anoDeFundacao;
    }
    
    public void setAnoDeFundacao(int anoDeFundacao) {
        this.anoDeFundacao = anoDeFundacao;
    }

    public double getRendaMedia() {
        return this.rendaMedia;
    }
    
    public void setRendaMedia(double rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    @Override
	public String toString() {
        return "\n++++++ Clube: " + this.nome + " ++++++\n" +
               "\n Sigla: " + this.sigla + 
               "\n Brasão: " + this.descricaoEscudo + 
               "\n Fundado em: " + this.anoDeFundacao + 
               "\n Renda Média: " + this.rendaMedia + "\n";
	}

    @Override
    public boolean equals(Object object) {
        if (object == this)
        return true;
        if (!(object instanceof Times)) {
        return false;
        }
    Times times = (Times) object;
    return hashCode() == times.hashCode();
    }

}