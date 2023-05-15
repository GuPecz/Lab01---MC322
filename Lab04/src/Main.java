import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
	public static Seguradora instanciarSeguradora(Scanner input)
	{
		System.out.println("Inisira seu nome: ");
		String nome = input.nextLine();

		System.out.println("Insira seu telefone: ");
		String telefone = input.nextLine();

		System.out.println("Insira seu e-mail: ");
		String email = input.nextLine();

		System.out.println("Insira seu endereço: ");
		String endereco = input.nextLine();

		return new Seguradora(nome, telefone, email, endereco, new ArrayList<Sinistro>(), new ArrayList<Cliente>());
	}

	public static void listarSeguradoras(List<Seguradora> listaSeguradoras)
	{
		int tam = listaSeguradoras.size();

		System.out.println("Seguradoras cadastradas: ");

		for (int i = 0; i < tam - 1; i++)
			System.out.println((i + 1) + " - " + listaSeguradoras.get(i).getNome());
	}

	public static void IniciarCliente(Cliente cliente, Scanner input)
    {
        System.out.println("Insira seu nome: ");
        String nome = input.nextLine();
        cliente.setNome(nome);

        System.out.println("Insira seu endereço: ");
        String endereco = input.nextLine();
        cliente.setEndereco(endereco);

        List<Veiculo> listaVeiculos = new ArrayList<>();
        cliente.setListaVeiculos(listaVeiculos);
    }

    public static LocalDate converteString(String data)
    {
        data = data.replaceAll("\\D", "");
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(2, 4));
        int ano = Integer.parseInt(data.substring(4, 8));

        return LocalDate.of(ano, mes, dia);
    }

    public static ClientePF instanciarPF(Scanner input)
    {
        System.out.println("Insira seu CPF: ");
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
        
        System.out.println("Insira seu gênero: ");
        String genero = input.nextLine();
        cliente.setGenero(genero);

        LocalDate dataLicenca = LocalDate.now();
        cliente.setDataLicenca(dataLicenca);

        System.out.println("Insira seu grau de escolaridade: ");
        String educacao = input.nextLine();
        cliente.setEducacao(educacao);

        System.out.println("Insira sua classe econômica: ");
        String classeEconomica = input.nextLine();
        cliente.setClasseEconomica(classeEconomica);

        System.out.println("Insira sua data de nascimento [dd/mm/aaaa]: ");
        String data = input.nextLine();
        LocalDate dataNascimento = converteString(data);
        cliente.setDataNascimento(dataNascimento);
        
        return cliente;
    }

    public static ClientePJ instanciarPJ(Scanner input)
    {
        System.out.println("Insira seu CNPJ: ");
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

        System.out.println("Insira sua data de fundação [dd/mm/aaaa]: ");
        String data = input.nextLine();
        LocalDate dataFundacao = converteString(data);
        cliente.setDataFundacao(dataFundacao);

		System.out.println("Insira sua quantidade de funcionários: ");
		int qtdeFuncionarios = input.nextInt();
		cliente.setQtdeFuncionarios(qtdeFuncionarios);
		input.nextLine();

        return cliente;
    }

    public static Veiculo instanciarVeiculo(Scanner input)
    {
        System.out.println("Insira a placa: ");
        String placa = input.nextLine();
        
        System.out.println("Insira o modelo: ");
        String modelo = input.nextLine();

        System.out.println("Insira a marca: ");
        String marca = input.nextLine();

        System.out.println("Insira o ano de fabricação: ");
        int anoFabricacao = input.nextInt();
        input.nextLine();

        return new Veiculo(placa, modelo, marca, anoFabricacao);
    }

    public static Sinistro instanciarSinistro(Scanner input, Seguradora seguradora, Veiculo veiculo, Cliente cliente)
    {
        System.out.println("Insira a data [dd/mm/aaaa]: ");
        String data = input.nextLine();
		LocalDate dataSinistro = converteString(data);

        System.out.println("Insira o endereço: ");
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
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOperacoes opUsuarioConst;

		do 
		{
			System.out.println("Digite uma opção: ");
			opUsuario = scanner.nextInt();
		} while(opUsuario <= 0 || opUsuario > MenuOperacoes.values().length);

		opUsuarioConst = MenuOperacoes.values()[opUsuario - 1];
		return opUsuarioConst;
	}
	
	private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) 
	{
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOperacoes opUsuarioConst;

		do 
		{
			System.out.println("Digite uma opção: ");
			opUsuario = scanner.nextInt();
		} while(opUsuario <= 0 || opUsuario > op.getSubmenu().length);

		opUsuarioConst = op.getSubmenu()[opUsuario - 1];
		return opUsuarioConst;
	}
	
	private static void executarOpcaoMenuExterno(MenuOperacoes op, List<Seguradora> listaSeguradoras) 
	{
		switch(op) 
		{
			case CADASTRAR:

			case LISTAR:

			case EXCLUIR:
				executarSubmenu(op, listaSeguradoras);
				break;

			case GERAR_SINISTRO:
				System.out.println("Executar metodo gerar Sinistro");
				break;

			case TRANSFERIR_SEGURO:
				System.out.println("Executar metodo tranferir seguro");
				break;

			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita");
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
			seguradora = listaSeguradoras.get(input.nextInt());
			input.nextLine();
		}

		return seguradora;
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
		Cliente cliente;
		String tipoCliente;

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

		System.out.println("Iniciando cadastro de veículo");
		cliente.getListaVeiculos().add(instanciarVeiculo(input));
	}

	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu, List<Seguradora> listaSeguradoras) 
	{
		Scanner input = new Scanner(System.in);
		Seguradora seguradora = selecionarSeguradora(listaSeguradoras);

		switch(opSubmenu) 
		{
		case CADASTRAR_CLIENTE:
			seguradora.getListaClientes().add(cadastrarCliente());
			break;

		case CADASTRAR_VEICULO:
			cadastrarVeiculo(seguradora);
			break;

		case CADASTRAR_SEGURADORA:
			System.out.println("Iniciando cadastro de seguradora");
			listaSeguradoras.add(instanciarSeguradora(input));
			break;

		case LISTAR_CLIENTES_POR_SEGURADORA:
			seguradora.listarClientesPorSeguradora();
			break;

		case LISTAR_SINISTROS_POR_SEGURADORA:
			seguradora.listarSinistrosPorSeguradora();
			break;

		case LISTAR_SINISTROS_POR_CLIENTE:
			break;

		case LISTAR_VEICULOS_POR_SEGURADORA:
			seguradora.listarVeiculosPorSeguradora();
			break;

		case LISTAR_VEICULOS_POR_CLIENTE:
			seguradora.listarClientesPorSeguradora();
			int opcao = input.nextInt();
			input.nextLine();
			seguradora.getListaClientes().get(opcao).listarVeiculosPorCliente();
			break;

		case EXCLUIR_CLIENTE:
			System.out.println("Chamar metodo excluir cliente");
			break;

		case EXCLUIR_VEICULO:
			System.out.println("Chamar metodo excluir veiculo");
			break;

		case EXCLUIR_SINISTRO:
			System.out.println("Chamar metodo excluir sinistro");
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

		System.out.println("Saiu do sistema");
	}
}