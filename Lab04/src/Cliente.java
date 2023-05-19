import java.util.List;

public class Cliente
{
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;
    private double valorSeguro;
    
    
    public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos, double valorSeguro) 
    {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
        this.valorSeguro = valorSeguro;
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
    
    public double getValorSeguro() 
    {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) 
    {
        this.valorSeguro = valorSeguro;
    }

    public boolean excluirVeiculo(String placa)
    {
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

    public String listarVeiculosPorCliente()
    {
        String veiculos = "";
        int tam = listaVeiculos.size();

        if (tam <= 0)
            return "Nenhum veículo registrado";
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

    public double calculaScore()
    {
        return CalcSeguro.VALOR_BASE.getValor() * listaVeiculos.size();
    }

    public String toString() 
    {
        return "Nome: " + nome + "\nEndereco: " + endereco + 
                "\nLista de veículos: " + listarVeiculosPorCliente() + 
                "\nValor do seguro: " + valorSeguro + "\n";
    }

}