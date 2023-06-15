import java.time.LocalDate;

public class Sinistro
{
    private final int id;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    
    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) 
    {
        this.id = gerarId();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
    }

    public int gerarId()
    {
        return hashCode();
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
    
    public Condutor getCondutor() 
    {
        return condutor;
    }

    public void setCondutor(Condutor condutor) 
    {
        this.condutor = condutor;
    }

    public Seguro getSeguro() 
    {
        return seguro;
    }

    public void setSeguro(Seguro seguro) 
    {
        this.seguro = seguro;
    }

    public String toString() 
    {
        return "ID: " + id + "\nData:" + data + 
                "\nEndereço: " + endereco + "\nCondutor: " + condutor.getNome() + 
                "\nSeguro: " + seguro.getId();
    }
}