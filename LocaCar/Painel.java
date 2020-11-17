package LocaCar;


import java.util.Scanner;

public class Painel {

	private Scanner entrada;
	private boolean execute;

	public static void main(String[] args) {
		new Painel();
	}

	// =========== Painel principal , decisão das escolhas ===========
	private Painel() {
		entrada = new Scanner(System.in);
		execute = true;
		// clientes = new ArrayList<Cliente>();
		System.out.println("BEM VINDO AO PAINEL PRINCIPAL");

		try {
			while (execute) {
				String opcao = menu();

				if (opcao.equalsIgnoreCase("1")) {
					cadastrarCliente();
				} else if (opcao.equalsIgnoreCase("2")) {
                    int op;
                    System.out.println("Digite o tipo do Veículo: " + "\n" +
                                    "[1] - Veículos Leves" + "\n" +
                                    "[2] - Veículos Pesados"
                                );
                    op = entrada.nextInt();
                    switch (op) {
                        case 1: 
                            System.out.println("Cadastro de Veículo Leve!");
                            cadastrarVeiculoLeve();

                            break;

                        case 2:
                            System.out.println("Cadastro de Veículo Pesado!");
                            cadastrarVeiculoPesado();
                            break;
                        
                        default:
                        System.out.println("Digite SOMENTE números entre 1 e 2");
                        cadastrarVeiculoPesado();
                            break;
                    }
				} else if (opcao.equalsIgnoreCase("3")) {
					Cliente.pesquisar();
				} else if (opcao.equalsIgnoreCase("4")) {
                    listarCadastros();
				} else if (opcao.equalsIgnoreCase("5")) {
					int op;
                    System.out.println("Digite o tipo do Veículo: " + "\n" +
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
                        	System.out.println("Digite SOMENTE números entre 1 e 2");
                        	cadastrarVeiculoPesado();
                            break;
                    }
				}  else if (opcao.equalsIgnoreCase("6")) {
					// LISTAR LOCACOES
				} else {
                    System.out.println("\n !!! SAIR !!! \n");
                    execute = false;
				}
			}

		} catch (Exception exception) {
			System.out.println("Erro 1: " + exception);
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
			System.out.println("Cadastro de Cliente");
            Cliente dados = new Cliente();
            dados.setIdCliente(Cliente.clientes.size()+1);
            dados.setNome(textInput("Nome: "));
            dados.setCpf(textInput("Cpf: "));
            System.out.print("Formato da Data De Nascimento - dd/MM/aaaa \n");
			dados.setDataDeNascimento(textInput("Data De Nascimento: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro adicionado !!!");
				Cliente.clientes.add(dados);

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
				System.out.println("\nSAÍNDO \n");
				efetuarCadastro = false;
			}
		}
    }
    
    // =========== Método para cadastrar Veículos Leves ===========
	private void cadastrarVeiculoLeve()  {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			VeiculoLeve dados = new VeiculoLeve();
            dados.setIdVeiculoLeve(VeiculoLeve.veiculosLeves.size()+1);
            dados.setMarca(textInput("Marca: "));
            dados.setModelo(textInput("Modelo: "));
            dados.setAno(intInput("Ano: "));
            dados.setValorLocacao(doubleInput("Diária: "));
			dados.setCor(textInput("Cor: "));
            
			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro adicionado !!!");
				VeiculoLeve.veiculosLeves.add(dados);

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
				System.out.println("\nSAÍNDO \n");
				efetuarCadastro = false;
			}
		}
    }
    
     // =========== Método para cadastrar  Veículos Pesados  ===========
	private void cadastrarVeiculoPesado()  {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			System.out.println("Cadastro de Veículo Pesado");
			VeiculoPesado dados = new VeiculoPesado();
            dados.setIdVeiculoPesado(VeiculoPesado.veiculosPesados.size()+1);
			dados.setMarca(textInput("Marca: "));
            dados.setModelo(textInput("Modelo: "));
            dados.setAno(intInput("Ano: "));
            dados.setValorLocacao(doubleInput("Diária: "));
			dados.setRestricao(textInput("Restrição: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro adicionado !!!");
				VeiculoPesado.veiculosPesados.add(dados);

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
				System.out.println("\nSAÍNDO \n");
				efetuarCadastro = false;
			}
		}
	}

    // =========== Método para listar todos os Usuários Cadastrados ===========
	private void listarCadastros() {
		try {
            System.out.println("Clientes");
            // System.out.println(Cliente.clientes);
            for (Cliente cliente : Cliente.clientes) {
                System.out.println(Cliente.clientes);
                cliente.imprimirLocacoes();
                
            }
		} catch (Exception exception) {
			System.out.println("Erro ao listar: " + exception);
			exception.printStackTrace();
		}

	}

    // =========== Método para listar todos os Véiculos Leves ===========
    public void listarVeiculosLeves() {
        try {
            System.out.println("Lista de Veículos Leves");
            for (VeiculoLeve veiculoLeve : VeiculoLeve.veiculosLeves) {
				System.out.println(VeiculoLeve.veiculosLeves);
				System.out.println(veiculoLeve);
            }
        } catch (Exception exception) {
            System.out.println("Erro ao listar: " + exception);
			exception.printStackTrace();
        }
    }
    



    // =========== Método para listar todos os Véiculos Pesados ===========
    public void listarVeiculosPesados() {
        try {
            System.out.println("Lista de Veículos Pesados");
            for (VeiculoPesado veiculoPesado : VeiculoPesado.veiculosPesados) {
				System.out.println(VeiculoPesado.veiculosPesados);
				System.out.println(veiculoPesado);
            }
        } catch (Exception exception) {
            System.out.println("Erro ao listar: " + exception);
			exception.printStackTrace();
        }
    }

    // =========== Método para inserção ===========
	private String textInput(String texto) {
		System.out.print(texto);
		return entrada.nextLine();
    }
    private int intInput(String texto) {
		System.out.print(texto);
		return entrada.nextInt();
    }
    private double doubleInput(String texto) {
		System.out.print(texto);
		return entrada.nextDouble();
	}
}