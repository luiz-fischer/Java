package frame;

public class RegistroPessoa {

	protected String nome;
	protected String endereco;
	protected String fone;

	public RegistroPessoa() {
		nome = "";
		endereco = "";
		fone = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
}