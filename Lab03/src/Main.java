import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

class Main
{
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
        boolean valido = ClientePF.validarCPF(cpf);
        
        while (!valido)
        {
            System.out.println("ERRO: CPF inválido\nTente novamente");
            cpf = input.nextLine();
            valido = ClientePF.validarCPF(cpf);
        }
        
        ClientePF cliente = new ClientePF(null, null, null, cpf, null, null, null, null, null);
        
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
        boolean valido = ClientePJ.validarCNPJ(cnpj);

        while (!valido)
        {
            System.out.println("ERRO: CNPJ inválido\nTente novamente");
            cnpj = input.nextLine();
            valido = ClientePJ.validarCNPJ(cnpj);
        }

        ClientePJ cliente = new ClientePJ(null, null, null, cnpj, null);

        IniciarCliente(cliente, input);

        System.out.println("Insira sua data de fundação [dd/mm/aaaa]: ");
        String data = input.nextLine();
        LocalDate dataFundacao = converteString(data);
        cliente.setDataFundacao(dataFundacao);

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

        System.out.println("Insira o endereço: ");
        String endereco = input.nextLine();

        return new Sinistro(data, endereco, seguradora, veiculo, cliente);
    }

    public static void main(String[] args)
    {
        Seguradora seguradora = new Seguradora("Seguradora Mirinho", 
                                            "(19) 3871-6912", 
                                            "mirinho@proton.me", 
                                            "Rua Tchurusbangustudusbagus, 24", 
                                            new ArrayList<Sinistro>(), new ArrayList<Cliente>());
        int ultimoCliente = 0;
        boolean cadastroValido = false;
        Scanner input = new Scanner(System.in);
        String tipoCliente;
        int qtdVeiculos;
        String documento;
        String continuar;

        System.out.println(seguradora.getNome());

        do
        {
            System.out.println("\n--------------------//--------------------\n");

            System.out.println("Deseja cadastrar uma pessoa física ou jurídica? [f/j]");

            tipoCliente = input.nextLine();

            System.out.println("Iniciando cadastro do cliente");
            switch (tipoCliente)
            {
                case "f":
                ClientePF clienteF = instanciarPF(input);
                cadastroValido = seguradora.cadastrarCliente(clienteF);
                ultimoCliente = seguradora.getListaClientes().size() - 1;
                System.out.println(clienteF);
                break;

                case "j":
                ClientePJ clienteJ = instanciarPJ(input);
                cadastroValido = seguradora.cadastrarCliente(clienteJ);
                ultimoCliente = seguradora.getListaClientes().size() - 1;
                System.out.println(clienteJ);
                break;
            }

            if (cadastroValido)
            {
                System.out.println("\n--------------------//--------------------\n");

                System.out.println("Quantidade de veículos associados a este cliente: ");

                qtdVeiculos = input.nextInt();
                input.nextLine();
                for (int i = 0; i < qtdVeiculos; i++)
                {
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Iniciando cadastro do veículo");
                    Veiculo veiculo = instanciarVeiculo(input2);
                    System.out.println(veiculo);

                    seguradora.getListaClientes().get(ultimoCliente).getListaVeiculos().add(veiculo);
                    
                    System.out.println("Deseja registrar um sinistro para este veículo? [s/n]");
                    String confirmacao = input2.nextLine();

                    if (confirmacao.equals("s"))
                    {
                        System.out.println("Iniciando registro do sinistro");
                        Sinistro sinistro = instanciarSinistro(input2, seguradora, veiculo, seguradora.getListaClientes().get(ultimoCliente));
                        System.out.println(sinistro);
                        seguradora.gerarSinistro(sinistro);
                    }
                }

                System.out.println("\n--------------------//--------------------\n");

                System.out.println("Clientes cadastrados\n");
                System.out.println("Pessoas físicas");
                seguradora.listarClientes("f");

                System.out.println("Pessoas jurídicas\n");
                seguradora.listarClientes("j");

                System.out.println("Sinistros registrados\n");
                seguradora.listarSinistros();

                System.out.println("\n--------------------//--------------------\n");

                System.out.println("Pesquisar sinistro por documento cadastrado de cliente");
                documento = input.nextLine();
                seguradora.visualizarSinistro(documento);

                System.out.println("Remover cliente por documento cadastrado");
                documento = input.nextLine();
                seguradora.removerCliente(documento);
            }

            System.out.println("Deseja cadastrar mais clientes? [s/n]");
            continuar = input.nextLine();

        } while (continuar.equals("s"));
    }
}