import java.util.List;

public class Cliente
{
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;
    
    public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos)
    {
        this.nome = nome;
        this.endereco = endereco;
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

        if (tam <= 0)
        {
            return "";
        }
        else
        {
            for (int i = 0; i < tam - 1; i++)
            {
                veiculos += listaVeiculos.get(i).getPlaca() + ", ";
            }

            veiculos += listaVeiculos.get(tam - 1).getPlaca();

            return veiculos;
        }
    }

    public String toString() 
    {
        return "Informações do cliente\nNome: " + nome + "\nEndereco: " + endereco + 
                "\nLista de veículos: " + imprimirVeiculos() + "\n";
    }
}