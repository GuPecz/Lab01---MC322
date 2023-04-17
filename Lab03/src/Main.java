import java.util.Scanner;
import java.util.Date;
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

        System.out.println("Insira seu grau de escolaridade: ");
        String educacao = input.nextLine();
        cliente.setEducacao(educacao);

        System.out.println("Insira seu gênero: ");
        String genero = input.nextLine();
        cliente.setGenero(genero);

        System.out.println("Insira sua classe econômica: ");
        String classeEconomica = input.nextLine();
        cliente.setClasseEconomica(classeEconomica);

        List<Veiculo> listaVeiculos = new ArrayList<>();
        cliente.setListaVeiculos(listaVeiculos);

        Date dataLicenca = new Date();
        cliente.setDataLicenca(dataLicenca);
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
        
        System.out.println("Insira sua data de nascimento: ");
        input.nextLine();

        ClientePF cliente = new ClientePF(null, null, null, null, null, null, null, cpf, new Date());

        IniciarCliente(cliente, input);

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

        System.out.println("Insira sua data de fundação: ");
        input.nextLine();

        ClientePJ cliente = new ClientePJ(null, null, null, null, null, null, null, cnpj, new Date());

        IniciarCliente(cliente, input);

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

        return new Veiculo(placa, modelo, marca, anoFabricacao);
    }

    public static Sinistro instanciarSinistro(Scanner input, Seguradora seguradora, Veiculo veiculo, Cliente cliente)
    {
        System.out.println("Insira a data: ");
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
                                           "Rua Tchurusbangutudusbagu, 24", 
                                           new ArrayList<Sinistro>(), new ArrayList<Cliente>());
        int ultimoCliente = 0;
        int ultimoSinistro = 0;
        Scanner input = new Scanner(System.in);
        String tipoCliente;
        int qtdVeiculos;
        String sn = ""; // Sim ou não

        System.out.println(seguradora);
        System.out.println("\n--------------------//--------------------\n");

        System.out.println("Deseja cadastrar uma pessoa física ou jurídica? [f/j]");

        tipoCliente = input.nextLine();

        switch (tipoCliente)
        {
            case "f":
            ClientePF clienteF = instanciarPF(input);
            seguradora.cadastrarCliente(clienteF);
            ultimoCliente = seguradora.getListaClientes().size() - 1;
            System.out.println(clienteF);
            break;

            case "j":
            ClientePJ clienteJ = instanciarPJ(input);
            seguradora.cadastrarCliente(clienteJ);
            ultimoCliente = seguradora.getListaClientes().size() - 1;
            System.out.println(clienteJ);
            break;
        }

        System.out.println("\n--------------------//--------------------\n");

        System.out.println("Quantidade de veículos associados a este cliente: ");

        qtdVeiculos = input.nextInt();
        input.nextLine();
        for (int i = 0; i < qtdVeiculos; i++)
        {
            Veiculo veiculo = instanciarVeiculo(input);
            System.out.println(veiculo);

            seguradora.getListaClientes().get(ultimoCliente).getListaVeiculos().add(veiculo);

            System.out.println("Deseja gerar um sinistro para este veículo? [s/n]");
            sn = input.nextLine();
            
            if (sn == "s")
            {
                Sinistro sinistro = instanciarSinistro(input, seguradora, veiculo, seguradora.getListaClientes().get(ultimoCliente));
                ultimoSinistro = seguradora.getListaSinistros().size() - 1;
                System.out.println(sinistro);
                seguradora.gerarSinistro(sinistro);
            }
        }

        System.out.println("\n--------------------//--------------------\n");


    }
}