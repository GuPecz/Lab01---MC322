import java.util.Random;
import java.time.LocalDate;

public class Sinistro
{
    private final int id;
    private LocalDate data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    
    public Sinistro(LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) 
    {
        id = gerarId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public int gerarId()
    {
        Random rng = new Random(); /* Random Number Generator, ou seja, Gerador de Número Aleatório */

        return rng.nextInt(899) + 100; /* Para que sejam gerados apenas números com 3 algarismos */
    }

    public int getId()
    {
        return id;
    }
    
    public LocalDate getData()
    {
        return data;
    }
    
    public void setData(LocalDate data)
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
        return "ID: " + id + "\nData:" + data + 
                "\nEndereço: " + endereco + "\nSeguradora: " + seguradora.getNome() + 
                "\nVeiculo: " + veiculo.getPlaca() + "\nCliente: " + cliente.getNome() + "\n";
    }

    public static void main(String[] args)
    {
        Random rng = new Random(); /* Random Number Generator, ou seja, Gerador de Número Aleatório */

        int id = rng.nextInt(899) + 100;

        System.out.println(id);
    }
}