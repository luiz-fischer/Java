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
	private Main() {
		entrada = new Scanner(System.in);
		execute = true;
		usuarios = new ArrayList<Usuario>();
		System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS");

		try {
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
				} else if (opcao.equalsIgnoreCase("d")) {
					deletar();
				} else {
					System.out.println("\nOpção Inválida !!! \n");
				}
			}

		} catch (SQLException exception) {
			System.out.println("Erro: " + exception);
		}
	}

	// =========== Método para o menu principal===========
	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("N - Novo cadastro");
		System.out.println("L - Listar cadastros");
		System.out.println("P - Pesquisar nome");
		System.out.println("D - Deletar por Id");
		System.out.println("X - Sair");
		return entrada.nextLine();
	}

	// =========== Método para cadastrar novos Usuarios ===========
	private void cadastrar() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println("Cadastro de Usuário");
			Usuario dados = new Usuario();
			// dados.setId(textInput("Id:"));
			dados.setNome(textInput("Nome:"));
			dados.setCpf(textInput("Cpf: "));
			dados.setEmail(textInput("email: "));
			dados.setTelefone(textInput("telefone: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				// System.out.println("Cadastro adicionado !!!");
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
	private void listarCadastros() {
		try {
			Cadastro.dao.UsuarioDAO.listarTodosCadastros();
		} catch (SQLException exception) {
			System.out.println("Erro ao listar: " + exception);
			exception.printStackTrace();
		}

	}

	// =========== Método para pesquisar Usuários pelo nome ===========
	private void pesquisar() {
		try {
			Scanner entrada = new Scanner(System.in);
			System.out.print("Pesquisar por nome: ");
			String nome = entrada.nextLine();

			Cadastro.dao.UsuarioDAO.pesquisar(nome);
			for (Usuario usuario : usuarios) {
				System.out.println(usuario);
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao Pesquisar: " + exception);
		}
	}

	// =========== Método para deletar um usuario pelo Id ===========
	private void deletar() {
		try {
			Scanner entrada = new Scanner(System.in);
			System.out.print("Digite o id para ser deletado: ");
			String id = entrada.nextLine();

			Cadastro.dao.UsuarioDAO.deletar(id);

		} catch (SQLException exception) {
			System.out.println("Erro ao Deletar: " + exception);

		}
	}

	// =========== Método para inserção ===========
	private String textInput(String texto) {
		System.out.println(texto);
		return entrada.nextLine();
	}

}