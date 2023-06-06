import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main 
{
	public static Seguradora instanciarSeguradora()
	{
		System.out.print("Inisira o nome da seguradora: ");
		String nome = Leitura.lePalavra();

		System.out.print("Insira o telefone da seguradora: ");
		String telefone = Leitura.leString();

		System.out.print("Insira o e-mail da seguradora: ");
		String email = Leitura.leString();

		System.out.print("Insira o endereço da seguradora: ");
		String endereco = Leitura.leString();

		return new Seguradora(nome, telefone, email, endereco, new ArrayList<Sinistro>(), new ArrayList<Cliente>());
	}

	public static void listarSeguradoras(List<Seguradora> listaSeguradoras)
	{
		int tam = listaSeguradoras.size();

		System.out.println("Seguradoras cadastradas: ");

		for (int i = 0; i < tam; i++)
			System.out.println((i + 1) + " - " + listaSeguradoras.get(i).getNome());
	}

	public static void IniciarCliente(Cliente cliente)
    {
        System.out.print("Insira o nome do cliente: ");
        String nome = Leitura.lePalavra();
        cliente.setNome(nome);

        System.out.print("Insira o endereço do cliente: ");
        String endereco = Leitura.leString();
        cliente.setEndereco(endereco);

        List<Veiculo> listaVeiculos = new ArrayList<>();
        cliente.setListaVeiculos(listaVeiculos);
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
        
        ClientePF cliente = new ClientePF(null, null, null, 0.0, cpf, null, null, null, null, null);
        
        IniciarCliente(cliente);
        
        System.out.print("Insira o gênero do cliente: ");
        String genero = Leitura.lePalavra();
        cliente.setGenero(genero);

        LocalDate dataLicenca = LocalDate.now();
        cliente.setDataLicenca(dataLicenca);

        System.out.print("Insira o grau de escolaridade do cliente: ");
        String educacao = Leitura.leString();
        cliente.setEducacao(educacao);

        System.out.print("Insira a classe econômica do cliente: ");
        String classeEconomica = Leitura.lePalavra();
        cliente.setClasseEconomica(classeEconomica);

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

        ClientePJ cliente = new ClientePJ(null, null, null, 0.0, cnpj, null, 0);

        IniciarCliente(cliente);

        System.out.print("Insira a data de fundação do cliente [dd/mm/aaaa]: ");
		LocalDate dataFundacao = Leitura.leData();
        cliente.setDataFundacao(dataFundacao);

		System.out.print("Insira a quantidade de funcionários do cliente: ");
		int qtdeFuncionarios;
		do
		{
			qtdeFuncionarios = Leitura.leInt();
		} while (qtdeFuncionarios < 0);
		cliente.setQtdeFuncionarios(qtdeFuncionarios);

        return cliente;
    }

    public static Veiculo instanciarVeiculo()
    {
        System.out.print("Insira a placa do veículo: ");
        String placa = Leitura.leString();
        
        System.out.print("Insira o modelo do veículo: ");
        String modelo = Leitura.leString();

        System.out.print("Insira a marca do veículo: ");
        String marca = Leitura.leString();

        System.out.print("Insira o ano de fabricação do veículo: ");
        int anoFabricacao = Leitura.leInt();

        return new Veiculo(placa, modelo, marca, anoFabricacao);
    }

    public static Sinistro instanciarSinistro(Seguradora seguradora, Veiculo veiculo, Cliente cliente)
    {
        System.out.print("Insira a data do sinistro [dd/mm/aaaa]: ");
		LocalDate dataSinistro = Leitura.leData();

        System.out.print("Insira o endereço do sinistro: ");
        String endereco = Leitura.leString();

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
	
	private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) 
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
	
	private static void executarOpcaoMenuExterno(MenuOperacoes op, List<Seguradora> listaSeguradoras) 
	{
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
				seguradora.gerarSinistro(instanciarSinistro(seguradora, veiculo, cliente));
				cliente.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente));
				break;

			case TRANSFERIR_SEGURO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				if (seguradora.getListaClientes().size() < 2)
					System.out.println("ERRO: Não há clientes suficientes para uma transferência");
				else
				{
					System.out.println("Quem vai transferir?");
					Cliente transferente = selecionarCliente(seguradora);

					System.out.println("Quem vai receber?");
					Cliente recebedor;
					boolean mesmoCliente = false;
					do
					{
						recebedor = selecionarCliente(seguradora);
						if (recebedor.equals(transferente))
						{
							System.out.println("ERRO: Seguro sendo transferido para o mesmo cliente");
							mesmoCliente = true;
						}
						else
							mesmoCliente = false;
					} while (mesmoCliente);

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

		if (listaSeguradoras.isEmpty())
		{
			System.out.println("Por favor, cadastre uma seguradora primeiro");
			seguradora = instanciarSeguradora();
			listaSeguradoras.add(seguradora);
		}
		else
		{
			listarSeguradoras(listaSeguradoras);
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

	public static Cliente selecionarCliente(Seguradora seguradora)
	{
		Cliente cliente;

		if (seguradora.getListaClientes().isEmpty())
		{
			System.out.println("Por favor, cadastre um cliente primeiro");
			cliente = cadastrarCliente();
			seguradora.getListaClientes().add(cliente);
		}
		else
		{
			int opcao;

			System.out.println("Selecione um cliente: ");
			seguradora.listarClientesPorSeguradora();
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, seguradora.getListaClientes()));
			cliente = seguradora.getListaClientes().get(opcao);
		}

		return cliente;
	}

	public static Veiculo selecionarVeiculo(Cliente cliente)
	{
		Veiculo veiculo;

		System.out.println(cliente.listarVeiculosPorCliente());

		if (cliente.getListaVeiculos().isEmpty())
		{
			System.out.println("Por favor, registre um veículo primeiro");
			veiculo = instanciarVeiculo();
			cliente.getListaVeiculos().add(veiculo);
		}
		else
		{
			int opcao;
			do
			{
				opcao = Leitura.leInt() - 1;
			} while (Validacao.validarIndice(opcao,cliente.getListaVeiculos()));
			veiculo = cliente.getListaVeiculos().get(opcao);
		}

		return veiculo;
	}

	public static Cliente cadastrarCliente()
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

	public static void cadastrarVeiculo(Seguradora seguradora)
	{
		Cliente cliente = selecionarCliente(seguradora);

		System.out.println("Iniciando cadastro de veículo");
		cliente.getListaVeiculos().add(instanciarVeiculo());
		cliente.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente));
	}

	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu, List<Seguradora> listaSeguradoras) 
	{
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
				listaSeguradoras.add(instanciarSeguradora());
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
				String documento = Leitura.leString();
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
				int opcao = Leitura.leInt() - 1;
				seguradora.getListaClientes().get(opcao).listarVeiculosPorCliente();
				break;

			case EXCLUIR_CLIENTE:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira o documento do cliente: ");
				String documento2 = Leitura.leString();
				seguradora.listarSinistrosPorCliente(documento2);
				break;

			case EXCLUIR_VEICULO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira a placa do veículo: ");
				String placa = Leitura.leString();
				seguradora.excluirVeiculo(placa);
				break;

			case EXCLUIR_SINISTRO:
				seguradora = selecionarSeguradora(listaSeguradoras);
				System.out.println("Insira o ID do sinistro: ");
				int id = Leitura.leInt();
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

		System.out.println("Vamos iniciar com alguns cadastros");

		System.out.println("Cadastre uma seguradora");
		Seguradora seg = instanciarSeguradora();
		listaSeguradoras.add(seg);

		System.out.println("Cadastre um cliente pessoa física");
		ClientePF clPf = instanciarPF();
		seg.getListaClientes().add(clPf);

		System.out.println("Registre um veículo para ele");
		Veiculo vePf = instanciarVeiculo();
		clPf.getListaVeiculos().add(vePf);

		System.out.println("Gere um sinistro para este veículo");
		Sinistro sinPf = instanciarSinistro(seg, vePf, clPf);
		seg.gerarSinistro(sinPf);
		clPf.setValorSeguro(seg.calcularPrecoSeguroCliente(clPf));

		System.out.println("Cadastre uma pessoa jurídica");
		ClientePJ clPj = instanciarPJ();
		seg.getListaClientes().add(clPj);

		System.out.println("Registre um veículo para ele");
		Veiculo vePj = instanciarVeiculo();
		clPj.getListaVeiculos().add(vePj);

		System.out.println("Gere um sinistro para este veículo");
		Sinistro sinPj = instanciarSinistro(seg, vePj, clPj);
		seg.gerarSinistro(sinPj);
		clPj.setValorSeguro(seg.calcularPrecoSeguroCliente(clPj));

		System.out.println("Clientes da seguradora " + seg.getNome());
		seg.listarClientesPorSeguradora();

		System.out.println("Sinistros registrados");
		seg.listarSinistrosPorSeguradora();

		System.out.println("Sinistro de " + clPf.getNome());
		seg.listarSinistrosPorCliente(clPf.getCpf());

		System.out.println("Sinistro de " + clPj.getNome());
		seg.listarSinistrosPorCliente(clPj.getCnpj());

		System.out.println("Receita da seguradora " + seg.getNome());
		System.out.println(seg.calcularReceita());

		System.out.println("Seguindo para as funções do sistema...");

		do 
		{
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op, listaSeguradoras);
		} while(op != MenuOperacoes.SAIR);

		System.out.println("Sistema encerrado");
	}
}