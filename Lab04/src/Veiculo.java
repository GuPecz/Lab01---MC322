public class Veiculo
{
    private String placa;
    private String modelo;
    private String marca;
    private int anoFabricacao;
    
    public Veiculo(String placa, String modelo, String marca, int anoFabricacao)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca()
    {
        return placa;
    }

    public void setPlaca(String placa)
    {
        this.placa = placa;
    }
    
    public String getModelo()
    {
        return modelo;
    }
    
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }
    
    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public int getAnoFabricacao() 
    {
        return anoFabricacao;
    }
    
    public void setAnoFabricacao(int anoFabricacao) 
    {
        this.anoFabricacao = anoFabricacao;
    }

    public String toString() 
    {
        return "Placa: " + placa + "\nModelo: " 
                + modelo + "\nMarca: " + marca + 
                "\nAno de fabricação: " + anoFabricacao + "\n";
    }
}