import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPJ extends Seguro
{
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, Frota frota, ClientePJ cliente) 
    {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
        this.frota = frota;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
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

    public int calculaQtdVeiculos()
    {
        return frota.getListaVeiculos().size();
    }

    public int calculaQtdSinistrosCondutor()
    {
        int qtdSinistros = 0;

        for (Condutor condutor: super.getListaCondutores())
            for (Sinistro sinistro: condutor.getListaSinistros())
                if (sinistro.getSeguro().equals(this))
                    qtdSinistros++;

        return qtdSinistros;
    }

    public double calcularValor()
    {
        double valor_base = CalcSeguro.VALOR_BASE.getValor();
        int qtdFuncionarios, qtdVeiculos, anosPorFundacao, qtdSinistrosCliente, qtdSinistrosCondutor;
        qtdFuncionarios = super.getListaCondutores().size();
        qtdVeiculos = calculaQtdVeiculos();
        anosPorFundacao = cliente.calculaIdade();
        qtdSinistrosCliente = super.getSeguradora().getSinistrosPorCliente(cliente.getCnpj()).size();
        qtdSinistrosCondutor = calculaQtdSinistrosCondutor();

        return valor_base * ((10 + qtdFuncionarios/10) * (1 + 1/(qtdVeiculos + 2)) * (1 + 1/(anosPorFundacao + 2)) * (2 + qtdSinistrosCliente/10) * (5 + qtdSinistrosCondutor/10));
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nCódigo da frota: " + frota.getCodigo()
        + "\nVeículos da frota: " + cliente.listarVeiculosPorFrota(frota.getCodigo())
        + "CNPJ do cliente: " + cliente.getCnpj()
        + "Nome do cliente: " + cliente.getNome();
    }
}