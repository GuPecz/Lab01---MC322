import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main 
{
	public static LocalDate LeData(Scanner input)
	{
		String data;
		int dia = 0, mes = 0, ano = 0;
		boolean dataValida;
	
		do
		{
			data = input.nextLine();
			data = data.replaceAll("\\D", "");
	
			if (data.length() != 8)
			{
				System.out.println("ERRO: Data inválida");
				dataValida = false;
			}
			else
			{
				dia = Integer.parseInt(data.substring(0, 2));
				mes = Integer.parseInt(data.substring(2, 4));
				ano = Integer.parseInt(data.substring(4, 8));
	
				dataValida = Validacao.validarData(dia, mes, ano);
			}
		} while (!dataValida);
	
		return LocalDate.of(ano, mes, dia);
	}

	public static String lePalavra(Scanner input)
	{
		String nome;
		boolean nomeValido;

		do
		{
			nome = input.nextLine();

			nomeValido = Validacao.validarNome(nome);
			if (!nomeValido)
				System.out.println("ERRO: Palavra inválida");
		} while (!nomeValido);

		return nome;
	}

	public static Seguradora instanciarSeguradora(Scanner input)
	{
		System.out.print("Inisira o nome da seguradora: ");
		String nome = lePalavra(input);

		System.out.print("Insira o telefone da seguradora: ");
		String telefone = input.nextLine();

		System.out.print("Insira o e-mail da seguradora: ");
		String email = input.nextLine();

		System.out.print("Insira o endereço da seguradora: ");
		String endereco = input.nextLine();

		return new Seguradora(nome, telefone, email, endereco, new ArrayList<Sinistro>(), new ArrayList<Cliente>());
	}

	public static void listarSeguradoras(List<Seguradora> listaSeguradoras)
	{
		int tam = listaSeguradoras.size();

		System.out.println("Seguradoras cadastradas: ");

		for (int i = 0; i < tam; i++)
			System.out.println((i + 1) + " - " + listaSeguradoras.get(i).getNome());
	}

	public static void IniciarCliente(Cliente cliente, Scanner input)
    {
        System.out.print("Insira o nome do cliente: ");
        String nome = lePalavra(input);
        cliente.setNome(nome);

        System.out.print("Insira o endereço do cliente: ");
        String endereco = input.nextLine();
        cliente.setEndereco(endereco);

        List<Veiculo> listaVeiculos = new ArrayList<>();
        cliente.setListaVeiculos(listaVeiculos);
    }


    public static ClientePF instanciarPF(Scanner input)
    {
        System.out.print("Insira o CPF do cliente: ");
        String cpf = input.nextLine();;
        boolean valido = Validacao.validarCPF(cpf);
        
        while (!valido)
        {
            System.out.println("ERRO: CPF inválido\nTente novamente");
            cpf = input.nextLine();
            valido = Validacao.validarCPF(cpf);
        }
        
        ClientePF cliente = new ClientePF(null, null, null, 0.0, cpf, null, null, null, null, null);
        
        IniciarCliente(cliente, input);
        
        System.out.print("Insira o gênero do cliente: ");
        String genero = lePalavra(input);
        cliente.setGenero(genero);

        LocalDate dataLicenca = LocalDate.now();
        cliente.setDataLicenca(dataLicenca);

        System.out.print("Insira o grau de escolaridade do cliente: ");
        String educacao = input.nextLine();
        cliente.setEducacao(educacao);

        System.out.print("Insira a classe econômica do cliente: ");
        String classeEconomica = lePalavra(input);
        cliente.setClasseEconomica(classeEconomica);

        System.out.print("Insira a data de nascimento do cliente [dd/mm/aaaa]: ");
		LocalDate dataNascimento = LeData(input);
        cliente.setDataNascimento(dataNascimento);
        
        return cliente;
    }

    public static ClientePJ instanciarPJ(Scanner input)
    {
        System.out.print("Insira o CNPJ do cliente: ");
        String cnpj = input.nextLine();
        boolean valido = Validacao.validarCNPJ(cnpj);

        while (!valido)
        {
            System.out.println("ERRO: CNPJ inválido\nTente novamente");
            cnpj = input.nextLine();
            valido = Validacao.validarCNPJ(cnpj);
        }

        ClientePJ cliente = new ClientePJ(null, null, null, 0.0, cnpj, null, 0);

        IniciarCliente(cliente, input);

        System.out.print("Insira a data de fundação do cliente [dd/mm/aaaa]: ");
		LocalDate dataFundacao = LeData(input);
        cliente.setDataFundacao(dataFundacao);

		System.out.print("Insira a quantidade de funcionários do cliente: ");
		int qtdeFuncionarios;
		do
		{
			qtdeFuncionarios = input.nextInt();
			input.nextLine();
		} while (qtdeFuncionarios < 0);
		cliente.setQtdeFuncionarios(qtdeFuncionarios);

        return cliente;
    }

    public static Veiculo instanciarVeiculo(Scanner input)
    {
        System.out.print("Insira a placa do veículo: ");
        String placa = input.nextLine();
        
        System.out.print("Insira o modelo do veículo: ");
        String modelo = input.nextLine();

        System.out.print("Insira a marca do veículo: ");
        String marca = input.nextLine();

        System.out.print("Insira o ano de fabricação do veículo: ");
        int anoFabricacao = input.nextInt();
        input.nextLine();

        return new Veiculo(placa, modelo, marca, anoFabricacao);
    }

    public static Sinistro instanciarSinistro(Scanner input, Seguradora seguradora, Veiculo veiculo, Cliente cliente)
    {
        System.out.print("Insira a data do sinistro [dd/mm/aaaa]: ");
		LocalDate dataSinistro = LeData(input);

        System.out.print("Insira o endereço do sinistro: ");
        String endereco = input.nextLine();

        return new Sinistro(dataSinistro, endereco, seguradora, veiculo, cliente);
    }

	private static void exibirMenuExterno() 
	{
		MenuOperacoes menuOperacoes[] = MenuOperacoes.values();

		System.out.println("Menu principal");
		for(MenuOperacoes op: menuOperacoes)
			System.out.println((op.ordinal() + 1) + " - " + op.getDescricao());
	}

	private static void exibirSubmenu(MenuOperacoes op) 
	{
		SubmenuOperacoes[] submenu = op.getSubmenu();

		System.out.println(op.getDescricao());
		for(int i = 0; i < submenu.length; i++)
			System.out.println((i + 1) + " - " + submenu[i].getDescricao());
	}
	
	private static MenuOperacoes lerOpcaoMenuExterno() 
	{
		Scanner input = new Scanner(System.in);
		int opUsuario;
		MenuOperacoes opUsuarioConst;

		do 
		{
			System.out.println("Digite uma opção: ");
			opUsuario = input.nextInt();
			input.nextLine();
		} while(opUsuario <= 0 || opUsuario > MenuOperacoes.values().length);

		opUsuarioConst = MenuOperacoes.values()[opUsuario - 1];
		return opUsuarioConst;
	}
	
	private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) 
	{
		Scanner input = new Scanner(System.in);
		int opUsuario;
		SubmenuOperacoes opUsuarioConst;

		do 
		{
			System.out.println("Digite uma opção: ");
			opUsuario = input.nextInt();
			input.nextLine();
		} while(opUsuario <= 0 || opUsuario > op.getSubmenu().length);

		opUsuarioConst = op.getSubmenu()[opUsuario - 1];
		return opUsuarioConst;
	}
	
	private static void executarOpcaoMenuExterno(MenuOperacoes op, List<Seguradora> listaSeguradoras) 
	{
		Scanner input = new Scanner(System.in);
		Seguradora seguradora;

		switch(op) 
		{
			case CADASTRAR:

			case LISTAR:

			case EXCLUIR:
				executarSubmenu(op, listaSeguradoras);
				break;

			case GERAR_SINISTRO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				Cliente cliente = selecionarCliente(seguradora);
				Veiculo veiculo = selecionarVeiculo(cliente);
				System.out.println("Iniciando registro do sinistro");
				seguradora.gerarSinistro(instanciarSinistro(input, seguradora, veiculo, cliente));
				cliente.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente));
				break;

			case TRANSFERIR_SEGURO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				if (seguradora.getListaClientes().size() < 2)
					System.out.println("ERRO: Não há clientes suficientes para uma transferência");
				else
				{
					Cliente transferente = selecionarCliente(seguradora);
					Cliente recebedor = selecionarCliente(seguradora);

					Collections.copy(recebedor.getListaVeiculos(), transferente.getListaVeiculos());
					for (Veiculo v: transferente.getListaVeiculos())
						transferente.getListaVeiculos().remove(v);

					recebedor.setValorSeguro(seguradora.calcularPrecoSeguroCliente(recebedor));
					transferente.setValorSeguro(seguradora.calcularPrecoSeguroCliente(transferente));
					System.out.println("Seguro de " + transferente.getNome() + " transferido para " + recebedor.getNome());
				}
				break;

			case CALCULAR_RECEITA:
				seguradora = selecionarSeguradora(listaSeguradoras);
				double receita = seguradora.calcularReceita();

				System.out.print("Receita = ");
				if (receita == 0.0)
					System.out.println("0.0");
				else
					System.out.println(receita);
				break;

			case SAIR:
			break;
		}
	}

	public static Seguradora selecionarSeguradora(List<Seguradora> listaSeguradoras)
	{
		Seguradora seguradora;
		Scanner input = new Scanner(System.in);

		if (listaSeguradoras.isEmpty())
		{
			System.out.println("Por favor, cadastre uma seguradora primeiro");
			seguradora = instanciarSeguradora(input);
			listaSeguradoras.add(seguradora);
		}
		else
		{
			listarSeguradoras(listaSeguradoras);
			System.out.println("Selecione uma seguradora");
			int opcao;
			boolean indiceValido = true;
			do
			{
				opcao = input.nextInt() - 1;
				input.nextLine();
				if (opcao > listaSeguradoras.size() - 1 || opcao < 0)
				{	
					indiceValido = false;
					System.out.println("ERRO: Opção inválida");
				}
				else
					indiceValido = true;
			} while (!indiceValido);
			seguradora = listaSeguradoras.get(opcao);
			input.nextLine();
		}

		return seguradora;
	}

	public static Cliente selecionarCliente(Seguradora seguradora)
	{
		Scanner input = new Scanner(System.in);
		Cliente cliente;

		if (seguradora.getListaClientes().isEmpty())
		{
			System.out.println("Por favor, cadastre um cliente primeiro");
			cliente = cadastrarCliente();
			seguradora.getListaClientes().add(cliente);
		}
		else
		{
			System.out.println("Selecione um cliente: ");
			seguradora.listarClientesPorSeguradora();
			cliente = seguradora.getListaClientes().get(input.nextInt() - 1);
			input.nextLine();
		}

		return cliente;
	}

	public static Veiculo selecionarVeiculo(Cliente cliente)
	{
		Scanner input = new Scanner(System.in);
		Veiculo veiculo;

		System.out.println(cliente.listarVeiculosPorCliente());

		if (cliente.getListaVeiculos().isEmpty())
		{
			System.out.println("Por favor, registre um veículo primeiro");
			veiculo = instanciarVeiculo(input);
			cliente.getListaVeiculos().add(veiculo);
		}
		else
		{
			int opcao = input.nextInt() - 1;
			veiculo = cliente.getListaVeiculos().get(opcao);
		}

		return veiculo;
	}

	public static Cliente cadastrarCliente()
	{
		Scanner input = new Scanner(System.in);
		String tipoCliente;

		System.out.println("Iniciando cadastro de cliente");
		System.out.println("Pessoa física ou jurídica? [f/j]");

		do
		{
			tipoCliente = input.nextLine();
		} while (!(tipoCliente.equals("f") || tipoCliente.equals("j")));
		
		if (tipoCliente.equals("f"))
			return instanciarPF(input);
		else
			return instanciarPJ(input);
	}

	public static void cadastrarVeiculo(Seguradora seguradora)
	{
		Scanner input = new Scanner(System.in);
		Cliente cliente = selecionarCliente(seguradora);

		System.out.println("Iniciando cadastro de veículo");
		cliente.getListaVeiculos().add(instanciarVeiculo(input));
		cliente.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente));
	}

	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu, List<Seguradora> listaSeguradoras) 
	{
		Scanner input = new Scanner(System.in);
		Seguradora seguradora;

		switch(opSubmenu) 
		{
			case CADASTRAR_CLIENTE:
				seguradora = selecionarSeguradora(listaSeguradoras);
				Cliente cliente = cadastrarCliente();
				double valorSeguro = seguradora.calcularPrecoSeguroCliente(cliente);
				cliente.setValorSeguro(valorSeguro);
				seguradora.getListaClientes().add(cliente);
				break;

			case CADASTRAR_VEICULO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				cadastrarVeiculo(seguradora);
				break;

			case CADASTRAR_SEGURADORA:
				System.out.println("Iniciando cadastro de seguradora");
				listaSeguradoras.add(instanciarSeguradora(input));
				break;

			case LISTAR_CLIENTES_POR_SEGURADORA:
				seguradora = selecionarSeguradora(listaSeguradoras);
				seguradora.listarClientesPorSeguradora();
				break;

			case LISTAR_SINISTROS_POR_SEGURADORA:
				seguradora = selecionarSeguradora(listaSeguradoras);
				seguradora.listarSinistrosPorSeguradora();
				break;

			case LISTAR_SINISTROS_POR_CLIENTE:
				seguradora = selecionarSeguradora(listaSeguradoras);
				if (seguradora.getListaSinistros().isEmpty())
				{
					System.out.println("ERRO: Não há sinistros registrados");
					break;
				}
				else if (seguradora.getListaClientes().isEmpty())
				{
					System.out.println("ERRO: Não há clientes cadastrados");
					break;
				}
				
				System.out.println("Insira o documento do cliente: ");
				String documento = input.nextLine();
				seguradora.listarSinistrosPorCliente(documento);
				break;

			case LISTAR_VEICULOS_POR_SEGURADORA:
				seguradora = selecionarSeguradora(listaSeguradoras);
				seguradora.listarVeiculosPorSeguradora();
				break;

			case LISTAR_VEICULOS_POR_CLIENTE:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Clientes registrados nesta seguradora");
				seguradora.listarClientesPorSeguradora();
				System.out.println("Selecione um cliente: ");
				int opcao = input.nextInt() - 1;
				input.nextLine();
				seguradora.getListaClientes().get(opcao).listarVeiculosPorCliente();
				break;

			case EXCLUIR_CLIENTE:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira o documento do cliente: ");
				String documento2 = input.nextLine();
				seguradora.listarSinistrosPorCliente(documento2);
				break;

			case EXCLUIR_VEICULO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira a placa do veículo: ");
				String placa = input.nextLine();
				seguradora.excluirVeiculo(placa);
				break;

			case EXCLUIR_SINISTRO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira o ID do sinistro: ");
				int id = input.nextInt();
				input.nextLine();
				seguradora.excluirSinistro(id);
				break;

			case VOLTAR:
			break;
		}
	}
	
	private static void executarSubmenu(MenuOperacoes op, List<Seguradora> listaSeguradoras) 
	{
		SubmenuOperacoes opSubmenu;

		do 
		{
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu, listaSeguradoras);
		} while(opSubmenu != SubmenuOperacoes.VOLTAR);
	}
	
	public static void main(String[] args) 
	{
		MenuOperacoes op;
		List<Seguradora> listaSeguradoras = new ArrayList<>();

		System.out.println("/-------- Sistema de seguros Mirinho SA --------/");

		do 
		{
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op, listaSeguradoras);
		} while(op != MenuOperacoes.SAIR);

		System.out.println("Sistema encerrado");
	}
}