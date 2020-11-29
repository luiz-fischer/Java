package LocaCar;

import bibliotecas.Teclado;

import java.util.Scanner;

public class Painel  {

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
                        	listarVeiculosPesados();
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

			Cliente dados = new Cliente(0);
			
			System.out.print("I.D. Cliente: ");
			dados.setIdCliente(Teclado.IntInput());
			System.out.print("Nome: ");
			dados.setNome(Teclado.StringInput());
			System.out.print("CPF: ");
            dados.setCpf(Teclado.StringInput());
			System.out.print("Formato da Data - dd/MM/aaaa \n");
			System.out.print("Data De Nascimento: ");
			dados.setDataDeNascimento(Teclado.StringInput());

			System.out.println("!!! -- Adicionar Cadastro (S/N) -- !!!");
			String cadastrar = Teclado.StringInput();

			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");
				Cliente.clientes.add(dados);

			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
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
			dados.setMarca(Teclado.StringInput());
			System.out.print("Modelo: ");
			dados.setModelo(Teclado.StringInput());
			System.out.print("Ano: ");
			dados.setAno(Teclado.IntInput());
			System.out.print("Valor da Diária: ");
			dados.setValorLocacao(Teclado.DoubleInput());
			System.out.print("Cor: ");
			dados.setCor(Teclado.StringInput());
			
			System.out.println("!!! -- Adicionar Cadastro (S/N) -- !!!");
			String cadastrar = Teclado.StringInput();

			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");
				VeiculoLeve.veiculosLeves.add(dados);

			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
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
			dados.setMarca(Teclado.StringInput());
			System.out.print("Modelo: ");
			dados.setModelo(Teclado.StringInput());
			System.out.print("Ano: ");
			dados.setAno(Teclado.IntInput());
			System.out.print("Diária: ");
			dados.setValorLocacao(Teclado.DoubleInput());
			System.out.print("Restrição: ");
			dados.setRestricao(Teclado.StringInput());

			System.out.print("!!! -- Adicionar cadastro (S/N) -- !!!");
			String cadastrar = Teclado.StringInput();

			if (cadastrar.equalsIgnoreCase("s")) {

				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");
				
			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
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

	 // =========== Método para cadastrar Locações de Veículos ===========
	 private void cadastrarLocacao() throws Exception {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println("Cadastro de locação");
			Locacao dados = new Locacao();
					System.out.print("I.D. da Locação: ");
					dados.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. do Cliente: ");
					dados.setIdCliente(Teclado.IntInput());
					System.out.print("Data da Locação: ");
					dados.setDataDeLocacao(Teclado.StringInput());
					System.out.print("Data da Devolução: ");
					dados.setDataDeDevolucao(Teclado.StringInput());
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
					System.out.print("I.D. : ");
					dadosVeiculoLeve.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. da Locação: ");
					dadosVeiculoLeve.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. Veículo Leve: ");
					dadosVeiculoLeve.setIdVeiculoLeve(Teclado.IntInput());
					VeiculosLocados.veiculosLocados.add(dadosVeiculoLeve);
					break;

				case 2:
					VeiculosLocados dadosVeiculoPesado = new VeiculosLocados();
					System.out.print("I.D. : ");
					dadosVeiculoPesado.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. da Locação: ");
					dadosVeiculoPesado.setIdLocacao(Teclado.IntInput());
					System.out.print("I.D. Veículo Pesado: ");
					dadosVeiculoPesado.setIdVeiculoLeve(Teclado.IntInput());
					VeiculosLocados.veiculosLocados.add(dadosVeiculoPesado);
					break;
				
				default:
					System.out.println(
						"|------------------ SOMENTE 1 e 2 ------------------|"
				);
					break;
			}
				
			System.out.print("\nConfirmar Locação (S/N) -- !!!");
			String cadastrar = Teclado.StringInput();
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("!!! -- CADASTRO ADICIONADO -- !!!");

				Locacao.locacoes.add(dados);
				

			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("!!! -- CADASTRO DESCARTADO -- !!!");
			} else {
				System.out.println("\n!!! -- Opção Inválida -- !!! \n");
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

	

	// =========== Método para listar todos os Usuários Cadastrados ===========
	private void listarCadastros() {
            for (Cliente cliente : Cliente.clientes) {
				for (Locacao locacao : Locacao.locacoes) {
               			 System.out.println(
								"\n|---------------     Dados do Cliente        ---------------|" + "\n" + 
								"Id do CLiente:                             " + cliente.idCliente + "\n" +
								"Nome:                                      " + cliente.nome + "\n" + 
								"Data de Nascimento:                        " + cliente.dataDeNascimento + "\n" + 
								"CPF:                                       " + cliente.cpf + "\n" + 
								"Quantidade de Veiculos Locados:            " + locacao.			qtdVeiculosLocados() + "\n" + 
								"Dias para Devolução: 		           " + locacao.qtdDiasLocados() +
								"\n|-----------------------------------------------------------|\n"
						);
				}
				
			}
		}

    // =========== Método para listar todos os Véiculos Leves ===========
    private void listarVeiculosLeves() {
            System.out.println("Lista de Veículos Leves ");
           for (VeiculoLeve veiculoLeve : VeiculoLeve.veiculosLeves) {
			   System.out.println(veiculoLeve);
		   }
		
	}

    // =========== Método para listar todos os Véiculos Pesados ===========
    private void listarVeiculosPesados() {
            System.out.println("Lista de Veículos Pesados");
            for (VeiculoPesado veiculoPesado : VeiculoPesado.veiculosPesados) {
				System.out.println(VeiculoPesado.veiculosPesados);
            }
	}
	
	 // =========== Método para listar todas as Locações ===========
	private void listarLocacao() {
		try {
			System.out.println("|------------------- Locações -------------------|");

			for (Cliente cliente : Cliente.clientes) {
				for (Locacao locacao : Locacao.locacoes) {
					for (VeiculosLocados veiculosLocados : VeiculosLocados.veiculosLocados) {
						
						if(locacao.idLocacao == veiculosLocados.idLocacao){
							System.out.println(
							"           |--------Lista de Carros Alugados--------|"          + "\n" +
							"I.D. Locacao:             "         + locacao.idLocacao + "\n" +
							"I.D. Cliente:             "         + locacao.idCliente + "\n" +
							"Nome do Cliente:          " 		 + cliente.nome + "\n" +
							"Data de Locação:          "         + locacao.dataDeLocacao + "\n" + 
							"Data de Devolução:        "         + locacao.dataDeDevolucao + "\n" +
							"Total de dias:            "         + locacao.qtdDiasLocados() + "\n" +
							VeiculoLeve.pesquisar(Integer.valueOf(veiculosLocados.idVeiculoLeve))
						);
					} else {
						System.out.println("Nao tem Cadastro!!!!");
					}
				}
			}
		}
	} catch (Exception exception) {
		System.out.println("Erro ao listar Locacoes: " + exception.getMessage());
	}
}


}