import java.util.Random;

public class Sinistro
{
    private int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    
    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) 
    {
        Random rng = new Random(); /* Random Number Generator, ou seja, Gerador de Número Aleatório */

        this.id = rng.nextInt(899) + 100; /* Para que sejam gerados apenas números com 3 algarismos */
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getData()
    {
        return data;
    }
    
    public void setData(String data)
    {
        this.data = data;
    }
    
    public String getEndereco()
    {
        return endereco;
    }
    
    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }
    
    public Seguradora getSeguradora() 
    {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) 
    {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() 
    {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) 
    {
        this.veiculo = veiculo;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public String toString() 
    {
        return "Informações do sinistro\nID: " + id + "\nData:" + data + 
                "\nEndereço: " + endereco + "\nSeguradora: " + seguradora + 
                "\nVeiculo: " + veiculo + "\nCliente: " + cliente + "\n";
    }

    public static void main(String[] args)
    {
        Random rng = new Random(); /* Random Number Generator, ou seja, Gerador de Número Aleatório */

        int id = rng.nextInt(899) + 100;

        System.out.println(id);
    }
}