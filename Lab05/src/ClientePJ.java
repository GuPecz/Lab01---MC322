import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente
{
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;
    
    
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios)
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
        "\nData de fundação: " + dataFundacao;
    }

    public boolean cadastrarFrota()
    {
        // Stub
        return false;
    }

    public boolean atualizarFrota()
    {
        // Stub
        return false;
    }

    public boolean listarVeiculosPorFrota()
    {
        // Stub
        return false;
    }
}