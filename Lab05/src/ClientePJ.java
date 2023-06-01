import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente
{
    private final String cnpj;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrotas;
    
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro, String cnpj, LocalDate dataFundacao, ArrayList<Frota> listaFrotas)
    {
        super(nome, endereco, listaVeiculos, valorSeguro);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.listaFrotas = listaFrotas;
    }
    
    public LocalDate getDataFundacao() 
    {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) 
    {
        this.dataFundacao = dataFundacao;
    }

    public String getCnpj() 
    {
        return cnpj;
    }
    
    public ArrayList<Frota> getListaFrotas() 
    {
        return listaFrotas;
    }

    public void setListaFrotas(ArrayList<Frota> listaFrotas) 
    {
        this.listaFrotas = listaFrotas;
    }

    @Override
    public String toString()
    {
        return super.toString() + "CNPJ: " + cnpj + 
        "\nData de fundação: " + dataFundacao;
    }

    public boolean cadastrarFrota(Frota frota)
    {
        for (Frota frotaCadastrada: listaFrotas)
            if (frotaCadastrada.getCode().equals(frota.getCode()))
            {
                System.out.println("ERRO: Esta frota já está cadastrada");
                return false;
            }

        listaFrotas.add(frota);
        System.out.println("Frota cadastrada com sucesso");

        return false;
    }

    private Frota buscaFrota(String code)
    {
        for (Frota frota: listaFrotas)
            if (frota.getCode().equals(code))
                return frota;

        return null;
    }

    public boolean atualizarFrota(int operacao, String code, Veiculo veiculo)
    {
        /* Operações
         * 1: Adicionar veículo
         * 2: Remover veículo
         * 3: Excluir frota
         */

        Frota frota = buscaFrota(code);

        switch(operacao)
        {
            case 1:
            frota.cadastrarVeiculo(veiculo);
            break;

            case 2:
            frota.removerVeiculo(veiculo.getPlaca());
            break;

            case 3:
            listaFrotas.remove(frota);
            break;
        }

        return false;
    }

    public boolean listarVeiculosPorFrota()
    {
        // Stub
        return false;
    }
}