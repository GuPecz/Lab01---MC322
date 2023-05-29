import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro
{
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, int valorMensal, Veiculo veiculo, ClientePF cliente) 
    {
        super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() 
    {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) 
    {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() 
    {
        return cliente;
    }

    public void setCliente(ClientePF cliente) 
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