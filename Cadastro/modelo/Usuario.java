package Cadastro.modelo;

public class Usuario {
    static Long id;
    static String nome;
    static String cpf;
    static String email;
    static String telefone;

    // ========= SETS =========
    public void setId(Long id) {
        Usuario.id = id;
    }

    public void setTelefone(String telefone) {
        Usuario.telefone = telefone;
    }

    public void setCpf(String cpf) {
        Usuario.cpf = cpf;
    }

    public void setEmail(String email) {
        Usuario.email = email;
    }

    public void setNome(String nome) {
        Usuario.nome = nome;
    }

    // ========= GETS =========
    public Long getId() {
        return id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getCpf() {
        return cpf;
    }

    public static String getEmail() {
        return email;
    }

    public static String getTelefone() {
        return telefone;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        return getId() + getNome();
    }

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Usuario))
            return false;

        Usuario usuario = (Usuario) object;

        return this.getId() == usuario.getId();
    }

}
