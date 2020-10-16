package Cadastro.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Cadastro.modelo.Usuario;

public class Main {

	private Scanner l;
	private boolean execute;
	private List<Usuario> usuarios;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		l = new Scanner(System.in);
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
			} else {
				System.out.println("\nOpção Inválida !!! \n");
			}
		}
	}

	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("N - Novo cadastro");
		System.out.println("L - Listar cadastros");
		System.out.println("X - Sair");
		return l.nextLine();
	}

	private void cadastrar() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("Cadastro de Usuário");
			Usuario d = new Usuario();						
			d.setNome(textInput("Nome:"));
			d.setCpf(textInput("Cpf: "));
			d.setEmail(textInput("email: "));
			d.setTelefone(textInput("telefone: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro adicionado !!!");
				usuarios.add(d);
				Cadastro.dao.UsuarioDAO.salvar(usuarios);
				
			} else if (cadastrar.equalsIgnoreCase("n")){
				System.out.println("Cadastro ignorado !!!");
			} else {
				System.out.println("\nOpção inválida!!! \n");
			}

			String continua = textInput("Continuar cadastrando (S/N) ?");
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("s")){
			
			} else {
				System.out.println("\nOpção inválida!! \n");
				cadastrando = false;
			}
		}
	}

	private void listarCadastros() {
		if (usuarios.size() == 0) {
			System.out.println("\nNão existem cadastros !!!\n");
		} else {
			System.out.println("\nLista de Cadastros\n");
			
			for (int i = 0; i < usuarios.size(); i++) {
				// Usuario d = usuarios.get(i);
				System.out.println("Cadastro número: " + i);
				System.out.println("\tNome: " + Usuario.getNome());
				System.out.println("\tCPF: " + Usuario.getCpf());
				System.out.println("\temail: " + Usuario.getEmail());
				System.out.print("\tTelefone: " + Usuario.getTelefone() + "\n");
			}
			System.out.println("\nFim da lista\n");
		}
	}

	private String textInput(String label) {
		System.out.println(label);
		return l.nextLine();
	}
   
}