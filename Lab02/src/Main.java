import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Seguradora seguradora = new Seguradora("Seguros SA", "(19)97105-3864", "seguros@proton.me", "Rua Tchurusbangutudusbagu");

        Cliente cliente;
        String clNome, clCpf, clNascimento, clEnd;
        int clIdade;

        Veiculo veiculo;
        String vePlaca, veModelo, veMarca;

        Sinistro sinistro;
        String siData, siEnd;

        System.out.println("Seja bem-vindo(a) ao sistema da Seguros SA!");

        // Inicializando o Cliente

        System.out.print("Insira seu nome: ");
        clNome = input.nextLine();

        System.out.print("Insira seu CPF: ");
        clCpf = input.nextLine();

        System.out.print("Insira seu Data de nascimento: ");
        clNascimento = input.nextLine();

        System.out.print("Insira sua idade: ");
        clIdade = input.nextInt();
        input.nextLine();

        System.out.print("Insira seu Endereço: ");
        clEnd = input.nextLine();

        cliente = new Cliente(clNome, clCpf, clNascimento, clIdade, clEnd);

        if (cliente.validarCPF() == false)
        {
            System.out.println("AVISO: Seu CPF não é válido!");
        }

        System.out.println(cliente);

        // Inicializando o Veiculo

        System.out.println("Agora as informações do seu veículo");

        System.out.print("Insira a placa: ");
        vePlaca = input.nextLine();

        System.out.print("Insira o modelo: ");
        veModelo = input.nextLine();

        System.out.print("Insira a marca: ");
        veMarca = input.nextLine();

        veiculo = new Veiculo(vePlaca, veModelo, veMarca);

        System.out.println("Agora as informações do sinistro a ser registrado");

        // Inicializando o Sinistro
        
        System.out.print("Insira a data: ");
        siData = input.nextLine();

        System.out.print("Insira o endereço: ");
        siEnd = input.nextLine();

        sinistro = new Sinistro(siData, siEnd);
        }
}