import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente
{
    private final String cnpj;
    private Date dataFundacao;
    
    public ClientePJ(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao)
    {
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }
    
    public Date getDataFundacao() 
    {
        return dataFundacao;
    }
    
    public void setDataFundacao(Date dataFundacao) 
    {
        this.dataFundacao = dataFundacao;
    }

    public String getCnpj() 
    {
        return cnpj;
    }

    @Override
    public String toString()
    {
        // Stub
        return "oi";
    }

    public boolean validarCnpj(String cnpj)
    {
        // Stub
            return false;
    }
}