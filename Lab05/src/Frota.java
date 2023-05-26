import java.util.ArrayList;

public class Frota 
{
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota(String code, ArrayList<Veiculo> listaVeiculos) 
    {
        this.code = code;
        this.listaVeiculos = listaVeiculos;
    }

    public String getCode() 
    {
        return code;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() 
    {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) 
    {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo)
    {
        // Stub
        return false;
    }

    public boolean removeVeiculo()
    {
        // Stub
        return false;
    }
}