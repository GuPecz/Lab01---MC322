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

    @Override /* ? */
    public double calculaScore()
    {
        // Stub
        return 0.0;
    }
}