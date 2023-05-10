import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente
{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;
    
    
    public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, double valorSeguro, String cpf, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica)
    {
        super(nome, endereco, listaVeiculos, valorSeguro);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf() 
    {
        return cpf;
    }

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() 
    {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) 
    {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() 
    {
        return educacao;
    }

    public void setEducacao(String educacao) 
    {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() 
    {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }
    
    public String getClasseEconomica() 
    {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) 
    {
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String toString()
    {
        return super.toString() + "CPF: " + cpf + "\nData de licença: " + dataLicenca + 
                "\nEducação: " + educacao + "\nGênero: " + genero + 
                "\nClasse econômica: " + classeEconomica +
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

    @Override /* ? */
    public double calculaScore()
    {
        // Stub
        return 0.0;
    }
}