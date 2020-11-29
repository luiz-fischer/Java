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
import libs.Teclado;

public class Painel {

	private static Scanner entrada;
	private boolean execute;
	private ArrayList<Locacao> locacoes;
	
	public static void main(String[] args) {
		new Painel();
	}

	// =========== Painel principal ===========
	private Painel() {
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
					List<Cliente> clientes = dao.listarTodosCadastros();

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
						List<VeiculoLeve> veiculosLeve = veiculoLeveDao.listarTodosCadastros();

						for (VeiculoLeve veiculoLeve : veiculosLeve) {
							System.out.println(veiculoLeve);
						}
							break;

						case 2:
							VeiculoPesadoDAO dao = new VeiculoPesadoDAO();
							List<VeiculoPesado> veiculosPesado = dao.listarTodosCadastros();

							for (VeiculoPesado veiculoPesado : veiculosPesado) {
								System.out.println(veiculoPesado);
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
							LocaCarv1.DAO.VeiculosLocadosDAO.listarCadastrosVeiculoLeve();
							break;

						case 2:
							LocaCarv1.DAO.VeiculosLocadosDAO.listarCadastrosVeiculoPesado();
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
	private void cadastrarCliente() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			Cliente dados = new Cliente();

			System.out.println(
								"|------------------ Cadastro de Cliente ------------------|"
							);

			System.out.print("Nome: ");
			dados.setNome(Teclado.StringInput());
			System.out.print("CPF: ");
			dados.setCpf(Teclado.StringInput());
			System.out.print("Formato da Data - aaaa/MM/dd \n");
			dados.setDataDeNascimento(Teclado.StringInput());
			System.out.print("Quantidade de dias para Locação:" +  "\n" + "[5] - [10] - [15]: ");
			dados.setQtdDiasLocacao(Teclado.IntInput());

			ClienteDAO dao = new ClienteDAO();
			dao.salvar(dados);
			
			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = Teclado.StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				efetuarCadastro = false;
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

		while (efetuarCadastro) {
			// veiculos = new ArrayList<Veiculo>();
			// veiculosLeve = new ArrayList<VeiculoLeve>();
			VeiculoLeve dados = new VeiculoLeve();

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
			dao.salvar(dados);

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
    
     // =========== Método para cadastrar  Veículos Pesados  ===========
	private void cadastrarVeiculoPesado() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			// veiculos = new ArrayList<Veiculo>();
			// veiculosPesado = new ArrayList<VeiculoPesado>();
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
			dao.salvar(dados);

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

	 // =========== Método para cadastrar Locações de Veículos ===========
	 private void cadastrarLocacao() throws Exception {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println("Cadastro de locação");
			Locacao dados = new Locacao();

			System.out.println(
						"|------------------ LOCAÇÃO ------------------|"
					);

				System.out.print("I.D. do Cliente: ");
				dados.setIdCliente(Teclado.IntInput());
				System.out.print("Formato da Data - dd/MM/aaaa \n");
				System.out.print("Data da Locação: ");
				dados.setDataDeLocacao(Teclado.StringInput());
				System.out.print("Formato da Data - dd/MM/aaaa \n");
				System.out.print("Data da Devolução: ");
				dados.setDataDeDevolucao(Teclado.StringInput());

				LocacaoDAO dao = new LocacaoDAO();
				dao.salvar(dados);

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
					daoVeiculosLeve.salvarVeiculoLeve(dadosVeiculoLeve);
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
					daoVeiculosPesado.salvarVeiculoPesado(dadosVeiculoPesado);
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
				efetuarCadastro = false;
				new Painel();
			} else if (continuarCadastro.equalsIgnoreCase("s")) {

			} else {
				System.out.println("\n!!! -- SAIR -- !!! \n");
				efetuarCadastro = false;
			}
		}
	}
	
}
