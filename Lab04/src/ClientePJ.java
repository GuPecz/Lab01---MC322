import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente
{
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;
    
    
    public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, double valorSeguro, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios)
    {
        super(nome, endereco, listaVeiculos, valorSeguro);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    
    public LocalDate getDataFundacao() 
    {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) 
    {
        this.dataFundacao = dataFundacao;
    }

    public String getCnpj() 
    {
        return cnpj;
    }
    
    public int getQtdeFuncionarios() 
    {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) 
    {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    @Override
    public String toString()
    {
        return super.toString() + "CNPJ: " + cnpj + 
        "\nData de fundação: " + dataFundacao + "\n";
    }
    
    public static int digitoVerificador(int[] cnpj, int ini, int fim)
    {
        int[] mults = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int verificador = 0;
        int resto;
        int j;

        if (fim == 12) 
        {
            j = 1;
        }
        else
        {
            j = 0;
        }

        for (int i = ini; i < fim; i++, j++)
        {
            verificador += cnpj[i] * mults[j];
        }

        resto = verificador % 11;
        if (resto < 2)
        {
            return 0;
        }
        else
        {
            return (11 - resto);
        }
    }

    public static boolean validarCNPJ(String cnpj)
    {
        int[] cnpjInt = new int[14];
        boolean todosIguais = true;
        int verificadorUm;
        int verificadorDois;
        

        String cnpjNumeros = cnpj.replaceAll("\\D", "");

        if (cnpjNumeros.length() != 14)
        {            
            return false;
        }

        for (int i = 0; i < 14; i++)
        {
            cnpjInt[i] = cnpjNumeros.charAt(i) - '0';
        }

        for (int i = 1; i < 14; i++)
        {
            if (cnpjInt[i] != cnpjInt[i - 1])
            {
                todosIguais = false;
                break;
            }
        }

        if (todosIguais == true)
        {
            return false;
        }

        verificadorUm = digitoVerificador(cnpjInt, 0, 12);
        verificadorDois = digitoVerificador(cnpjInt, 0, 13);

        if (cnpjInt[12] == verificadorUm && cnpjInt[13] == verificadorDois)
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