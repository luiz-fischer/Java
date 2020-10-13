package CadastroUsuario;


// CLASSE QUE GUARDA AS VARIAVEIS DOS OBJETOS...
public class Usuario {
    
    private String nome;    
    private int senha;    
    private String login;    
    private String cargo;
     
    
    public Usuario(){
    
    
    }
    
    public String getNome(){
    
    return nome;
    }
    
    public void setNome(String nome){
    
    this.nome = nome;
    }
    
    public String getLogin(){
    
    return login;
    }
    
    public void setLogin(String log ){
    
    this.login = log;
    }
    
    public String getCargo(){
    
    return cargo;
    }
    
    public void setCargo(String cargo){
    
    this.cargo = cargo;
    }

    public int getSenha(){
    
    return senha;
    }
        
    public void setSenha(int senha){
        
    this.senha = senha;
    }
}