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

    public void desautorizarCondutor(Condutor condutor)
    {
        super.getListaCondutores().remove(condutor);
    }

    public void autorizarCondutor(Condutor condutor)
    {
        super.getListaCondutores().add(condutor);
    }

    public int calculaQtdSinistros(Cliente cliente)
    {
        // Stub
        return 0;
    }

    public boolean gerarSinistro(Sinistro sinistro)
    {
        // Stub
        return false;
    }

    public int calculaQtdVeiculos()
    {
        return frota.getListaVeiculos().size();
    }

    public int calculaQtdSinistrosCliente()
    {
        // Não está certo! Não estou entendendo como os sinistros se relacionam a um cliente específico
        int qtdSinistros = 0;

        for (Sinistro sinistro: super.getListaSinistros())
        {
            Seguradora seguradora = sinistro.getSeguro().getSeguradora();

            if (seguradora.getListaClientes().contains(cliente))
                qtdSinistros++;
        }

        return qtdSinistros;
    }

    public int calculaQtdSinistrosCondutor(Condutor condutor)
    {
        int qtdSinistros = 0;

        for (Sinistro sinistro: condutor.getListaSinistros())
            if (sinistro.getSeguro().equals(this))
                qtdSinistros++;

        return qtdSinistros;
    }

    public double calcularValor(Condutor condutor)
    {
        double valor_base = CalcSeguro.VALOR_BASE.getValor();
        int qtdFuncionarios, qtdVeiculos, anosPorFundacao, qtdSinistrosCliente, qtdSinistrosCondutor;
        qtdFuncionarios = super.getListaCondutores().size();
        qtdVeiculos = calculaQtdVeiculos();
        anosPorFundacao = cliente.calculaIdade();
        qtdSinistrosCliente = calculaQtdSinistrosCliente();
        qtdSinistrosCondutor = calculaQtdSinistrosCondutor(condutor);

        return valor_base * ((10 + qtdFuncionarios/10) * (1 + 1/(qtdVeiculos + 2)) * (1 + 1/(anosPorFundacao + 2)) * (2 + qtdSinistrosCliente/10) * (5 + qtdSinistrosCondutor/10));
    }
}