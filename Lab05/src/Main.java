import java.time.LocalDate;
import java.util.ArrayList;

public class Main 
{
	/* Métodos de instanciação de objetos */

	public static Seguradora instanciarSeguradora()
	{
		System.out.println("Iniciando cadastro da seguradora");

		System.out.print("Insira o CNPJ da seguradora: ");
		String cnpj;
		boolean cnpjValido;
		
		do
		{
			cnpj = Leitura.leString();
			cnpjValido = Validacao.validarCNPJ(cnpj);
			if (!cnpjValido)
				System.out.println("ERRO: CNPJ inválido\nTente novamente");
		} while (!cnpjValido);

		System.out.print("Inisira o nome da seguradora: ");
		String nome = Leitura.lePalavra();

		System.out.print("Insira o telefone da seguradora: ");
		String telefone = Leitura.leString();

		System.out.print("Insira o endereço da seguradora: ");
		String endereco = Leitura.leString();

		System.out.print("Insira o e-mail da seguradora: ");
		String email = Leitura.leString();

		return new Seguradora(cnpj, nome, telefone, endereco, email, new ArrayList<Cliente>(), new ArrayList<Seguro>());
	}

	public static void iniciarCliente(Cliente cliente)
    {
        System.out.print("Insira o nome do cliente: ");
        String nome = Leitura.lePalavra();
        cliente.setNome(nome);

		System.out.print("Insira o telefone do cliente: ");
		String telefone = Leitura.leString();
		cliente.setTelefone(telefone);

		System.out.print("Insira o endereço do cliente: ");
		String endereco = Leitura.leString();
		cliente.setEndereco(endereco);

		System.out.print("Insira o e-mail do cliente: ");
		String email = Leitura.leString();
		cliente.setEmail(email);
    }

    public static ClientePF instanciarPF()
    {
        System.out.print("Insira o CPF do cliente: ");
        String cpf;
        boolean cpfValido;
        
		do
		{
			cpf = Leitura.leString();
			cpfValido = Validacao.validarCPF(cpf);
			if (!cpfValido)
				System.out.println("ERRO: CPF inválido\nTente novamente");
		} while (!cpfValido);
        
        ClientePF cliente = new ClientePF(null, null, null, null, cpf, null, null, null, new ArrayList<Veiculo>());
        
        iniciarCliente(cliente);
        
        System.out.print("Insira o gênero do cliente: ");
        String genero = Leitura.lePalavra();
        cliente.setGenero(genero);

        System.out.print("Insira o grau de escolaridade do cliente: ");
        String educacao = Leitura.leString();
        cliente.setEducacao(educacao);

        System.out.print("Insira a data de nascimento do cliente [dd/mm/aaaa]: ");
		LocalDate dataNascimento = Leitura.leData();
        cliente.setDataNascimento(dataNascimento);
        
        return cliente;
    }

    public static ClientePJ instanciarPJ()
    {
        System.out.print("Insira o CNPJ do cliente: ");
		String cnpj;
        boolean cnpjValido;
        
		do
		{
			cnpj = Leitura.leString();
			cnpjValido = Validacao.validarCNPJ(cnpj);
			if (!cnpjValido)
				System.out.println("ERRO: CNPJ inválido\nTente novamente");
		} while (!cnpjValido);

        ClientePJ cliente = new ClientePJ(null, null, null, null, cnpj, null, new ArrayList<Frota>());

        iniciarCliente(cliente);

        System.out.print("Insira a data de fundação do cliente [dd/mm/aaaa]: ");
		LocalDate dataFundacao = Leitura.leData();
        cliente.setDataFundacao(dataFundacao);

        return cliente;
    }

	public static Cliente instanciarCliente()
	{
		String tipoCliente;

		System.out.println("Iniciando cadastro de cliente");
		System.out.println("Pessoa física ou jurídica? [f/j]");

		do
		{
			tipoCliente = Leitura.leString();
		} while (!(tipoCliente.equals("f") || tipoCliente.equals("j")));
		
		if (tipoCliente.equals("f"))
			return instanciarPF();
		else
			return instanciarPJ();
	}

    public static Veiculo instanciarVeiculo()
    {
        System.out.print("Insira a placa do veículo: ");
        String placa = Leitura.leString();
        
        System.out.print("Insira a marca do veículo: ");
        String marca = Leitura.leString();

        System.out.print("Insira o modelo do veículo: ");
        String modelo = Leitura.leString();

        System.out.print("Insira o ano de fabricação do veículo: ");
        int anoFabricacao = Leitura.leInt();

        return new Veiculo(placa, modelo, marca, anoFabricacao);
    }
	
	public static Frota instanciarFrota()
	{
		System.out.println("Frota cadastrada");

		return new Frota(new ArrayList<Veiculo>());
	}
	
	public static Condutor instanciarCondutor()
	{
		System.out.print("Insira o CPF do cliente: ");
        String cpf;
        boolean cpfValido;
        
		do
		{
			cpf = Leitura.leString();
			cpfValido = Validacao.validarCPF(cpf);
			if (!cpfValido)
				System.out.println("ERRO: CPF inválido\nTente novamente");
		} while (!cpfValido);
		
		System.out.print("Insira o nome do cliente: ");
        String nome = Leitura.lePalavra();

		System.out.print("Insira o telefone do cliente: ");
		String telefone = Leitura.leString();
		
		System.out.print("Insira o endereço do cliente: ");
		String endereco = Leitura.leString();
		
		System.out.print("Insira o e-mail do cliente: ");
		String email = Leitura.leString();

		System.out.print("Insira a data de nascimento do cliente [dd/mm/aaaa]: ");
		LocalDate dataNascimento = Leitura.leData();

		return new Condutor(cpf, nome, telefone, endereco, email, dataNascimento, new ArrayList<Sinistro>());
	}
	
	public static SeguroPF instanciarSeguroPF(Seguradora seguradora)
	{
		ClientePF cliente = (ClientePF)seguradora.selecionarCliente();

		if (cliente.equals(null))
			cliente = (ClientePF)instanciarCliente();

		Veiculo veiculo = selecionarVeiculo(cliente);

		SeguroPF seguro = new SeguroPF(LocalDate.now(), LocalDate.now().plusMonths(6), seguradora, new ArrayList<Sinistro>(), new ArrayList<Condutor>(), veiculo, cliente);

		return seguro;
	}

	public static SeguroPJ instanciarSeguroPJ(Seguradora seguradora)
	{
		ClientePJ cliente = (ClientePJ)seguradora.selecionarCliente();

		if (cliente.equals(null))
			cliente = (ClientePJ)instanciarCliente();

		Frota frota = cliente.selecionarFrota();

		SeguroPJ seguro = new SeguroPJ(LocalDate.now(), LocalDate.now().plusMonths(6), seguradora, new ArrayList<Sinistro>(), new ArrayList<Condutor>(), frota, cliente);

		return seguro;
	}

	public static Seguro instanciarSeguro(Seguradora seguradora)
	{
		String tipoSeguro;

		System.out.println("Iniciando cadastro do seguro");
		System.out.println("O cliente é uma pessoa física ou jurídica? [f/j]");

		do
		{
			tipoSeguro = Leitura.leString();
		} while (!(tipoSeguro.equals("f") || tipoSeguro.equals("j")));
		
		if (tipoSeguro.equals("f"))
			return instanciarSeguroPF(seguradora);
		else
			return instanciarSeguroPJ(seguradora);
	}

    public static Sinistro instanciarSinistro(ArrayList<Seguradora> listaSeguradoras)
    {
        System.out.print("Insira a data do sinistro [dd/mm/aaaa]: ");
		LocalDate dataSinistro = Leitura.leData();

        System.out.print("Insira o endereço do sinistro: ");
        String endereco = Leitura.leString();

		Seguro seguro = selecionarSeguro(listaSeguradoras);

		Condutor condutor = selecionarCondutor(seguro);

        return new Sinistro(dataSinistro, endereco, condutor, seguro);
    }

	/* Método de listagem de objetos */

	public static void listarObjetos(ArrayList<?> listaObjetos, String objeto, String genero)
	{
		int tam = listaObjetos.size();
		
		System.out.printf("%ss cadastrad%ss:\n", objeto, genero);
		
		for (int i = 0; i < tam; i++)
			System.out.printf("%s %d\n%s", objeto, i, objeto.toString());
	}

	/* Métodos de seleção de objetos */

	public static Seguradora selecionarSeguradora(ArrayList<Seguradora> listaSeguradoras)
	{
		Seguradora seguradora;
		
		if (listaSeguradoras.isEmpty())
		{
			System.out.println("Por favor, cadastre uma seguradora primeiro");
			seguradora = instanciarSeguradora();
			listaSeguradoras.add(seguradora);
		}
		else
		{
			listarObjetos(listaSeguradoras, "Seguradora", "a");
			System.out.println("Selecione uma seguradora");
			int opcao;
			do
			{
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, listaSeguradoras));
			seguradora = listaSeguradoras.get(opcao);
		}

		return seguradora;
	}
	
	public static Cliente selecionarCliente(ArrayList<Cliente> listaClientes)
	{
		Cliente cliente;
		
		if (listaClientes.isEmpty())
		{
			System.out.println("Por favor, cadastre um cliente primeiro");
			cliente = instanciarCliente();
			listaClientes.add(cliente);
		}
		else
		{
			int opcao;
			
			System.out.println("Selecione um cliente");
			listarObjetos(listaClientes, "Cliente", "o");
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, listaClientes));
			cliente = listaClientes.get(opcao);
		}

		return cliente;
	}
	
	public static Veiculo selecionarVeiculo(ClientePF cliente)
	{
		Veiculo veiculo;
		
		if (cliente.getListaVeiculos().isEmpty())
		{
			System.out.println("Por favor cadastre um veículo primeiro");
			veiculo = instanciarVeiculo();
		}
		else
		{
			int opcao;

			System.out.println("Selecione um veículo");
			System.out.println(cliente.listarVeiculosPorCliente());
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, cliente.getListaVeiculos()));
			veiculo = cliente.getListaVeiculos().get(opcao);
		}
		
		return veiculo;
	}
	
	public static Frota selecionarFrota(ArrayList<Frota> listaFrotas)
	{
		Frota frota;
		
		if (listaFrotas.isEmpty())
		{	
			System.out.println("Por favor, primeiro cadastre uma frota");
			frota = instanciarFrota();
		}
		else
		{
			int opcao;
			
			System.out.println("Selecione uma frota");
			listarObjetos(listaFrotas, "Frota", "a");
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, listaFrotas));
			frota = listaFrotas.get(opcao);
		}
		
		return frota;
	}
	
	public static Seguro selecionarSeguro(ArrayList<Seguradora> listaSeguradoras)
	{
		Seguro seguro;
		Seguradora seguradora = selecionarSeguradora(listaSeguradoras);
		
		if (seguradora.getListaSeguros().isEmpty())
		{
			System.out.println("Por favor, primeiro cadastre um seguro");
			seguro = instanciarSeguro(seguradora);
		}
		else
		{
			int opcao;
			
			System.out.println("Selecione um seguro");
			listarObjetos(seguradora.getListaSeguros(), "Seguro", "o");
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, seguradora.getListaSeguros()));
			seguro = seguradora.getListaSeguros().get(opcao);
		}
		
		return seguro;
	}
	
	private static Condutor selecionarCondutor(Seguro seguro) 
	{
		Condutor condutor;

		if (seguro.getListaCondutores().isEmpty())
		{
			System.out.println("Por favor, primeiro cadastre um condutor");
			condutor = instanciarCondutor();
			seguro.autorizarCondutor(condutor);
		}
		else
		{
			int opcao;
			
			System.out.println("Selecione um condutor");
			listarObjetos(seguro.getListaCondutores(), "Condutore", "o");
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, seguro.getListaCondutores()));
			condutor = seguro.getListaCondutores().get(opcao);
		}

		return condutor;
	}

	/* Métodos do menu de operações */

	public static void exibirMenuExterno() 
	{
		MenuOperacoes menuOperacoes[] = MenuOperacoes.values();

		System.out.println("Menu principal");
		for(MenuOperacoes op: menuOperacoes)
			System.out.println((op.ordinal() + 1) + " - " + op.getDescricao());
	}

	public static void exibirSubmenu(MenuOperacoes op) 
	{
		SubmenuOperacoes[] submenu = op.getSubmenu();

		System.out.println(op.getDescricao());
		for(int i = 0; i < submenu.length; i++)
			System.out.println((i + 1) + " - " + submenu[i].getDescricao());
	}
	
	public static MenuOperacoes lerOpcaoMenuExterno() 
	{
		int opUsuario;
		MenuOperacoes opUsuarioConst;

		do 
		{
			System.out.println("Digite uma opção: ");
			opUsuario = Leitura.leInt() - 1;
		} while(opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);

		opUsuarioConst = MenuOperacoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	public static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) 
	{
		int opUsuario;
		SubmenuOperacoes opUsuarioConst;

		do 
		{
			System.out.println("Digite uma opção: ");
			opUsuario = Leitura.leInt() - 1;
		} while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);

		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	public static void executarOpcaoMenuExterno(MenuOperacoes op, ArrayList<Seguradora> listaSeguradoras, ArrayList<Cliente> listaClientes, ArrayList<Veiculo> listaVeiculos, ArrayList<Frota> listaFrotas) 
	{
		Seguradora seguradora;

		switch(op) 
		{
			case CADASTRAR:

			case LISTAR:

			case EXCLUIR:
			
			case GERAR_SINISTRO:
			
			case SEGURO:
			executarSubmenu(op, listaSeguradoras, listaClientes, listaVeiculos, listaFrotas);
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

	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu, ArrayList<Seguradora> listaSeguradoras, ArrayList<Cliente> listaClientes, ArrayList<Veiculo> listaVeiculos, ArrayList<Frota> listaFrotas) 
	{
		Veiculo veiculo;
		Frota frota;
		Seguradora seguradora;
		Seguro seguro;

		switch(opSubmenu) 
		{
			case CADASTRAR_CLIENTE:
				Cliente cliente = instanciarCliente();
				listaClientes.add(cliente);

				if (!listaSeguradoras.isEmpty())
				{
					System.out.println("Deseja registrá-lo em uma seguradora? [s/n]");
					String opcao;

					do
					{
						opcao = Leitura.leString();
					} while (!(opcao.equals("s") || opcao.equals("n")));

					if (opcao.equals("s"))
					{
						seguradora = selecionarSeguradora(listaSeguradoras);
						seguradora.cadastrarCliente(cliente);
					}
				}
				break;

			case CADASTRAR_VEICULO_PF:
				veiculo = instanciarVeiculo();
				listaVeiculos.add(veiculo);

				if (!listaClientes.isEmpty())
				{
					System.out.println("Deseja registrá-lo em um cliente? [s/n]");
					String opcao;

					do
					{
						opcao = Leitura.leString();
					} while (!(opcao.equals("s") || opcao.equals("n")));

					if (opcao.equals("s"))
					{
						ClientePF clientePF = (ClientePF)selecionarCliente(listaClientes);
						clientePF.cadastrarVeiculo(veiculo);
					}
				}
				break;

			case CADASTRAR_FROTA:
				frota = instanciarFrota();
				listaFrotas.add(frota);

				if (!listaFrotas.isEmpty())
				{
					System.out.println("Deseja registrá-la em um cliente? [s/n]");
					String opcao;

					do
					{
						opcao = Leitura.leString();
					} while (!(opcao.equals("s") || opcao.equals("n")));

					if (opcao.equals("s"))
					{
						ClientePJ clientePJ = (ClientePJ)selecionarCliente(listaClientes);
						clientePJ.cadastrarFrota(frota);
					}
				}
				break;

			case CADASTRAR_VEICULO_FROTA:
				veiculo = instanciarVeiculo();
				listaVeiculos.add(veiculo);

				if (!listaFrotas.isEmpty())
				{
					System.out.println("Deseja registrá-lo em uma frota? [s/n]");
					String opcao;

					do
					{
						opcao = Leitura.leString();
					} while (!(opcao.equals("s") || opcao.equals("n")));

					if (opcao.equals("s"))
					{
						System.out.println("1 - Frota de um Cliente PJ\n2 - Frota independente");
						int opUsuario;

						do 
						{
							System.out.println("Digite uma opção: ");
							opUsuario = Leitura.leInt();
						} while(!(opUsuario == 1 || opUsuario == 2));

						if (opUsuario == 1)
						{
							ClientePJ clientePJ = (ClientePJ)selecionarCliente(listaClientes);
							frota = clientePJ.selecionarFrota();
							frota.cadastrarVeiculo(veiculo);
						}
						else
						{
							frota = selecionarFrota(listaFrotas);
							listaFrotas.add(frota);
						}
					}
				}
				break;

			case CADASTRAR_SEGURADORA:
				System.out.println("Iniciando cadastro de seguradora");
				listaSeguradoras.add(instanciarSeguradora());
				break;

			case LISTAR_SEGUROS_POR_SEGURADORA:
				seguradora = selecionarSeguradora(listaSeguradoras);
				listarObjetos(seguradora.getListaSeguros(), "Seguro", "o");
				break;

			case LISTAR_CLIENTES_POR_SEGURADORA:
				seguradora = selecionarSeguradora(listaSeguradoras);
				seguradora.listarClientesPorSeguradora();
				break;

			case LISTAR_SEGUROS_POR_CLIENTE:
				cliente = selecionarCliente(listaClientes);
				for (Seguradora seg: listaSeguradoras)
					if (seg.getListaClientes().contains(cliente))
						seg.listarSegurosPorCliente(cliente);
				break;

			case LISTAR_CONDUTOR_POR_SEGURO:
				seguro = selecionarSeguro(listaSeguradoras);
				break;

			case LISTAR_SINISTROS_POR_SEGURO:
				// Stub
				break;

			case LISTAR_SINISTROS_POR_CONDUTOR:
				// Stub
				break;

			case LISTAR_VEICULOS_POR_PF:
				// Stub
				break;

			case LISTAR_FROTAS_POR_PJ:
				// Stub
				break;

			case LISTAR_VEICULOS_POR_FROTA:
				// Stub
				break;

			case EXCLUIR_CLIENTE:
			/*  Implementação legada
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira o documento do cliente: ");
				String documento2 = Leitura.leString();
				seguradora.listarSinistrosPorCliente(documento2);
			*/
				break;

			case EXCLUIR_VEICULO_PF:
				// Stub
				break;

			case EXCLUIR_VEICULO_FROTA:
				// Stub
				break;

			case EXCLUIR_FROTA:
				// Stub
				break;

			case GERAR_SINISTRO_POR_CLIENTE:
				// Stub
				break;

			case GERAR_SINISTRO_POR_CONDUTOR:
				// Stub
				break;

			case GERAR_SEGURO:
				// Stub
				break;

			case CANCELAR_SEGURO:
				// Stub
				break;

			case AUTORIZAR_CONDUTOR:
				// Stub
				break;

			case DESAUTORIZAR_CONDUTOR:
				// Stub
				break;

			case VOLTAR:
			break;
		}
	}
	
	public static void executarSubmenu(MenuOperacoes op, ArrayList<Seguradora> listaSeguradoras, ArrayList<Cliente> listaClientes, ArrayList<Veiculo> listaVeiculos, ArrayList<Frota> listaFrotas) 
	{
		SubmenuOperacoes opSubmenu;

		do 
		{
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu, listaSeguradoras, listaClientes, listaVeiculos, listaFrotas);
		} while(opSubmenu != SubmenuOperacoes.VOLTAR);
	}

	public static void main(String[] args) 
	{
		MenuOperacoes op;
		ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Frota> listaFrotas = new ArrayList<Frota>();
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

		System.out.println("/-------- Sistema de seguros Mirinho SA --------/");

		do 
		{
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op, listaSeguradoras, listaClientes, listaVeiculos, listaFrotas);
		} while(op != MenuOperacoes.SAIR);

		System.out.println("Sistema encerrado");
	}
}