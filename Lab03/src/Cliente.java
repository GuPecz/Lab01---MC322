import java.time.LocalDate;
import java.util.List;

public class Cliente
{
    private String nome;
    private String endereco;
    private LocalDate dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private List<Veiculo> listaVeiculos;
    
    public Cliente(String nome, String endereco, LocalDate dataLicenca, String educacao, String genero, String classeEconomica, List<Veiculo> listaVeiculos)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.listaVeiculos = listaVeiculos;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }


    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
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

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public String getClasseEconomica() 
    {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) 
    {
        this.classeEconomica = classeEconomica;
    }

    public List<Veiculo> getListaVeiculos() 
    {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) 
    {
        this.listaVeiculos = listaVeiculos;
    }

    public String imprimirVeiculos()
    {
        String veiculos = "";
        int tam = listaVeiculos.size();

        for (int i = 0; i < tam - 1; i++)
        {
            veiculos += listaVeiculos.get(i) + ", ";
        }

        veiculos += listaVeiculos.get(tam - 1);

        return veiculos;
    }

    public String toString() 
    {
        return "Informações do cliente\nNome: " + nome + "\nEndereco: " + endereco + 
                "\nData da licença: " + dataLicenca + "\nEducação: " + educacao +
                "\nGênero: " + genero + "\nClasse econômica: " + classeEconomica +
                "\nLista de veículos: " + imprimirVeiculos() + "\n";
    }
}