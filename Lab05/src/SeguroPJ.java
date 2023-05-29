import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPJ extends Seguro
{
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, int valorMensal, Frota frota, ClientePJ cliente) 
    {
        super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public Frota getFrota() 
    {
        return frota;
    }

    public void setFrota(Frota frota) 
    {
        this.frota = frota;
    }

    public ClientePJ getCliente() 
    {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) 
    {
        this.cliente = cliente;
    }

    public void desautorizarCondutor()
    {

    }

    public void autorizarCondutor()
    {

    }

    public double calcularValor()
    {
        // Stub
        return 0.0;
    }

    public boolean gerarSinistro(Sinistro sinistro)
    {
        // Stub
        return false;
    }
}