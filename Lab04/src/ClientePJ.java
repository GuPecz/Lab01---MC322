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
    
    @Override
    public double calculaScore()
    {
        return CalcSeguro.VALOR_BASE.getValor() * (1 + (qtdeFuncionarios/100)) * super.getListaVeiculos().size();
    }
}