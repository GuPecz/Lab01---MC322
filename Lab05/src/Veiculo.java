public class Veiculo
{
    private String placa;
    private String modelo;
    private String marca;
    private int anoFabricacao;
    private String nomeSeguradora;
    
    public Veiculo(String placa, String modelo, String marca, int anoFabricacao, String nomeSeguradora)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.nomeSeguradora = nomeSeguradora;
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

    public String getNomeSeguradora() 
    {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) 
    {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String toString() 
    {
        return "Placa: " + placa + "\nModelo: " 
                + modelo + "\nMarca: " + marca
                + "\nAno de fabricação: " + anoFabricacao
                + "\nSegurado por: " + nomeSeguradora;
    }
}