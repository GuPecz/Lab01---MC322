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

    private int calculaIdade(LocalDate dataNascimento)
    {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    @Override
    public double calculaScore()
    {
        double fator_idade = 1.0, valor_base = CalcSeguro.VALOR_BASE.getValor();
        int idade = calculaIdade(dataNascimento);
        int qtdeCarros = super.getListaVeiculos().size();


        if (18 <= idade &&  idade < 30)
            fator_idade = CalcSeguro.FATOR_18_30.getValor();
        else if (30 <= idade && idade < 60)
            fator_idade = CalcSeguro.FATOR_18_30.getValor();
        else if (60 <= idade && idade < 90)
            fator_idade = CalcSeguro.FATOR_60_90.getValor();
        
        return valor_base * fator_idade * qtdeCarros;
    }

    public static void main(String[] args)
    {

    }
}