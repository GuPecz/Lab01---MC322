import java.time.LocalDate;
import java.util.ArrayList;

public class Main 
{
	/* Atributos globais */
	private static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private static ArrayList<Frota> listaFrotas = new ArrayList<Frota>();
	private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

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

		Veiculo veiculo = cliente.selecionarVeiculo();
		if (veiculo.equals(null))
		{
			System.out.println("Por favor, primeiro, cadastre um veículo");
			veiculo = instanciarVeiculo();
			listaVeiculos.add(veiculo);
		}

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

    public static Sinistro instanciarSinistro()
    {
        System.out.print("Insira a data do sinistro [dd/mm/aaaa]: ");
		LocalDate dataSinistro = Leitura.leData();

        System.out.print("Insira o endereço do sinistro: ");
        String endereco = Leitura.leString();

		Seguro seguro = selecionarSeguro();

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

	public static Seguradora selecionarSeguradora()
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
	
	public static Cliente selecionarCliente()
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
	
	public static Veiculo selecionarVeiculo()
	{
		Veiculo veiculo;
		
		if (listaVeiculos.isEmpty())
		{
			System.out.println("Por favor cadastre um veículo primeiro");
			veiculo = instanciarVeiculo();
		}
		else
		{
			int opcao;

			System.out.println("Selecione um veículo");
			listarObjetos(listaVeiculos, "Veículo", "o");
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, listaVeiculos));
			veiculo = listaVeiculos.get(opcao);
		}
		
		return veiculo;
	}
	
	public static Frota selecionarFrota()
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
	
	public static Seguro selecionarSeguro()
	{
		Seguro seguro;
		Seguradora seguradora = selecionarSeguradora();
		
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
	
	public static void executarOpcaoMenuExterno(MenuOperacoes op)
	{
		Seguradora seguradora;

		switch(op) 
		{
			case CADASTRAR:

			case LISTAR:

			case EXCLUIR:
			
			case GERAR_SINISTRO:
			
			case SEGURO:
			executarSubmenu(op);
			break;

			case CALCULAR_RECEITA:
				seguradora = selecionarSeguradora();
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

	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu) 
	{
		Veiculo veiculo;
		Frota frota;
		Seguradora seguradora;
		Seguro seguro;
		Condutor condutor;
		ClientePF clientePF;
		ClientePJ clientePJ;
		Sinistro sinistro;
		String opcao;
		int opUsuario;

		switch(opSubmenu) 
		{
			case CADASTRAR_CLIENTE:
				Cliente cliente = instanciarCliente();
				listaClientes.add(cliente);

				if (!listaSeguradoras.isEmpty())
				{
					System.out.println("Deseja registrá-lo em uma seguradora? [s/n]");

					do
					{
						opcao = Leitura.leString();
					} while (!(opcao.equals("s") || opcao.equals("n")));

					if (opcao.equals("s"))
					{
						seguradora = selecionarSeguradora();
						seguradora.cadastrarCliente(cliente);
					}
				}
				break;

			case CADASTRAR_VEICULO:
				veiculo = instanciarVeiculo();
				listaVeiculos.add(veiculo);
				break;

			case CADASTRAR_VEICULO_PF:
				clientePF = (ClientePF)selecionarCliente();		
				veiculo = clientePF.selecionarVeiculo();
				if (veiculo.equals(null))
				{
					System.out.println("Por favor, primeiro, cadastre um veículo");
					veiculo = instanciarVeiculo();
					listaVeiculos.add(veiculo);
				}
				clientePF.cadastrarVeiculo(veiculo);
				break;

			case CADASTRAR_FROTA:
				frota = instanciarFrota();
				listaFrotas.add(frota);

				if (!listaFrotas.isEmpty())
				{
					System.out.println("Deseja registrá-la em um cliente? [s/n]");

					do
					{
						opcao = Leitura.leString();
					} while (!(opcao.equals("s") || opcao.equals("n")));

					if (opcao.equals("s"))
					{
						clientePJ = (ClientePJ)selecionarCliente();
						clientePJ.cadastrarFrota(frota);
					}
				}
				break;

			case CADASTRAR_VEICULO_FROTA:
				veiculo = selecionarVeiculo();
				frota = selecionarFrota();

				System.out.println("1 - Frota de um Cliente PJ\n2 - Frota independente");

				do 
				{
					System.out.println("Digite uma opção: ");
					opUsuario = Leitura.leInt();
				} while(!(opUsuario == 1 || opUsuario == 2));

				if (opUsuario == 1)
				{
					clientePJ = (ClientePJ)selecionarCliente();
					frota = clientePJ.selecionarFrota();
					clientePJ.atualizarFrota(1, frota, veiculo);
				}
				else
				{
					frota = selecionarFrota();
					listaFrotas.add(frota);
					frota.cadastrarVeiculo(veiculo);
				}
				break;

			case CADASTRAR_SEGURADORA:
				System.out.println("Iniciando cadastro de seguradora");
				listaSeguradoras.add(instanciarSeguradora());
				break;

			case LISTAR_SEGUROS_POR_SEGURADORA:
				seguradora = selecionarSeguradora();
				listarObjetos(seguradora.getListaSeguros(), "Seguro", "o");
				break;

			case LISTAR_CLIENTES_POR_SEGURADORA:
				seguradora = selecionarSeguradora();
				seguradora.listarClientesPorSeguradora();
				break;

			case LISTAR_SEGUROS_POR_CLIENTE:
				cliente = selecionarCliente();
				for (Seguradora seg: listaSeguradoras)
					if (seg.getListaClientes().contains(cliente))
						seg.listarSegurosPorCliente(cliente);
				break;

			case LISTAR_CONDUTOR_POR_SEGURO:
				seguro = selecionarSeguro();
				listarObjetos(seguro.getListaCondutores(), "Condutore", "o");
				break;

			case LISTAR_SINISTROS_POR_SEGURO:
				seguro = selecionarSeguro();
				listarObjetos(seguro.getListaSinistros(), "Sinistro", "o");
				break;

			case LISTAR_SINISTROS_POR_CONDUTOR:
				seguro = selecionarSeguro();
				condutor = selecionarCondutor(seguro);
				listarObjetos(condutor.getListaSinistros(), "Sinistro", "o");
				break;

			case LISTAR_VEICULOS_POR_PF:
				clientePF = (ClientePF)selecionarCliente();
				System.out.println(clientePF.listarVeiculosPorCliente());
				break;

			case LISTAR_FROTAS_POR_PJ:
				clientePJ = (ClientePJ)selecionarCliente();
				System.out.println(clientePJ.listarFrotas());
				break;

			case LISTAR_VEICULOS_POR_FROTA:
				frota = selecionarFrota();
				System.out.println(frota.imprimirVeiculos());
				break;

			case EXCLUIR_CLIENTE:
				System.out.println("Selecione o tipo de cliente [f/j]");

				do
				{
					opcao = Leitura.leString();
				} while (!(opcao.equals("f") || opcao.equals("j")));
				
				if (opcao.equals("f"))
				{
					clientePF = (ClientePF)selecionarCliente();
					listaClientes.remove(clientePF);
					for (Seguradora seg: listaSeguradoras)
						if (seg.getListaClientes().contains(clientePF))
						{
							seg.excluirCliente(clientePF.getCpf());
							break;
						}
				}
				else
				{
					clientePJ = (ClientePJ)selecionarCliente();
					listaClientes.remove(clientePJ);
					for (Seguradora seg: listaSeguradoras)
						if (seg.getListaClientes().contains(clientePJ))
						{
							seg.excluirCliente(clientePJ.getCnpj());
							break;
						}
				}
				break;

			case EXCLUIR_VEICULO_PF:
				clientePF = (ClientePF)selecionarCliente();
				veiculo = clientePF.selecionarVeiculo();
				if (veiculo.equals(null))
				{
					System.out.println("Por favor, primeiro, cadastre um veículo");
					veiculo = instanciarVeiculo();
					listaVeiculos.add(veiculo);
				}
				clientePF.removerVeiculo(veiculo.getPlaca());
				break;

			case EXCLUIR_VEICULO_FROTA:
				frota = selecionarFrota();
				veiculo = frota.selecionarVeiculo();
				if (veiculo.equals(null))
					System.out.println("ERRO: Não há veículos cadastrados nesta frota");
				else
				{

					System.out.println("1 - Frota de um Cliente PJ\n2 - Frota independente");

					do 
					{
						System.out.println("Digite uma opção: ");
						opUsuario = Leitura.leInt();
					} while(!(opUsuario == 1 || opUsuario == 2));

					if (opUsuario == 1)
					{
						clientePJ = (ClientePJ)selecionarCliente();
						frota = clientePJ.selecionarFrota();
						clientePJ.atualizarFrota(2, frota, veiculo);
					}
					else
					{
						frota = selecionarFrota();
						listaFrotas.add(frota);
						frota.removerVeiculo(veiculo);
					}
				}
				break;

			case EXCLUIR_FROTA:		
				System.out.println("1 - Frota de um Cliente PJ\n2 - Frota independente");

				do 
				{
					System.out.println("Digite uma opção: ");
					opUsuario = Leitura.leInt();
				} while(!(opUsuario == 1 || opUsuario == 2));

				if (opUsuario == 1)
				{
					clientePJ = (ClientePJ)selecionarCliente();
					frota = clientePJ.selecionarFrota();
					clientePJ.atualizarFrota(3, frota, null);
				}
				else
				{
					frota = selecionarFrota();
					listaFrotas.remove(frota);
				}
				break;

			case GERAR_SINISTRO_POR_CLIENTE:
				seguradora = selecionarSeguradora();
				System.out.println("Selecione o tipo de cliente [f/j]");

				do
				{
					opcao = Leitura.leString();
				} while (!(opcao.equals("f") || opcao.equals("j")));
				
				ArrayList<Seguro> segurosCliente;
				if (opcao.equals("f"))
				{
					clientePF = (ClientePF)selecionarCliente();
					segurosCliente = seguradora.getSegurosPorCliente(clientePF.getCpf());
				}
				else
				{
					clientePJ = (ClientePJ)selecionarCliente();
					segurosCliente = seguradora.getSegurosPorCliente(clientePJ.getCnpj());
				}
				
				listarObjetos(segurosCliente, "Seguro", "o");
				System.out.println("Digite uma opção:");
				do
				{
					opUsuario = Leitura.leInt() - 1;
				} while (!Validacao.validarIndice(opUsuario, segurosCliente));
				seguro = seguradora.getListaSeguros().get(opUsuario);
				seguro.gerarSinistro(instanciarSinistro());
				break;

			case GERAR_SINISTRO_POR_CONDUTOR:
				sinistro = instanciarSinistro();
				seguro = selecionarSeguro();
				selecionarCondutor(seguro).adicionarSinistro(sinistro);
				break;

			case GERAR_SEGURO:
				seguradora = selecionarSeguradora();
				seguro = instanciarSeguro(seguradora);
				seguradora.gerarSeguro(seguro);
				break;

			case CANCELAR_SEGURO:
				seguradora = selecionarSeguradora();
				seguro = selecionarSeguro();
				seguradora.cancelarSeguro(seguro);
				break;

			case AUTORIZAR_CONDUTOR:
				seguro = selecionarSeguro();
				condutor = selecionarCondutor(seguro);
				seguro.autorizarCondutor(condutor);
				break;

			case DESAUTORIZAR_CONDUTOR:
				seguro = selecionarSeguro();
				condutor = selecionarCondutor(seguro);
				seguro.desautorizarCondutor(condutor);
				break;

			case VOLTAR:
			break;
		}
	}
	
	public static void executarSubmenu(MenuOperacoes op) 
	{
		SubmenuOperacoes opSubmenu;

		do 
		{
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		} while(opSubmenu != SubmenuOperacoes.VOLTAR);
	}

	public static void main(String[] args) 
	{
		MenuOperacoes op;

		System.out.println("/-------- Sistema de seguros Mirinho SA --------/");

		do 
		{
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		} while(op != MenuOperacoes.SAIR);

		System.out.println("Sistema encerrado");
	}
}