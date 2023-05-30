import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente
{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;
    
    
    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro, String cpf, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica)
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
                "\nData de nascimento: " + dataNascimento;
    }

    public int calculaIdade(LocalDate dataNascimento)
    {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    public boolean cadastrarVeiculo(Veiculo veiculo)
    {
        ArrayList<Veiculo> listaVeiculos = super.getListaVeiculos();

        if (listaVeiculos.contains(veiculo))
        {
            System.out.println("ERRO: Este veículo já está cadastrado");
            return false;
        }

        listaVeiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso");
        return true;
    }

    public boolean removerVeiculo(String placa)
    {
        ArrayList<Veiculo> listaVeiculos = super.getListaVeiculos();
        
        for (Veiculo veiculo: listaVeiculos)
        {
            if (veiculo.getPlaca().equals(placa))
            {
                listaVeiculos.remove(veiculo);
                System.out.println("Veículo " + placa + " removido");
                return true;
            }
        }

        return false;
    }
}