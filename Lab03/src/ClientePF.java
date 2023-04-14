import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente
{
    private final String cpf;
    private Date dataNascimento;
    
    public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, List<Veiculo> listaVeiculos, String cpf, Date dataNascimento)
    {
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    public Date getDataNascimento() 
    {
        return dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) 
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
        // Stub
        return "oi";
    }

    // Método do Lab 2, verificar funcionamento agora
    private int digitoVerificador(int[] cpf, int ini, int fim)
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

    public boolean validarCPF(String cpf)
    {
        int[] cpfInt = new int[]{0};
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

        verificadorUm = digitoVerificador(cpfInt, 0, 10);
        verificadorDois = digitoVerificador(cpfInt, 1, 11);

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