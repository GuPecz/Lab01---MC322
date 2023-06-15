import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente
{
    private final String cnpj;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrotas;
    
    public ClientePJ(String nome, String telefone, String endereco, String email, String cnpj, LocalDate dataFundacao, ArrayList<Frota> listaFrotas) 
    {
        super(nome, telefone, endereco, email);
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
    
    public boolean cadastrarFrota(Frota frota)
    {
        for (Frota frotaCadastrada: listaFrotas)
            if (frotaCadastrada.getCodigo().equals(frota.getCodigo()))
            {
                System.out.println("ERRO: Esta frota já está cadastrada");
                return false;
            }

        listaFrotas.add(frota);
        System.out.println("Frota cadastrada com sucesso");
        
        return false;
    }
    
    public boolean atualizarFrota(int operacao, Frota frota, Veiculo veiculo)
    {
        /* Operações
        * 1: Adicionar veículo
        * 2: Remover veículo
        * 3: Excluir frota
        */

        switch(operacao)
        {
            case 1:
            frota.cadastrarVeiculo(veiculo);
            break;
            
            case 2:
            frota.removerVeiculo(veiculo);
            break;
            
            case 3:
            listaFrotas.remove(frota);
            break;
        }
        
        return false;
    }
    
    public String listarFrotas()
    {
        String frotas = "Frotas:";
        int tam = listaFrotas.size();

        if (tam <= 0)
            return "Nenhum veículo registrado";
        else
        {
            for (int i = 0; i < tam - 1; i++)
                frotas += "\n" + (i + 1) + listaFrotas.get(i).getCodigo();

            return frotas;
        }
    }

    public boolean listarVeiculosPorFrota(String codigo)
    {
        if (listaFrotas.isEmpty())
        {
            System.out.println("ERRO: Não há frotas registradas");
            return false;
        }
        
        for (Frota frota: listaFrotas)
        {
            int tam = frota.getListaVeiculos().size();

            System.out.println("Veículos da frota " + frota.getCodigo());
            for (int i = 0; i < tam - 1; i++)
                System.out.print(frota.imprimirVeiculos());
        }
        
        return true;
    }
    
	public Frota selecionarFrota()
	{
		Frota frota;
		
		if (listaFrotas.isEmpty())
		{	
			System.out.println("Por favor, primeiro cadastre uma frota");
			frota = null;
		}
		else
		{
			int opcao;
			
			System.out.println("Selecione uma frota");
			System.out.println(listarFrotas());
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, listaFrotas));
			frota = listaFrotas.get(opcao);
		}
		
		return frota;
	}

    public int calculaIdade()
    {
        return LocalDate.now().getYear() - dataFundacao.getYear();
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "\nCNPJ: " + cnpj + 
        "\nData de fundação: " + dataFundacao;
    }
}