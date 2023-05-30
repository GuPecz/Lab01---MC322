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

    public int calculaQtdSinistros(Cliente cliente)
    {
        int qtdSinistros = 0;

        for (Sinistro sinistro: super.getListaSinistros())
        {
            Cliente clienteSinistro = sinistro.getCliente();

            if (clienteSinistro instanceof ClientePF && sinistro.getCliente().equals(cliente))
                qtdSinistros++;
        }

        return qtdSinistros;
    }

    public double calcularValor()
    {
        double fator_idade = 1.0, valor_base = CalcSeguro.VALOR_BASE.getValor();
        int idade = cliente.calculaIdade(cliente.getDataNascimento());
        int qtdVeiculos = cliente.getListaVeiculos().size();


        if (idade < 30)
            fator_idade = CalcSeguro.FATOR_30_MENOS.getValor();
        else if (30 <= idade && idade <= 60)
            fator_idade = CalcSeguro.FATOR_30_60.getValor();
        else if (idade > 60)
            fator_idade = CalcSeguro.FATOR_60_MAIS.getValor();
        
        return valor_base * fator_idade * qtdVeiculos;
        // valor_base * fator_idade * (1 + 1/(qtdVeiculos + 2)) * (2 + qtdSinistrosCliente/10) * (5 + qtdSinistrosCondutor/10)
    }

    public boolean gerarSinistro(Sinistro sinistro)
    {
        // Stub
        return false;
    }
}