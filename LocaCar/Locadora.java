package Cadastro;

import javax.swing.JOptionPane;
import java.sql.*;

/*Organiza��o do Banco de Dados MySQL:
   
CREATE TABLE filial (
   codigo INT(5) NOT NULL auto_increment,
   cidade VARCHAR(80),
   endereco VARCHAR(120),
   telefone VARCHAR(14),
   PRIMARY KEY (codigo)
) TYPE=InnoDB ROW_FORMAT=DYNAMIC; -- PRONTO, tudo checkado
CREATE TABLE tipo_carro (
   tipo INT(2) NOT NULL auto_increment,
   descricao VARCHAR(20),
   PRIMARY KEY (tipo)
) TYPE=InnoDB ROW_FORMAT=DYNAMIC; -- PRONTO, tudo checkado
CREATE TABLE carro (
   chapa VARCHAR(20) NOT NULL,
   chassis VARCHAR(80) NOT NULL,
   modelo VARCHAR(30) NOT NULL,
   cor VARCHAR(20) NOT NULL,
   tipo_carro INT(1) default '1',
   ano INT(4) NOT NULL,
   km INT(6) NOT NULL,
   aluguel_diaria FLOAT(7) NOT NULL,
   PRIMARY KEY (chapa),
   INDEX (tipo_carro),
   CONSTRAINT FOREIGN KEY (tipo_carro) REFERENCES tipo_carro(tipo) ON UPDATE CASCADE ON DELETE RESTRICT,
   UNIQUE (chassis)
) TYPE=InnoDB ROW_FORMAT=DYNAMIC; -- PRONTO, tudo checkado
CREATE TABLE cliente (
   cpf INT(11) NOT NULL,
   tipo INT(2) default '0',
   nome VARCHAR(80),
   endereco VARCHAR(120),
   telefone VARCHAR(14),
   cidade VARCHAR(120),
   PRIMARY KEY (cpf)
) TYPE=InnoDB ROW_FORMAT=DYNAMIC; -- PRONTO, tudo checkado
CREATE TABLE tipo_aluguel (
   tipo INT(2) NOT NULL auto_increment,
   desconto FLOAT(3) default '0.0',
   valor_km FLOAT(7) NOT NULL,
   PRIMARY KEY (tipo)
) TYPE=InnoDB ROW_FORMAT=DYNAMIC;
CREATE TABLE aluguel (
   identificador INT(11) NOT NULL auto_increment,
   data date() NOT NULL default '0000-00-00',
   carro_chapa VARCHAR(20) NOT NULL,
   filial_codigo INT(5) NOT NULL,
   aluguel_tipo INT(2) NOT NULL,
   cliente_cpf INT(11) NOT NULL,
   km_percorrido INT(6) NOT NULL,
   PRIMARY KEY (identificador),
   INDEX (carro_chapa),
   CONSTRAINT FOREIGN KEY (carro_chapa) REFERENCES carro(chapa) ON UPDATE CASCADE ON DELETE RESTRICT,
   INDEX (aluguel_tipo),
   CONSTRAINT FOREIGN KEY (aluguel_tipo) REFERENCES tipo_aluguel(tipo) ON UPDATE CASCADE ON DELETE RESTRICT,
   INDEX (filial_codigo),
   CONSTRAINT FOREIGN KEY (filial_codigo) REFERENCES filial(codigo) ON UPDATE CASCADE ON DELETE RESTRICT,
   INDEX (cliente_cpf),
   CONSTRAINT FOREIGN KEY (cliente_cpf) REFERENCES cliente(cpf) ON UPDATE CASCADE ON DELETE RESTRICT
) TYPE=InnoDB ROW_FORMAT=DYNAMIC;
*/

// Criando uma locadora de veiculos
public class Locadora {
   

   /********************************************************

   fun�ao que conecta ao mysql e retorna o identificador da conex�o ;P
   
   N�o precisa receber argumento nenhum.
   
   Lembre-se de verificar {BANCO_DE_DADOS} {USUARIO} {SENHA}
   
   ********************************************************/

   protected Connection abre_mysql () throws Exception {      
     try {
       // verifica e cria o link com o driver JDBC do mysql
       Class.forName ("org.gjt.mm.mysql.Driver");
       // manda esse tro�o conectar
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost/{BANCO_DE_DADOS}", "{USUARIO}", "{SENHA}");
       return con;
     } catch ( java.sql.SQLException e ) {
       System.out.println("A conexao foi recusada.");
       throw ( e );
     }
   }

   public static void main(String args[]) throws Exception {
      String menu;
      int valor;
      do {
         menu = JOptionPane.showInputDialog("Digite o numero de acordo com o menu abaixo:\n1 filiais\n2 carros\n3 clientes\n4 alugueis\n0 fechar");
         // verifica se foi retornado um numero
         if (menu != null && menu.matches("[0-9]"))
	        valor = Integer.parseInt(menu);
 	      else
	        valor = 5;
         switch(valor) {
          case 0:
          // sair
          System.exit(0);          
          case 1:
          // Aqui as filiais, vai ter que ter outro menu
          new filiais().menu();
          break;
          case 2:
          new carros().menu();
          break;
          case 3:
          new clientes().menu();
          break;
          case 4:
          new alugueis().menu();
          break;
         }
      } while (valor != 0);
   }
}


   /********************************************************
   fun��es para as filiais
   
   N�o precisa receber nada.
   Aqui lhe � apresentado um menu para voc� escolher o que
   quer fazer, e dependendo da escolha ele lhe apresenta
   passo a passo o que � preciso.
   
   ********************************************************/
class filiais extends Locadora {
    void menu() throws Exception {
      String menu;
      int valor;
      do {
         menu = JOptionPane.showInputDialog("FILIAIS\n\nDigite o numero de acordo com o menu abaixo:\n1 listagem\n2 remover\n3 cadastro\n0 voltar ao menu principal");
         // Se a pessoa escreveu um numero
	 		if (menu != null && menu.matches("[0-9]"))
           valor = Integer.parseInt(menu);
	 		else
	   	  valor = 4;
         switch(valor) {           
	  		  case 1:
	  		  // Listando as filiais	        
           try {
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs = s.executeQuery("select codigo, cidade, endereco from filial order by cidade, endereco");
             System.out.println("CODIGO\t| Cidade\t\t| Endereco");
             while ( rs.next() ) {
               String codigo = ( rs.getObject ("codigo").toString() );
               String cidade = ( rs.getObject ("cidade").toString() );
               String endereco = ( rs.getObject ("endereco").toString() );
               System.out.println ( codigo + "\t| " + cidade + "\t| " + endereco );
             }
             rs.close();
             con.close();
           } catch ( SQLException e ) {
             System.out.println ("Erro listando filiais");
             throw (e);
           }
           break;
	  		  case 2:
	  		  // Remover filiais pelo codigo
	  		  String ler;
	  		  // Padr�o 0 pra se a pessoa n�o escolher nenhum ele nem verificar no banco de dados (vamos usar poucos recursos)
	  		  int qual = 0;
	  		  System.out.println("Removendo uma filial");
           ler = JOptionPane.showInputDialog("FILIAIS\n\nDigite o Codigo da filial a remover");
           if (ler != null && ler.matches("[0-9]+"))
             qual = Integer.parseInt(ler);
           if (qual == 0)
             System.out.println("Voc� precisa digitar o codigo da filial a ser removida\nDICA: Liste e selecione o codigo desejado");
           else {
             try {
	   	      Connection con = abre_mysql();
               Statement s = con.createStatement ();
               ResultSet rs = s.executeQuery("select codigo, cidade from filial where codigo='" + qual + "'");
               if ( rs.next() ) {
                 String cidade = ( rs.getObject ("cidade").toString() );
                 System.out.println ("Removendo a filial " + qual + " da cidade " + cidade);
                 rs.close();
                 s.execute("delete from filial where codigo='" + qual + "'");
                 s.close();
               } else
                 System.out.println("Nao existe a filial de codigo " + qual);
               con.close();
             } catch ( SQLException e ) {
               System.out.println ("Erro removendo filial");
               throw (e);
             }
           }  
           break;
              case 3:
              // Vamos cadastrar filiais :)
              int criarOutro;
              do {
	  	 	    criarOutro = 0;
	  	 	    String verificar, cidade, endereco, telefone;
	  	 	    System.out.println("Adicionando uma filial");
  	 	       cidade = JOptionPane.showInputDialog("FILIAIS\n\nDigite a cidade");
  	 	       if (cidade == null || cidade.matches("[^a-zA-Z0-9 .-]+"))
  	 	         System.out.println("Voce precisa digitar uma cidade");
  	 	       else {
	  	 	     endereco = JOptionPane.showInputDialog("FILIAIS\n\nDigite o endereco");
	  	 	     if (endereco == null || endereco.matches("[^a-zA-Z0-9 .-]+"))
	  	 	       System.out.println("Voce precisa digitar um endereco");
	  	 	     else {
	  	 	       telefone = JOptionPane.showInputDialog("FILIAIS\n\nDigite o telefone");
	  	 	       if (telefone == null || telefone.matches("[^a-zA-Z0-9 .-]+"))
	  	 	         System.out.println("Voce precisa digitar o telefone");
	  	 	       else {
	  	 	         // S� chega aqui se a pessoa digitar uma cidade, um endere�o e um telefone (n�o fazemos verifica��o dos dados - ainda por implementar)
                  try {
                    Connection con = abre_mysql();
                    Statement s = con.createStatement ();
                    s.execute("insert into filial set cidade=\"" + cidade + "\", endereco=\"" + endereco + "\", telefone=\"" + telefone + "\"");
                    s.close();
                    con.close();
                    System.out.println("Adicionada filial em " + cidade);
                  } catch ( SQLException e ) {
                    System.out.println ("Erro incluindo filial");
                    throw (e);
                  }
	  	 	       }
	  	 	     }
	  	 	    }
  	 	       verificar = JOptionPane.showInputDialog("FILIAIS\n\nDeseja adicionar outra filial? [s/N]");	  	 	    
  	 	       if (verificar != null && verificar.equalsIgnoreCase("s"))
  	 	         criarOutro = 1;
	  	 	  } while (criarOutro == 1);
	  	 	  break;
	      }
      } while (valor != 0);
   }
}

   /********************************************************
   fun��es para carros
   
   N�o precisa receber nada.
   Aqui lhe � apresentado um menu para voc� escolher o que quer
   fazer, e dependendo da escolha ele lhe apresenta passo a
   passo o que � preciso.
   
   Nesta fun��o se verifica carros e tipos de carros :)
   Visto que carro depende de tipo de carro
   
   ********************************************************/      
class carros extends Locadora {
   void menu() throws Exception {
      String menu;
      int valor;
      do {
         menu = JOptionPane.showInputDialog("CARROS\n\nDigite o numero de acordo com o menu abaixo:\n1 listagem de carros\n2 remover carro\n3 cadastro de carros\n4 listar tipos\n5 remover tipos\n6 cadastrar tipos\n0 voltar ao menu principal");
         // Se a pessoa escreveu um numero
	 		if (menu != null && menu.matches("[0-9]"))
           valor = Integer.parseInt(menu);
	 		else
	   	  valor = 7;
         switch(valor) {           
	  		  case 1:
	  		  // Listando os carros cadastrados
           try {
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs = s.executeQuery("select chapa, modelo, tipo_carro.descricao as tipo, cor, ano from carro, tipo_carro where tipo_carro.tipo = carro.tipo_carro order by chapa, ano DESC");
             System.out.println("Chapa\t| Modelo\t| Cor\t| Tipo\t| Ano");
             while ( rs.next() ) {
               String chapa = ( rs.getObject ("chapa").toString() );
               String modelo = ( rs.getObject ("modelo").toString() );
               String cor = ( rs.getObject ("cor").toString() );
               String tipo = ( rs.getObject ("tipo").toString() );
               String ano = ( rs.getObject ("ano").toString() );
               System.out.println ( chapa + "\t| " + modelo + "\t| " + cor + "\t| " + tipo + "\t| " + ano );
             }
             rs.close();
             con.close();
           } catch ( SQLException e ) {
             System.out.println ("Erro listando carros");
             throw (e);
           }
           break;
	  		  case 2:
	  		  // Remover carros pela chapa
	  		  String ler;
	  		  System.out.println("Removendo um carro");
           ler = JOptionPane.showInputDialog("CARROS\n\nDigite a Chapa do carro a remover");
           if (ler == null || ler.matches("[^a-zA-Z0-9 .-]+"))
             System.out.println("Voc� precisa digitar a chapa do carro a ser removido\nDICA: Liste e selecione a chapa desejada");
           else {
             try {
	   	      Connection con = abre_mysql();
               Statement s = con.createStatement ();
               ResultSet rs = s.executeQuery("select chapa, chassis, modelo from carro where chapa=\"" + ler + "\"");
               if ( rs.next() ) {
                 String chassis = ( rs.getObject ("chassis").toString() );
                 String modelo = ( rs.getObject ("modelo").toString() );
                 System.out.println ("Removendo o carro de chapa " + ler + " e chassis " + chassis + " do modelo " + modelo);
                 rs.close();
                 s.execute("delete from carro where chapa=\"" + ler + "\"");
                 s.close();
               } else
                 System.out.println("Nao existe carro de chapa " + ler);
               con.close();
             } catch ( SQLException e ) {
               System.out.println ("Erro removendo carro");
               throw (e);
             }
           }  
           break;          
	  	 	  case 3:
	  	 	  // Vamos cadastrar carros
	  	 	  int criarOutro;
	  	 	  do {
	  	 	    criarOutro = 0;
	  	 	    String verificar, chapa, chassis, modelo, cor, Stipo_carro, Sano, Skm;
	  	 	    System.out.println("Adicionando um carro");
  	 	       chapa = JOptionPane.showInputDialog("CARROS\n\nDigite a chapa");
  	 	       if (chapa == null || chapa.matches("[^a-zA-Z0-9 .-]+"))
  	 	         System.out.println("Voce precisa digitar uma chapa");
  	 	       else {
	  	 	     chassis = JOptionPane.showInputDialog("CARROS\n\nDigite o chassi");
	  	 	     if (chassis == null || chassis.matches("[^a-zA-Z0-9 .-]+"))
	  	 	       System.out.println("Voce precisa digitar o chassi");
	  	 	     else {
	  	 	       modelo = JOptionPane.showInputDialog("CARROS\n\nDigite o modelo");
	  	 	       if (modelo == null || modelo.matches("[^a-zA-Z0-9 .-]+"))
	  	 	         System.out.println("Voce precisa digitar o modelo");
	  	 	       else {
	  	 	         cor = JOptionPane.showInputDialog("CARROS\n\nDigite a cor");
	  	 	         if (cor == null || cor.matches("[^a-zA-Z0-9 .-]+"))
	  	 	           System.out.println("Voce precisa digitar a cor");
	  	 	         else {
	  	 	           Stipo_carro = JOptionPane.showInputDialog("CARROS\n\nDigite o codigo do tipo");
	  	 	           if (Stipo_carro == null || Stipo_carro.matches("[^0-9]+"))
	  	 	             System.out.println("Voce precisa digitar o codigo do tipo");
	  	 	           else {
	  	 	             int tipo_carro = Integer.parseInt(Stipo_carro);
	  	 	             Sano = JOptionPane.showInputDialog("CARROS\n\nDigite o ano");
	  	 	             if (Sano == null || Sano.matches("[^0-9]+"))
	  	 	               System.out.println("Voce precisa digitar o ano");
	  	 	             else {
	  	 	               int ano = Integer.parseInt(Sano);
	  	 	               Skm = JOptionPane.showInputDialog("CARROS\n\nDigite a kilometragem");
	  	 	               if (Skm == null || Skm.matches("[^0-9]+"))
	  	 	                 System.out.println("Voce precisa digitar a kilometragem");
	  	 	               else {
	  	 	                 int km = Integer.parseInt(Skm);
                          try {
                            Connection con = abre_mysql();
                            Statement s = con.createStatement ();
                            ResultSet rs = s.executeQuery("select tipo from tipo_carro where tipo='" + tipo_carro + "'");
                            if ( rs.next() ) {
                              rs.close();
                              ResultSet rsc = s.executeQuery("select chapa from carro where chapa=\"" + chapa + "\"");
                              if ( rsc.next() ) {
                                System.out.println("Ja existe um carro cadastrado com essa chapa");
                              } else {                                
                                s.execute("insert into carro set chapa=\"" + chapa + "\", chassis=\"" + chassis + "\", modelo=\"" + modelo + "\", cor=\"" + cor + "\", tipo_carro='" + tipo_carro + "', ano='" + ano + "', km='" + km + "'");
                                System.out.println("Adicionado carro de chapa " + chapa + " e chassis " + chassis);                             
                              }
                              rsc.close();                               
                              s.close();
                              con.close();
                            } else
                              System.out.println("O codigo do tipo de carro informado nao existe");
                          } catch ( SQLException e ) {
                            System.out.println ("Erro incluindo carro");
                            throw (e);
                          }
                  	  	}
                  	 }
                    }
                  }
	  	 	       }
	  	 	     }
	  	 	    }
  	 	       verificar = JOptionPane.showInputDialog("CARROS\n\nDeseja adicionar outro carro? [s/N]");	  	 	    
  	 	       if (verificar != null && verificar.equalsIgnoreCase("s"))
  	 	         criarOutro = 1;
	  	 	  } while (criarOutro == 1);
	  	 	  break;
	  	 	  /********************************************************
	  	 	  
	  	 	  Tipos de carros

	  	 	  ********************************************************/
	  		  case 4:
	  		  // Listando os tipos de carros cadastrados
           try {
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs = s.executeQuery("select tipo, descricao from tipo_carro order by tipo");
             System.out.println("Tipo\t| Descricao");
             while ( rs.next() ) {
               String tipo = ( rs.getObject ("tipo").toString() );
               String descricao = ( rs.getObject ("descricao").toString() );
               System.out.println ( tipo + "\t| " + descricao);
             }
             rs.close();
             con.close();
           } catch ( SQLException e ) {
             System.out.println ("Erro listando tipos de carros");
             throw (e);
           }
           break;
	  		  case 5:
	  		  // Remover tipos de carro pelo codigo
	  		  String Tler;
	  		  System.out.println("Removendo um tipo de carro");
           Tler = JOptionPane.showInputDialog("TIPOS DE CARROS\n\nDigite o tipo de carro a remover");
           if (Tler == null || Tler.matches("[^0-9]+"))
             System.out.println("Voc� precisa digitar o tipo do carro a ser removido\nDICA: Liste e selecione o tipo desejado");
           else {
             int tipo = Integer.parseInt(Tler);
             try {
	   	      Connection con = abre_mysql();
               Statement s = con.createStatement ();
               ResultSet rs = s.executeQuery("select descricao from tipo_carro where tipo='" + tipo + "'");
               if ( rs.next() ) {
                 String descricao = ( rs.getObject ("descricao").toString() );
                 System.out.println ("Removendo o tipo " + tipo + " que e carro do tipo: " + descricao);
                 rs.close();
                 s.execute("delete from tipo_carro where tipo='" + tipo + "'");
                 s.close();
               } else
                 System.out.println("Nao existe carro de tipo " + tipo);
               con.close();
             } catch ( SQLException e ) {
               System.out.println ("Erro removendo tipo de carro");
               throw (e);
             }
           }  
           break;          
	  	 	  case 6:
	  	 	  // Vamos cadastrar tipos de carros
	  	 	  int TcriarOutro;
	  	 	  do {
	  	 	    TcriarOutro = 0;
	  	 	    String descricao,Tverificar;
	  	 	    System.out.println("Adicionando um tipo de carro");
  	 	       descricao = JOptionPane.showInputDialog("TIPOS DE CARROS\n\nDigite a descricao");
  	 	       if (descricao == null || descricao.matches("[^a-zA-Z0-9 .-]+"))
  	 	         System.out.println("Voce precisa digitar uma descricao");
  	 	       else {
               try {
                 Connection con = abre_mysql();
                 Statement s = con.createStatement ();
                 s.execute("insert into tipo_carro set descricao=\"" + descricao + "\"");
                 s.close();
                 con.close();
                 System.out.println("Adicionado tipo de carro: " + descricao);
               } catch ( SQLException e ) {
                 System.out.println ("Erro incluindo o tipo de carro");
                 throw (e);
               }
	  	 	    }
  	 	       Tverificar = JOptionPane.showInputDialog("TIPOS DE CARROS\n\nDeseja adicionar outro tipo de carro? [s/N]");	  	 	    
  	 	       if (Tverificar != null && Tverificar.equalsIgnoreCase("s"))
  	 	         TcriarOutro = 1;
	  	 	  } while (TcriarOutro == 1);
	  	 	  break;
	      }
      } while (valor != 0);
   }
}

   /********************************************************
   fun��es para clientes
   
   N�o precisa receber nada.
   Aqui lhe � apresentado um menu para voc� escolher o que
   quer fazer, e dependendo da escolha ele lhe apresenta passo
   a passo o que � preciso.
   
   ********************************************************/
class clientes extends Locadora {
   void menu() throws Exception {
      String menu;
      int valor;
      do {
         menu = JOptionPane.showInputDialog("CLIENTES\n\nDigite o numero de acordo com o menu abaixo:\n1 listagem\n2 remover\n3 cadastro\n0 voltar ao menu principal");
         // Se a pessoa escreveu um numero
	 		if (menu != null && menu.matches("[0-9]"))
           valor = Integer.parseInt(menu);
	 		else
	   	  valor = 4;
         switch(valor) {           
	  		  case 1:
	  		  // Listando os clientes	        
           try {
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs = s.executeQuery("select cpf, tipo, nome, cidade, endereco, telefone from cliente order by cidade, tipo, nome");
             System.out.println("CPF\t\t| Tipo \t| Nome\t\t| Cidade\t| Endereco\t| Telefone");
             while ( rs.next() ) {
               String cpf = ( rs.getObject ("cpf").toString() );
               String Stipo = ( rs.getObject ("tipo").toString() );
               int tipo = Integer.parseInt(Stipo);
               if (tipo == 1)
                Stipo = "Normal";
               else
                Stipo = "VIP";
               String nome = ( rs.getObject ("nome").toString() );
               String cidade = ( rs.getObject ("cidade").toString() );
               String endereco = ( rs.getObject ("endereco").toString() );
               String telefone = ( rs.getObject ("telefone").toString() );
               System.out.println ( cpf + "\t| " + Stipo + "\t| " + nome + "\t|" + cidade + "\t|" + endereco + "\t|" + telefone);
             }
             rs.close();
             con.close();
           } catch ( SQLException e ) {
             System.out.println ("Erro listando clientes");
             throw (e);
           }
           break;
	  		  case 2:
	  		  // Remover clientes pelo cpf
	  		  String ler;
	  		  // Padr�o 0 pra se a pessoa n�o escolher nenhum ele nem verificar no banco de dados (vamos usar poucos recursos)
	  		  int qual = 0;
	  		  System.out.println("Removendo um cliente");
           ler = JOptionPane.showInputDialog("CLIENTES\n\nDigite o CPF do cliente a remover");
           if (ler != null && ler.matches("[0-9]+"))
             qual = Integer.parseInt(ler);
           if (qual == 0)
             System.out.println("Voc� precisa digitar o CPF do cliente a ser removido\nDICA: Liste e selecione o CPF desejado");
           else {
             try {
	   	      Connection con = abre_mysql();
               Statement s = con.createStatement ();
               ResultSet rs = s.executeQuery("select tipo, nome, cidade from cliente where cpf='" + qual + "'");
               if ( rs.next() ) {
                 String Stipo = ( rs.getObject ("tipo").toString() );
                 int tipo = Integer.parseInt(Stipo);
                 if (tipo == 1)
                  Stipo = "Normal";
                 else
                  Stipo = "VIP";
                 String nome = ( rs.getObject ("nome").toString() );
                 String cidade = ( rs.getObject ("cidade").toString() );
                 System.out.println ("Removendo o cliente " + Stipo + ", " + nome + " da cidade " + cidade);
                 rs.close();
                 s.execute("delete from cliente where cpf='" + qual + "'");
                 s.close();
               } else
                 System.out.println("Nao existe o cliente com cpf " + qual);
               con.close();
             } catch ( SQLException e ) {
               System.out.println ("Erro removendo cliente");
               throw (e);
             }
           }  
           break;          
	  	 	  case 3:
	  	 	  // Vamos cadastrar clientes
	  	 	  int criarOutro;
	  	 	  do {
	  	 	    criarOutro = 0;
	  	 	    String verificar, Scpf, Stipo, nome, endereco, telefone, cidade;
	  	 	    System.out.println("Adicionando um cliente");
  	 	       Scpf = JOptionPane.showInputDialog("CLIENTES\n\nDigite o cpf (apenas numeros)");
  	 	       if (Scpf == null || Scpf.matches("[^0-9]+"))
  	 	         System.out.println("Voce precisa digitar um cpf");
  	 	       else {
  	 	         int cpf = Integer.parseInt(Scpf);
	  	 	      Stipo = JOptionPane.showInputDialog("CLIENTES\n\nDigite o tipo do cliente\n\n1 = normal\n2 = VIP");
	  	 	      if (Stipo == null || Stipo.matches("[^12]"))
	  	 	        System.out.println("Voce precisa digitar um tipo (1 = normal ou 2 = VIP)");
	  	 	      else {
	  	 	        int tipo = Integer.parseInt(Stipo);
	  	 	        nome = JOptionPane.showInputDialog("CLIENTES\n\nDigite o nome do cliente");
	  	 	        if (nome == null || nome.matches("[^a-zA-Z0-9 .-]+"))
	  	 	          System.out.println("Voce precisa digitar o nome do cara");
	  	 	        else {
  	  	 	          endereco = JOptionPane.showInputDialog("CLIENTES\n\nDigite o endereco do cliente");
	  	 	          if (endereco == null || endereco.matches("[^a-zA-Z0-9 .-]+"))
	  	 	           System.out.println("Voce precisa digitar o endereco do cara");
	  	 	          else {
    	  	 	         telefone = JOptionPane.showInputDialog("CLIENTES\n\nDigite o telefone do cliente");
	  	 	            if (telefone == null || telefone.matches("[^a-zA-Z0-9 .-]+"))
	  	 	              System.out.println("Voce precisa digitar o telefone do cara");
	  	 	            else {
    	  	 	           cidade = JOptionPane.showInputDialog("CLIENTES\n\nDigite a cidade do cliente");
	  	 	              if (cidade == null || cidade.matches("[^a-zA-Z0-9 .-]+"))
	  	 	                System.out.println("Voce precisa digitar a cidade do cara");
	  	 	              else {
                         try {
                           Connection con = abre_mysql();
                           Statement s = con.createStatement ();
                           ResultSet rs = s.executeQuery("select nome from cliente where cpf='" + cpf + "'");
                           if ( rs.next() )
                             System.out.println("J� existe um cliente com este CPF");
                           else {                           
                             s.execute("insert into cliente set cpf='" + cpf + "', tipo='" + tipo + "', nome=\"" + nome + "\", cidade=\"" + cidade + "\", endereco=\"" + endereco + "\", telefone=\"" + telefone + "\"");
                             s.close();
                             System.out.println("Adicionado cliente " + nome);
                           }               
                           rs.close();            
                           con.close();
                         } catch ( SQLException e ) {
                           System.out.println ("Erro incluindo cliente");
                           throw (e);
                         }	  	 	         
                       }
                     }
                   }
	  	 	        }
	  	 	      }
	  	 	    }
  	 	       verificar = JOptionPane.showInputDialog("CLIENTES\n\nDeseja adicionar outro cliente? [s/N]");	  	 	    
  	 	       if (verificar != null && verificar.equalsIgnoreCase("s"))
  	 	         criarOutro = 1;
	  	 	  } while (criarOutro == 1);
	  	 	  break;
	      }
      } while (valor != 0);
   }
}

   /********************************************************
   fun��es para alugueis
   
   N�o precisa receber nada.
   Aqui lhe � apresentado um menu para voc� escolher o que quer
   fazer, e dependendo da escolha ele lhe apresenta passo a
   passo o que � preciso.
   
   Nesta fun��o se verifica alugueis e tipos de alugueis :)
   Visto que aluguel depende de tipo de aluguel
   
   ********************************************************/      
class alugueis extends Locadora {
   void menu() throws Exception {
      String menu;
      int valor;
      do {
         menu = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite o numero de acordo com o menu abaixo:\n1 listagem de alugueis\n2 remover aluguel\n3 cadastro de aluguel\n4 listar tipos\n5 remover tipos\n6 cadastrar tipos\n0 voltar ao menu principal");
         // Se a pessoa escreveu um numero
	 		if (menu != null && menu.matches("[0-9]"))
           valor = Integer.parseInt(menu);
	 		else
	   	  valor = 7;
         switch(valor) {           
	  		  case 1:
	  		  // Listando os alugueis realizados :)
           try {
             int modoLista = 0;
  	 	       String modo = JOptionPane.showInputDialog("LISTAR ALUGUEIS\n\nListar em modo de recibo ou normal? [r/N]");	  	 	    
  	 	       if (modo != null && modo.equalsIgnoreCase("r"))
  	 	         modoLista = 1;
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs = s.executeQuery("select identificador, data, carro_chapa, ((km_percorrido * tipo_aluguel.valor_km) - (km_percorrido * tipo_aluguel.valor_km * (tipo_aluguel.desconto/100))) as valor, cliente_cpf, cliente.nome from aluguel, tipo_aluguel, filial, cliente where tipo_aluguel.tipo=aluguel_tipo order by data, cliente.nome");
             if (modoLista == 0)
               System.out.println ("Ident \t| Data \t| Valor \t| CPF \t| chapa do carro");
             while ( rs.next() ) {
               String id = ( rs.getObject ("identificador").toString() );
               String Rvalor = ( rs.getObject ("valor").toString() );
               String nome = ( rs.getObject ("nome").toString() );
               String cpf = ( rs.getObject ("cliente_cpf").toString() );
               String chapa = ( rs.getObject ("carro_chapa").toString() );
               String data = ( rs.getObject ("data").toString() );
               if (modoLista == 1)
                 System.out.println ("Recibo de aluguel de carro\n--------------------\nRecebi R$ " + Rvalor + " de " + nome + " (CPF: " + cpf + ") referente a aluguel do carro de chapa " + chapa + " em " + data + "\n\n    -----------------\n    Personal Aluguator");
               else
                 System.out.println (id + "\t| " + data + "\t| R$ " + valor + "\t| " + cpf + "\t| " + chapa);
             }
             rs.close();
             con.close();
           } catch ( SQLException e ) {
             System.out.println ("Erro listando alugueis");
             throw (e);
           }
           break;
   	  	  case 2:
	  		  // Remover alugueis
	  		  String ler;
	  		  System.out.println("Removendo um aluguel");
           ler = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite o identificador do aluguel a remover");
           if (ler == null || ler.matches("[^0-9]+"))
             System.out.println("Voc� precisa digitar o identificador do aluguel a ser removido\nDICA: Liste e selecione o identificador desejado");
           else {
             try {
	   	      Connection con = abre_mysql();
               Statement s = con.createStatement ();
               ResultSet rs = s.executeQuery("select identificador, data from aluguel where identificador='" + ler + "'");
               if ( rs.next() ) {
                 String data = ( rs.getObject ("data").toString() );
                 System.out.println ("Removendo o aluguel de identificador " + ler + " da data " + data);
                 rs.close();
                 s.execute("delete from aluguel where identificador=\"" + ler + "\"");
                 s.close();
               } else
                 System.out.println("Nao existe aluguel de identificador " + ler);
               con.close();
             } catch ( SQLException e ) {
               System.out.println ("Erro removendo aluguel");
               throw (e);
             }
           }  
           break;          
	  	 	  case 3:
	  	 	  // Vamos cadastrar os alugueis
	  	 	  int criarOutro;
	  	 	  do {
   	  	 	 criarOutro = 0;
	  	 	    String verificar, carro_chapa, Sfilial_codigo, Saluguel_tipo, Scliente_cpf, Skm_percorrido;
	  	 	    int Vchapa = 0, Vfilial = 0, Valuguel = 0, Vcliente = 0, Vkm = 0;
             // Pra fazer as verificacoes por ae
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs;
	  	 	    System.out.println("Adicionando um aluguel");
  	 	       carro_chapa = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite a chapa do carro");
             rs = s.executeQuery("select chapa from carro where chapa=\"" + carro_chapa + "\"");
             if ( rs.next() ) {
                 rs.close();
                 Vchapa = 1;
  	 	       }  	 	       
  	 	       if (carro_chapa == null || Vchapa != 1)
  	 	         System.out.println("Voce precisa digitar uma chapa válida");
  	 	       else {
	  	 	     Sfilial_codigo = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite o codigo da filial");
              rs = s.executeQuery("select codigo from filial where codigo='" + Sfilial_codigo + "'");
              if ( rs.next() ) {
                rs.close();
                Vfilial = 1;
              }
	  	 	     if (Sfilial_codigo == null || Vfilial != 1)
	  	 	       System.out.println("Voce precisa digitar um codigo de filial valido");
	  	 	     else {
	  	 	       Saluguel_tipo = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite o tipo de aluguel");
                rs = s.executeQuery("select tipo from tipo_aluguel where tipo='" + Saluguel_tipo + "'");
                if ( rs.next() ) {
                  rs.close();
                  Valuguel = 1;
                }
	  	 	       if (Saluguel_tipo == null || Valuguel != 1)
	  	 	         System.out.println("Voce precisa digitar um tipo de aluguel valido");
	  	 	       else {
	  	 	         Scliente_cpf = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite o cpf do cliente");
                  rs = s.executeQuery("select cpf from cliente where cpf='" + Scliente_cpf + "'");
                  if ( rs.next() ) {
                    rs.close();
                    Vcliente = 1;
                  }
                  if (Scliente_cpf == null || Vcliente != 1)
	  	 	           System.out.println("Voce precisa digitar um cpf de um cliente cadastrado");
	  	 	         else {
	  	 	           Skm_percorrido = JOptionPane.showInputDialog("ALUGUEIS\n\nDigite a quantidade de km percorridos");
	  	 	           if (Skm_percorrido == null || Skm_percorrido.matches("[^0-9]+"))
	  	 	             System.out.println("Voce precisa os km percorridos pelo cliente");
	  	 	           else {
	  	 	             int km_percorrido = Integer.parseInt(Skm_percorrido);
                        try {
                         s.execute("insert into aluguel set data= NOW(), carro_chapa=\"" + carro_chapa + "\", filial_codigo=\'" + Sfilial_codigo + "\', aluguel_tipo=\'" + Saluguel_tipo + "\', cliente_cpf=\'" + Scliente_cpf + "\', km_percorrido=\'" + km_percorrido + "\'");
                         rs = s.executeQuery("select identificador, data, carro_chapa, ((km_percorrido * tipo_aluguel.valor_km) - (km_percorrido * tipo_aluguel.valor_km * (tipo_aluguel.desconto/100))) as valor, cliente_cpf, cliente.nome from aluguel, tipo_aluguel, filial, cliente where tipo_aluguel.tipo=aluguel_tipo and identificador=LAST_INSERT_ID() order by data, cliente.nome");
                         while ( rs.next() ) {
                           String id = ( rs.getObject ("identificador").toString() );
                           String Rvalor = ( rs.getObject ("valor").toString() );
                           String nome = ( rs.getObject ("nome").toString() );
                           String cpf = ( rs.getObject ("cliente_cpf").toString() );
                           String chapa = ( rs.getObject ("carro_chapa").toString() );
                           String data = ( rs.getObject ("data").toString() );
                           System.out.println ("\n\n\n\n\nRecibo de aluguel de carro\n--------------------\nRecebi R$ " + Rvalor + " de " + nome + " (CPF: " + cpf + ") referente a aluguel do carro de chapa " + chapa + " em " + data + "\n\n    -----------------\n    Personal Aluguator\n\n\n\n\n");
                         }
                         rs.close();
                         s.close();
                        } catch ( SQLException e ) {
                          System.out.println ("Erro incluindo aluguel");
                          throw (e);
                        }                  	 
                    }
                  }
	  	 	       }
	  	 	     }
	  	 	    }
	  	 	    con.close();
  	 	       verificar = JOptionPane.showInputDialog("ALUGUEIS\n\nDeseja adicionar outro aluguel? [s/N]");	  	 	    
  	 	       if (verificar != null && verificar.equalsIgnoreCase("s"))
  	 	         criarOutro = 1;
	  	 	  } while (criarOutro == 1);
	  	 	  break;
	  	 	  /********************************************************
	  	 	  
	  	 	  Tipos de alugueis

	  	 	  ********************************************************/
	  		  case 4:
	  		  // Listando os tipos de alugueis cadastrados
           try {
	   	    Connection con = abre_mysql();
             Statement s = con.createStatement ();
             ResultSet rs = s.executeQuery("select tipo, desconto, valor_km from tipo_aluguel order by tipo");
             System.out.println("Tipo\t| Desconto %\t| Valor/km");
             while ( rs.next() ) {
               String tipo = ( rs.getObject ("tipo").toString() );
               String desconto = ( rs.getObject ("desconto").toString() );
               String valorKm = ( rs.getObject ("valor_km").toString() );
               System.out.println ( tipo + "\t| " + desconto + "%  \t| " + valorKm);
             }
             rs.close();
             con.close();
           } catch ( SQLException e ) {
             System.out.println ("Erro listando tipos de alugueis");
             throw (e);
           }
           break;
	  		  case 5:
	  		  // Remover tipos de carro pelo codigo
	  		  String Tler;
	  		  System.out.println("Removendo um tipo de aluguel");
           Tler = JOptionPane.showInputDialog("TIPOS DE ALUGUEL\n\nDigite o tipo de aluguel a remover");
           if (Tler == null || Tler.matches("[^0-9]+"))
             System.out.println("Voc� precisa digitar o tipo do aluguel a ser removido\nDICA: Liste e selecione o tipo desejado");
           else {
             int tipo = Integer.parseInt(Tler);
             try {
	   	      Connection con = abre_mysql();
               Statement s = con.createStatement ();
               ResultSet rs = s.executeQuery("select desconto from tipo_aluguel where tipo='" + tipo + "'");
               if ( rs.next() ) {
                 String desconto = ( rs.getObject ("desconto").toString() );
                 System.out.println ("Removendo o tipo " + tipo + " que e aluguel com desconto de " + desconto + "%");
                 rs.close();
                 s.execute("delete from tipo_aluguel where tipo='" + tipo + "'");
                 s.close();
               } else
                 System.out.println("Nao existe aluguel de tipo " + tipo);
               con.close();
             } catch ( SQLException e ) {
               System.out.println ("Erro removendo tipo de aluguel");
               throw (e);
             }
           }  
           break;          
	  	 	  case 6:
	  	 	  // Vamos cadastrar tipos de carros
	  	 	  int TcriarOutro;
	  	 	  do {
	  	 	    TcriarOutro = 0;
	  	 	    String desconto,valor_km,Tverificar;
	  	 	    System.out.println("Adicionando um tipo de aluguel");
  	 	       desconto = JOptionPane.showInputDialog("TIPOS DE ALUGUEIS\n\nDigite o desconto (em %)");
  	 	       if (desconto == null || desconto.matches("[^0-9]+"))
  	 	         System.out.println("Voce precisa digitar um desconto");
  	 	       else {
  	 	        valor_km = JOptionPane.showInputDialog("TIPOS DE ALUGUEIS\n\nDigite o valor do aluguel por km rodado");
  	 	        if (valor_km == null || valor_km.matches("[^0-9]+"))
  	 	         System.out.println("Voce precisa digitar um valor");
  	 	        else {
  	 	         try {
                 Connection con = abre_mysql();
                 Statement s = con.createStatement ();
                 s.execute("insert into tipo_aluguel set desconto=\"" + desconto + "\", valor_km=\"" + valor_km + "\"");
                 s.close();
                 con.close();
                 System.out.println("Adicionado tipo de aluguel com desconto de " + desconto + "%");
               } catch ( SQLException e ) {
                 System.out.println ("Erro incluindo o tipo de aluguel");
                 throw (e);
               }
              }
	  	 	    }
  	 	       Tverificar = JOptionPane.showInputDialog("TIPOS DE ALUGUEIS\n\nDeseja adicionar outro tipo de aluguel? [s/N]");	  	 	    
  	 	       if (Tverificar != null && Tverificar.equalsIgnoreCase("s"))
  	 	         TcriarOutro = 1;
	  	 	  } while (TcriarOutro == 1);
	  	 	  break;
	      }
      } while (valor != 0);
   }
}
