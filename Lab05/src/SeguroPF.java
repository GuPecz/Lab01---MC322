import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro
{
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, Veiculo veiculo, ClientePF cliente) 
    {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
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

    public void desautorizarCondutor(Condutor condutor)
    {
        super.getListaCondutores().remove(condutor);
    }

    public void autorizarCondutor(Condutor condutor)
    {
        super.getListaCondutores().add(condutor);
    }

    public boolean gerarSinistro(Sinistro sinistro)
    {
        if (super.getListaSinistros().contains(sinistro))
        {
            System.out.println("ERRO: Sinistro já registrado");
            return false;
        }
        else
        {
            super.getListaSinistros().add(sinistro);
            return true;
        }
    }
    
    public int calculaQtdVeiculos()
    {
        int qtdVeiculos = 0;
        String seguradora = super.getSeguradora().getNome();

        for (Veiculo veiculo: cliente.getListaVeiculos())
            if (veiculo.getNomeSeguradora().equals(seguradora))
                qtdVeiculos++;

        return qtdVeiculos;
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
        double fator_idade = 1.0, valor_base = CalcSeguro.VALOR_BASE.getValor();
        int idade = cliente.calculaIdade();
        int qtdVeiculos, qtdSinistrosCliente, qtdSinistrosCondutor;
        qtdVeiculos = calculaQtdVeiculos();
        qtdSinistrosCliente = super.getSeguradora().getSinistrosPorCliente(cliente.getCpf()).size();
        qtdSinistrosCondutor = calculaQtdSinistrosCondutor();

        if (idade < 30)
            fator_idade = CalcSeguro.FATOR_30_MENOS.getValor();
        else if (30 <= idade && idade <= 60)
            fator_idade = CalcSeguro.FATOR_30_60.getValor();
        else if (idade > 60)
            fator_idade = CalcSeguro.FATOR_60_MAIS.getValor();
        
        return valor_base * fator_idade * (1 + 1/(qtdVeiculos + 2)) * (2 + qtdSinistrosCliente/10) * (5 + qtdSinistrosCondutor/10);
    }
}