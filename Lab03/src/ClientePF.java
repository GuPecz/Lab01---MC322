import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente
{
    private final String cpf;
    private LocalDate dataNascimento;
    
    public ClientePF(String nome, String endereco, LocalDate dataLicenca, String educacao, String genero, String classeEconomica, List<Veiculo> listaVeiculos, String cpf, LocalDate dataNascimento)
    {
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    public LocalDate getDataNascimento() 
    {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() 
    {
        return cpf;
    }

    @Override
    public String toString()
    {
        return "Informações do cliente\nNome: " + super.getNome() + "\nEndereco: " + super.getEndereco() + 
                "\nData de licença: " + super.getDataLicenca() + "\nEducação: " + super.getEducacao() +
                "\nGênero: " + super.getGenero() + "\nClasse econômica: " + super.getClasseEconomica() +
                "\nLista de veículos: " + super.imprimirVeiculos() + "\nCPF: " + cpf + 
                "\nData de nascimento: " + dataNascimento + "\n";
    }

    // Método do Lab 2, verificar funcionamento agora
    public static int digitoVerificador(int[] cpf, int ini, int fim)
    {
        int multiplicador = 10;
        int verificador = 0;
        int resto;

        for (int i = ini; i < fim; i++, multiplicador--)
        {
            verificador += cpf[i] * multiplicador;
        }

        resto = verificador % 11;
        if (resto == 1 || resto == 0)
        {
            return 0;
        }
        else
        {
            return (11 - resto);
        }
    }

    public static boolean validarCPF(String cpf)
    {
        int[] cpfInt = new int[11];
        boolean todosIguais = true;
        int verificadorUm;
        int verificadorDois;
        

        String cpfNumeros = cpf.replaceAll("\\D", "");

        if (cpfNumeros.length() != 11)
        {            
            return false;
        }

        for (int i = 0; i < 11; i++)
        {
            cpfInt[i] = cpfNumeros.charAt(i) - '0';
        }

        for (int i = 1; i < 11; i++)
        {
            if (cpfInt[i] != cpfInt[i - 1])
            {
                todosIguais = false;
                break;
            }
        }

        if (todosIguais == true)
        {
            return false;
        }

        verificadorUm = digitoVerificador(cpfInt, 0, 9);
        verificadorDois = digitoVerificador(cpfInt, 1, 10);

        if (cpfInt[9] == verificadorUm && cpfInt[10] == verificadorDois)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}