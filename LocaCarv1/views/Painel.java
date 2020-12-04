package LocaCarv1.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LocaCarv1.DAO.ClienteDAO;
import LocaCarv1.DAO.LocacaoDAO;
import LocaCarv1.DAO.VeiculoLeveDAO;
import LocaCarv1.DAO.VeiculoPesadoDAO;
import LocaCarv1.DAO.VeiculosLocadosDAO;
import LocaCarv1.models.Cliente;
import LocaCarv1.models.Locacao;
import LocaCarv1.models.VeiculoLeve;
import LocaCarv1.models.VeiculoPesado;
import LocaCarv1.models.VeiculosLocados;
import Libs.Teclado;

public class Painel {

	private static Scanner entrada;
	private boolean execute;
	private ArrayList<Locacao> locacoes;
	
	public static void main(String[] args) {
		new Painel();
	}

	// =========== Painel principal ===========
	public Painel() {
		entrada = new Scanner(System.in);
		execute = true;
		
		System.out.println("|------------------ PAINEL PRINCIPAL ------------------|");

		try {
			while (execute) {
				String opcao = menu();

				if (opcao.equalsIgnoreCase("1")) {
					cadastrarCliente();
				} else if (opcao.equalsIgnoreCase("2")) {

					int op;
					System.out.println(
										"Digite o tipo do Veículo: " + "\n" + 
										"[1] - Veículos Leves" + "\n" + 
										"[2] - Veículos Pesados"
									  );

					op = entrada.nextInt();

					switch (op) {
						case 1:
							cadastrarVeiculoLeve();
							break;

						case 2:
							cadastrarVeiculoPesado();
							break;

						default:
							System.out.println("|------------------ SOMENTE 1 e 2 ------------------|");
							break;
					}
				} else if (opcao.equalsIgnoreCase("3")) {
					cadastrarLocacao();

				} else if (opcao.equalsIgnoreCase("4")) {
					ClienteDAO dao = new ClienteDAO();
					List<Cliente> clientes = dao.listarTodosCadastrosCliente();

					for (Cliente cliente : clientes) {
						System.out.println(cliente);
					}
				} else if (opcao.equalsIgnoreCase("5")) {
					int op;
					System.out.println(
										"Digite o tipo do Veículo: " + "\n" + 
										"[1] - Veículos Leves" + "\n" + 
										"[2] - Veículos Pesados"
									  );

					op = entrada.nextInt();

					switch (op) {
						case 1:
						VeiculoLeveDAO veiculoLeveDao = new VeiculoLeveDAO();
						List<VeiculoLeve> veiculosLeve = veiculoLeveDao.listarTodosCadastrosVeiculoLeve();

						for (VeiculoLeve veiculoLeve : veiculosLeve) {
							System.out.println(veiculoLeve);
							veiculoLeve.qtdLocacaoRealizada();
						}
							break;

						case 2:
							VeiculoPesadoDAO dao = new VeiculoPesadoDAO();
							List<VeiculoPesado> veiculosPesado = dao.listarTodosCadastrosVeiculoPesado();

							for (VeiculoPesado veiculoPesado : veiculosPesado) {
								System.out.println(veiculoPesado);
								veiculoPesado.qtdLocacaoRealizada();
							}
							
							break;

						default:
							System.out.println("|------------------ SOMENTE 1 e 2 ------------------|");
							break;
					}
				} else if (opcao.equalsIgnoreCase("6")) {
					int op;
					System.out.println(
										"Digite o tipo do Veículo: " + "\n" + 
										"[1] - Veículos Leves" + "\n" + 
										"[2] - Veículos Pesados"
									  );

					op = entrada.nextInt();

					switch (op) {
						case 1:
							LocaCarv1.DAO.VeiculosLocadosDAO.listarLocacaoVeiculoLeve();
							break;

						case 2:
							LocaCarv1.DAO.VeiculosLocadosDAO.listarLocacaoVeiculoPesado();
							break;

						default:
							System.out.println("|------------------ SOMENTE 1 e 2 ------------------|");
							break;
					}
					
				} else {
					System.out.println("\n !!! -- SAIR -- !!! \n");
					execute = false;
				}
			}

		} catch (Exception exception) {
			System.out.println("ERRO MENU PRINCIPAL:        " + exception.getMessage());
			exception.printStackTrace();
		} finally {
			entrada.close();
		}
	}


	// =========== Método para o menu principal===========
	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Veículo");
		System.out.println("3 - Cadastrar Locação");
		System.out.println("4 - Listar Clientes");
		System.out.println("5 - Listar Veículos");
		System.out.println("6 - Listar Locações");

		System.out.println("X - Sair");
		return entrada.nextLine();
	}

	// =========== Método para cadastrar novos clientes ===========
	static void cadastrarCliente() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			int idCliente=0;
			String nome="",dataDeNascimento="",cpf="";
			Cliente dados = new Cliente(idCliente, nome, dataDeNascimento, cpf);

			System.out.println(
								"|------------------ Cadastro de Cliente ------------------|"
							);

			System.out.print("Nome: ");
			dados.setNome(Teclado.StringInput());
			System.out.print("CPF: ");
			dados.setCpf(Teclado.StringInput());
			System.out.print("Formato da Data - aaaa/MM/dd \n");
			dados.setDataDeNascimento(Teclado.StringInput());

			ClienteDAO dao = new ClienteDAO();
			dao.salvarCliente(dados);
			
			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = Teclado.StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				efetuarCadastro = false;
				new Painel();
			} else if (continuarCadastro.equalsIgnoreCase("s")) {
			} else {
				System.out.println("\n!!! -- SAIR -- !!! \n");
				efetuarCadastro = false;

			}
		}
    }
    
    // =========== Método para cadastrar Veículos Leves ===========
	private void cadastrarVeiculoLeve() throws Exception {
		boolean efetuarCadastro = true;

		int idVeiculo=0, idVeiculoLeve=0,ano=0;
		double valorLocacao = 0.0;
		String cor="",marca="",modelo="";
		while (efetuarCadastro) {
			VeiculoLeve dados = new VeiculoLeve(idVeiculo, idVeiculoLeve, cor, marca, modelo, ano, valorLocacao);

			System.out.println(
						"|------------------ URBANO ------------------|"
					);
					
			System.out.print("Marca: ");
			dados.setMarca(Teclado.StringInput());
			System.out.print("Modelo: ");
			dados.setModelo(Teclado.StringInput());
			System.out.print("Ano: ");
			dados.setAno(Teclado.IntInput());
			System.out.print("Valor da Diária: ");
			dados.setValorLocacao(Teclado.DoubleInput());
			System.out.print("Cor: ");
			dados.setCor(Teclado.StringInput());

			VeiculoLeveDAO dao = new VeiculoLeveDAO();
			dao.salvarVeiculoLeve(dados);

			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = Teclado.StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				// efetuarCadastro = false;
				new Painel();
			} else if (continuarCadastro.equalsIgnoreCase("s")) {

			} else {
				System.out.println("\n!!! -- SAIR -- !!! \n");
				efetuarCadastro = false;

			}
		}
    }
    
     // =========== Método para cadastrar  Veículos Pesados  ===========
	public static void cadastrarVeiculoPesado() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			VeiculoPesado dados = new VeiculoPesado();

			System.out.println(
						"|------------------ OFFROAD ------------------|"
					);

			System.out.print("Marca: ");
			dados.setMarca(Teclado.StringInput());
			System.out.print("Modelo: ");
			dados.setModelo(Teclado.StringInput());
			System.out.print("Ano: ");
			dados.setAno(Teclado.IntInput());
			System.out.print("Valor da Diária: ");
			dados.setValorLocacao(Teclado.DoubleInput());
			System.out.print("Restriçao: ");
			dados.setRestricao(Teclado.StringInput());

			VeiculoPesadoDAO dao = new VeiculoPesadoDAO();
			dao.salvarVeiculoPesado(dados);

			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = Teclado.StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				// efetuarCadastro = false;
				new Painel();
			} else if (continuarCadastro.equalsIgnoreCase("s")) {

			} else {
				System.out.println("\n!!! -- SAIR -- !!! \n");
				efetuarCadastro = false;

			}
		}
	}

	 // =========== Método para cadastrar Locações de Veículos ===========
	 private void cadastrarLocacao() throws Exception {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println("Cadastro de locação");
			int idLocacao = 0,idCliente= 0;
			String dataDeDevolucao = "";
			Locacao dados = new Locacao(idLocacao, idCliente, dataDeDevolucao);

			System.out.println(
						"|------------------ LOCAÇÃO ------------------|"
					);

				System.out.print("I.D. do Cliente: ");
				dados.setIdCliente(Teclado.IntInput());
				System.out.print("Formato da Data - dd/MM/aaaa \n");
				System.out.print("Data da Devolução: ");
				// dados.setDataDeLocacao(Teclado.StringInput());
				// System.out.print("Formato da Data - dd/MM/aaaa \n");
				dados.setDataDeDevolucao(Teclado.StringInput());
				// System.out.print("Dias para a Devolução: ");
				// dados.setPlusDay(Teclado.IntInput());

				LocacaoDAO dao = new LocacaoDAO();
				dao.salvarLocacao(dados);

			int op;
			System.out.println(
							"Digite o tipo do Veículo: " + "\n" +
							"[1] - Veículos Leves" + "\n" +
							"[2] - Veículos Pesados"
						);
						
			op = entrada.nextInt();
			
			switch (op) {
				case 1: 
					VeiculosLocados dadosVeiculoLeve = new VeiculosLocados();
					
					System.out.println(
										"			|----------- Veículo Urbano -----------|"
									);

					System.out.print("I.D. da Locação: ");
					dadosVeiculoLeve.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. Veículo Leve: ");
					dadosVeiculoLeve.setIdVeiculoLeve(Teclado.IntInput());

					VeiculosLocadosDAO daoVeiculosLeve = new VeiculosLocadosDAO();
					daoVeiculosLeve.salvarLocacaoVeiculoLeve(dadosVeiculoLeve);
					break;

				case 2:
					VeiculosLocados dadosVeiculoPesado = new VeiculosLocados();

					System.out.println(
										"			|----------- Veículo Pesado -----------|"
									);

					System.out.print("I.D. da Locação: ");
					dadosVeiculoPesado.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. Veículo Pesado: ");
					dadosVeiculoPesado.setIdVeiculoPesado(Teclado.IntInput());

					VeiculosLocadosDAO daoVeiculosPesado = new VeiculosLocadosDAO();
					daoVeiculosPesado.salvarLocacaoVeiculoPesado(dadosVeiculoPesado);
					break;
				
				default:
					System.out.println(
						"|------------------ SOMENTE 1 e 2 ------------------|"
				);
					break;
			}

			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = Teclado.StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				new Painel();

			} else if (continuarCadastro.equalsIgnoreCase("s")) {
				new Painel();

			} else {
				System.out.println("\n!!! -- SAIR -- !!! \n");
				efetuarCadastro = false;

			}
		}
	}
	
}
