import java.util.ArrayList;

public class Frota 
{
    private String codigo;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota(ArrayList<Veiculo> listaVeiculos) 
    {
        this.codigo = gerarCodigo();
        this.listaVeiculos = listaVeiculos;
    }

    public String gerarCodigo() 
    {
        return Integer.toString(hashCode());
    }

    public String getCodigo() 
    {
        return codigo;
    }

    public ArrayList<Veiculo> getListaVeiculos() 
    {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) 
    {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo)
    {
        if (listaVeiculos.contains(veiculo))
        {
            System.out.println("ERRO: Este veículo já está cadastrado");
            return false;
        }

        listaVeiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso");

        return true;
    }

    public void removerVeiculo(Veiculo veiculo)
    {
        listaVeiculos.remove(veiculo);
        System.out.println("Veículo " + veiculo.getPlaca() + " removido");
    }

    public String imprimirVeiculos()
    {
        String veiculos = "";
        int qtdVeiculos = listaVeiculos.size();

        for (int i = 0; i < qtdVeiculos; i++)
            veiculos += "Veículo " + (i + 1) + "\n" + listaVeiculos.get(i) + "\n";

        return veiculos;
    }

	public Veiculo selecionarVeiculo()
	{
		Veiculo veiculo;
		
		if (listaVeiculos.isEmpty())
		{
			System.out.println("Por favor cadastre um veículo primeiro");
			veiculo = null;
		}
		else
		{
			int opcao;

			System.out.println("Selecione um veículo");
			System.out.println(imprimirVeiculos());
			do
			{	
				opcao = Leitura.leInt() - 1;
			} while (!Validacao.validarIndice(opcao, listaVeiculos));
			veiculo = listaVeiculos.get(opcao);
		}
		
		return veiculo;
	}

    public String toString()
    {
        return "Informações da frota" + "\nCódigo: " + codigo;
    }
}