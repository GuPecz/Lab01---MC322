package lab02;
import java.util.Random;

public class Sinistro
{
    private int id;
    private String data;
    private String endereco;

    public Sinistro(String data, String endereco)
    {
        Random rng = new Random(); /* Random Number Generator, ou seja, Gerador de Número Aleatório */

        this.id = rng.nextInt(1000);
        this.data = data;
        this.endereco = endereco;
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
}