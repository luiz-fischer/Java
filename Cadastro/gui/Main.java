package Cadastro.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Cadastro.modelo.Usuario;

public class Main {

	private Scanner entrada;
	private boolean execute;
	private ArrayList<Usuario> usuarios;

	public static void main(String[] args) throws SQLException {
		new Main();
	}

	// =========== Painel principal , decisão das escolhas ===========
	private Main() throws SQLException {
		entrada = new Scanner(System.in);
		execute = true;
		usuarios = new ArrayList<Usuario>();
		System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS");

		while (execute) {
			String opcao = menu();

			if (opcao.equalsIgnoreCase("n")) {
				cadastrar();
			} else if (opcao.equalsIgnoreCase("l")) {
				listarCadastros();
			} else if (opcao.equalsIgnoreCase("x")) {
				execute = false;
			} else if (opcao.equalsIgnoreCase("p")) {
				pesquisar();
			} else {
				System.out.println("\nOpção Inválida !!! \n");
			}
		}
	}

	// =========== Método para o menu principal===========
	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("N - Novo cadastro");
		System.out.println("L - Listar cadastros");
		System.out.println("P - Pesquisar nome");
		System.out.println("X - Sair");
		return entrada.nextLine();
	}

	// =========== Método para cadastrar novos Usuarios ===========
	private void cadastrar() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println("Cadastro de Usuário");
			Usuario dados = new Usuario();
			dados.setId(textInput("Id:"));
			dados.setNome(textInput("Nome:"));
			dados.setCpf(textInput("Cpf: "));
			dados.setEmail(textInput("email: "));
			dados.setTelefone(textInput("telefone: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro adicionado !!!");
				usuarios.add(dados);
				Cadastro.dao.UsuarioDAO.salvar(usuarios);

			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("Cadastro ignorado !!!");
			} else {
				System.out.println("\nOpção inválida!!! \n");
			}

			String continuarCadastro = textInput("Continuar cadastrando (S/N) ?");
			if (continuarCadastro.equalsIgnoreCase("N")) {
				efetuarCadastro = false;
			} else if (continuarCadastro.equalsIgnoreCase("s")) {

			} else {
				System.out.println("\nOpção inválida!! \n");
				efetuarCadastro = false;
			}
		}
	}

	// =========== Método para listar todos os Usuários Cadastrados ===========
	private void listarCadastros()  {
		try {
			Cadastro.dao.UsuarioDAO.listarTodosCadastros();
		} catch (SQLException e) {
			System.out.println("Erro Lista: " + e);
			e.printStackTrace();
		}

	}

	// =========== Método para pesquisar Usuários pelo nome ===========
	private void pesquisar() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Pesquisar por nome: ");
		String nome = sc.nextLine();
		
		Cadastro.dao.UsuarioDAO.pesquisar(nome);
	}

	// =========== Método para inserção ===========
	private String textInput(String texto) {
		System.out.println(texto);
		return entrada.nextLine();
	}

}