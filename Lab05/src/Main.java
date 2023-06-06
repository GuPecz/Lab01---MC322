import java.time.LocalDate;
import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
import java.util.Scanner;

/* A FAZER:
 * - Tomar cuidado com a inicialização do atributo nomeSeguradora dos veículos
 * - Lidar com condutor e seguro na instanciação do sinistro
 * - Implementar impressão decente das listas
 * - Cuidar da data fim do seguro
 * - Pedir quantidade de sinistros na instanciação do seguro
 * - Melhorar implementação do gerarCodigo em Frota
 * - Reimplementar listagens em Seguradora para retornarem uma String
 */

public class Main 
{
	public class Leitura 
	{
		private static Scanner input = new Scanner(System.in);
		
		public static LocalDate leData()
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

		public static String lePalavra()
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

		public static int leInt()
		{
			String inteiro;
			boolean intValido = false;

			do
			{
				inteiro = input.nextLine();

				try
				{
					Integer.parseInt(inteiro);
					intValido = true;
				} 
				catch (NumberFormatException e)
				{
					System.out.println("ERRO: Número inválido");
				}
			} while (!intValido);

			return Integer.parseInt(inteiro);
		}

		public static String leString()
		{
			return input.nextLine();
		}
	}

	/* Métodos de instanciação de objetos */

	public static Seguradora instanciarSeguradora()
	{
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

	public static void IniciarCliente(Cliente cliente)
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
        
        IniciarCliente(cliente);
        
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

        IniciarCliente(cliente);

        System.out.print("Insira a data de fundação do cliente [dd/mm/aaaa]: ");
		LocalDate dataFundacao = Leitura.leData();
        cliente.setDataFundacao(dataFundacao);

        return cliente;
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

        return new Veiculo(placa, modelo, marca, anoFabricacao, null);
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

		return  new Condutor(cpf, nome, telefone, endereco, email, dataNascimento, new ArrayList<Sinistro>());
	}

	public static SeguroPF instanciarSeguroPF(ArrayList<Seguradora> listaSeguradoras)
	{
		System.out.println("Selecione uma seguradora:");
		Seguradora seguradora = selecionarSeguradora(listaSeguradoras);

		System.out.println("Selecione um cliente:");
		ClientePF cliente = (ClientePF)selecionarCliente(seguradora);

		System.out.println("Selecione um veículo:");
		Veiculo veiculo = selecionarVeiculo(cliente);

		SeguroPF seguro = new SeguroPF(LocalDate.now(), LocalDate.now().plusMonths(6), seguradora, new ArrayList<Sinistro>(), new ArrayList<Condutor>(), veiculo, cliente);

		return seguro;
	}

	public static Frota instanciarFrota()
	{
		return new Frota(new ArrayList<Veiculo>());
	}

	public static SeguroPJ instanciarSeguroPJ(ArrayList<Seguradora> listaSeguradoras)
	{
		System.out.println("Selecione uma seguradora:");
		Seguradora seguradora = selecionarSeguradora(listaSeguradoras);

		System.out.println("Selecione um cliente:");
		ClientePJ cliente = (ClientePJ)selecionarCliente(seguradora);

		System.out.println("Selecione uma frota:");
		Frota frota = selecionarFrota(cliente);

		SeguroPJ seguro = new SeguroPJ(LocalDate.now(), LocalDate.now().plusMonths(6), seguradora, new ArrayList<Sinistro>(), new ArrayList<Condutor>(), frota, cliente);

		return seguro;
	}

    public static Sinistro instanciarSinistro(Seguradora seguradora, Veiculo veiculo, Cliente cliente)
    {
        System.out.print("Insira a data do sinistro [dd/mm/aaaa]: ");
		LocalDate dataSinistro = Leitura.leData();

        System.out.print("Insira o endereço do sinistro: ");
        String endereco = Leitura.leString();

        return new Sinistro(dataSinistro, endereco, null, null);
    }

	/* Métodos de listagem de objetos */

	public static void listarSeguradoras(ArrayList<Seguradora> listaSeguradoras)
	{
		int tam = listaSeguradoras.size();

		System.out.println("Seguradoras cadastradas: ");

		for (int i = 0; i < tam; i++)
			System.out.println((i + 1) + " - " + listaSeguradoras.get(i).getNome());
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

			System.out.println("Selecione um veículo:");
			cliente.listarVeiculos();
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, cliente.getListaVeiculos()));
			veiculo = cliente.getListaVeiculos().get(opcao);
		}
		
		return veiculo;
	}

	public static Frota selecionarFrota(ClientePJ cliente)
	{
		Frota frota;

		if (cliente.getListaFrotas().isEmpty())
		{
			System.out.println("Por favor cadastre uma frota primeiro");
			frota = instanciarFrota();
		}
		else
		{
			int opcao;

			System.out.println("Selecione uma frota:");
			cliente.listarFrotas();
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, cliente.getListaVeiculos()));
			veiculo = cliente.getListaVeiculos().get(opcao);
		}

		return frota;
	}

	public static void main(String[] args) 
	{

	}
}