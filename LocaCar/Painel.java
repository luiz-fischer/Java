package LocaCar;

import java.util.Scanner;

import bibliotecas.Teclado;

public class Painel extends Teclado {

	static Scanner entrada;
	private boolean execute;

	public static void main(String[] args)  {
		new Painel();
	}

	// =========== Painel principal  ===========
	private Painel()  {
		entrada = new Scanner(System.in);
		execute = true;
		System.out.println(
					"|------------------ PAINEL PRINCIPAL ------------------|"
				);

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
							System.out.println(
								"|------------------ SOMENTE 1 e 2 ------------------|"
						);
                            break;
                    }
				} else if (opcao.equalsIgnoreCase("3")) {
					cadastrarLocacao();

				} else if (opcao.equalsIgnoreCase("4")) {
                    listarCadastros();
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
                            listarVeiculosLeves();
                            break;

                        case 2:
                        	// listarVeiculosPesados();
                            break;
                        
                        default:
							System.out.println(
										"|------------------ SOMENTE 1 e 2 ------------------|"
									);
                            break;
                    }
				}  else if (opcao.equalsIgnoreCase("6")) {
					listarLocacao();
				} else {
                    System.out.println("\n !!! -- SAIR -- !!! \n");
                    execute = false;
				}
			}

		} catch (Exception exception) {
			System.out.println("ERRO MENU PRINCI: " + exception.getMessage());
			exception.printStackTrace();
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

	// =========== Método para cadastrar novos Usuarios ===========
	private void cadastrarCliente()  {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println(
						"|------------------ Cadastro de Cliente ------------------|"
					);

			Cliente dados = new Cliente();
			

			dados.setIdCliente(Cliente.clientes.size()+1);
			System.out.print("Nome: ");
			dados.setNome(StringInput());
			System.out.print("CPF: ");
            dados.setCpf(StringInput());
			System.out.print("Formato da Data - dd/MM/aaaa \n");
			System.out.print("Data De Nascimento: ");
			dados.setDataDeNascimento(StringInput());

			System.out.println("!!! -- Adicionar Cadastro (S/N) -- !!!");
			String cadastrar = StringInput();

			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");
				Cliente.clientes.add(dados);

			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
			}
			
			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				efetuarCadastro = false;
				// new Painel();

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
			System.out.println(
						"|------------------ URBANO ------------------|"
					);
					
			VeiculoLeve dados = new VeiculoLeve();
			dados.setIdVeiculoLeve(VeiculoLeve.veiculosLeves.size()+1);
			System.out.print("Marca: ");
			dados.setMarca(StringInput());
			System.out.print("Modelo: ");
			dados.setModelo(StringInput());
			System.out.print("Ano: ");
			dados.setAno(IntInput());
			System.out.print("Valor da Diária: ");
			dados.setValorLocacao(DoubleInput());
			System.out.print("Cor: ");
			dados.setCor(StringInput());
			
			System.out.println("!!! -- Adicionar Cadastro (S/N) -- !!!");
			String cadastrar = StringInput();

			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");
				VeiculoLeve.veiculosLeves.add(dados);

			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
			}

			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = StringInput();

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
	private void cadastrarVeiculoPesado()  {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println(
						"|------------------ OFFROAD ------------------|"
					);

			VeiculoPesado dados = new VeiculoPesado();
			dados.setIdVeiculoPesado(VeiculoPesado.veiculosPesados.size()+1);
			System.out.print("Marca: ");
			dados.setMarca(StringInput());
			System.out.print("Modelo: ");
			dados.setModelo(StringInput());
			System.out.print("Ano: ");
			dados.setAno(IntInput());
			System.out.print("Diária: ");
			dados.setValorLocacao(DoubleInput());
			System.out.print("Restrição: ");
			dados.setRestricao(StringInput());

			System.out.print("!!! -- Adicionar cadastro (S/N) -- !!!");
			String cadastrar = StringInput();

			if (cadastrar.equalsIgnoreCase("s")) {

				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");
				
			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
			}

			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				efetuarCadastro = false;
				// new Painel();
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
			// System.out.println("Cadastro de locação");
			// Locacao dados = new Locacao();
			// dados.setIdLocacao(Locacao.locacoes.size()+1);
			// System.out.println("I.D. Do Cliente: ");
			// dados.setIdCliente(IntInput());
			// Cliente.pesquisar(Locacao.getIdCliente());
			// dados.setIdLocacao(IntInput());
			// int op;
			// System.out.println(
			// 				"Digite o tipo do Veículo: " + "\n" +
			// 				"[1] - Veículos Leves" + "\n" +
			// 				"[2] - Veículos Pesados"
			// 			);
						
			// op = entrada.nextInt();
			
			// switch (op) {
			// 	case 1: 
					Locacao d1;
					VeiculosLocados d2;
					d1 = new Locacao();
					d2 = new VeiculosLocados();

					System.out.println("idlocacao: ");
					d1.setIdLocacao(IntInput());
					System.out.println("id cliente: ");
					d1.setIdCliente(IntInput());
					System.out.println("data locacao: ");
					d1.setDataDeLocacao(StringInput());
					System.out.println("data devolucao: ");
					d1.setDataDeDevolucao(StringInput());
					// System.out.println("id locacao: ");
					// d2.setIdLocacao(IntInput());




					// System.out.println("id veiculo leve: ");
					// d1.setIdVeiculoLeve(IntInput());
					// VeiculoLeve.pesquisar(VeiculoLeve.getIdVeiculoLeve());

					// Locacao.locacoes.add(d2);
				

					// VeiculoLeve.veiculosLeves.add(d1);
					// VeiculosLocados.veiculosLocados.add(d2);
					// VeiculosLocados.veiculosLocados.add((VeiculosLocados) d2);

			// 		break;

			// 	case 2:
			// 		break;
				
			// 	default:
			// 		System.out.println(
			// 			"|------------------ SOMENTE 1 e 2 ------------------|"
			// 	);
			// 		break;
			// }
				
			System.out.print("\nConfirmar Locação (S/N) -- !!!");
			String cadastrar = StringInput();
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");

				// Locacao.veiculosLocados.add(d1);
				Locacao.locacoes.add(d1);	
				// Locacao.veiculosLocados.add(d2);

				// VeiculosLocados.locacoes.add(d1);



			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
			}

			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = StringInput();
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

	

	// =========== Método para listar todos os Usuários Cadastrados ===========
	private void listarCadastros() {
		try {
            for (Cliente cliente : Cliente.clientes) {
                System.out.println(Cliente.clientes);
				// cliente.imprimirLocacoes();
                
            }
		} catch (Exception exception) {
			System.out.println("Erro ao listar Clientes: " + exception.getMessage());
		}

	}

    // =========== Método para listar todos os Véiculos Leves ===========
    private void listarVeiculosLeves() {
        try {
            System.out.println("Lista de Veículos Leves ");
           for (VeiculoLeve veiculoLeve : VeiculoLeve.veiculosLeves) {
			   System.out.println(VeiculoLeve.veiculosLeves);
			   
		   }
        } catch (Exception exception) {
            System.out.println("Erro ao listar Veiculos Leves: " + exception.getMessage());
        }
    }

    // =========== Método para listar todos os Véiculos Pesados ===========
    public void listarVeiculosPesados() {
        try {
            System.out.println("Lista de Veículos Pesados");
            for (VeiculoPesado veiculoPesado : VeiculoPesado.veiculosPesados) {
				System.out.println(VeiculoPesado.veiculosPesados);
            }
        } catch (Exception exception) {
            System.out.println("Erro ao listar Veiculos Pesados " + exception.getMessage());
        }
	}
	
	 // =========== Método para listar todas as Locações ===========
	 public void listarLocacao() {
        // try {
			System.out.println("|------------------- Locações -------------------|");
			// System.out.println("Veiculos Locados");
			// int tamanho = VeiculosLocados.veiculosLocados.size();
			// 	System.out.println("Tamanho" + tamanho);
            // for (Locacao veiculosLocados : VeiculosLocados.veiculosLocados) {
			// 	System.out.println(VeiculosLocados.veiculosLocados);
			// 	veiculosLocados.imprimirValorTotal();
			// 	veiculosLocados.qtdVeiculosLocados();

			// }
			// System.out.println("Locacao");
			// System.out.println(Locacao.locacoes);
			// int tamanho2 = VeiculosLocados.veiculosLocados.size();
			// 	System.out.println("Tamanho2.2" + tamanho2);
			// for (Locacao locacao : VeiculosLocados.veiculosLocados) {
			// 	locacao.imprimirValorTotal();
			// 	tamanho2 = VeiculosLocados.veiculosLocados.size();
			// 	VeiculosLocados.veiculosLocados.size();
			// 	System.out.println("tamanho2.1" + tamanho2);
			// }
			// System.out.println("Locacao 2");
			// // System.out.println(Locacao.locacoes);
			// int tamanho3 = VeiculosLocados.veiculosLocados.size();
			// 	System.out.println("Tamanho3 " + tamanho3);
			for (Locacao locacao : Locacao.locacoes) {
				System.out.println(Locacao.locacoes);
				locacao.qtdVeiculosLocados();
			}

    //     } catch (Exception exception) {
    //         System.out.println("Erro ao listar Locacoes: " + exception.getMessage());
    //     }
    }

}