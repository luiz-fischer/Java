package Cadastro.modelo;

public class Usuario {
    private static String id;
    private static String nome;
    private static String cpf;
    private static String email;
    private static String telefone;
    // Usuario usuario;

    // ========= SETS =========
    public void setId(String id) {
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
    public static String getId() {
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
        String print = "Id: " + getId() + "\n" + 
                       "Nome: " + getNome() + "\n" +
                       "CPF: " + getCpf() + "\n" + 
                       "E-mail: " + getEmail() + "\n" + 
                       "Telefone: " + getTelefone() + "\n"; 
        return print;
    }

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Usuario))
            return false;

        Usuario usuario = (Usuario) object;

        return getId() == getId();
    }

}
