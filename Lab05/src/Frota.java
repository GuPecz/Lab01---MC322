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

    public boolean removerVeiculo(String placa)
    {
        for (Veiculo veiculo: listaVeiculos)
        {
            if (veiculo.getPlaca().equals(placa))
            {
                listaVeiculos.remove(veiculo);
                System.out.println("Veículo " + placa + " removido");
                return true;
            }
        }

        return false;
    }

    public String imprimirVeiculos()
    {
        String veiculos = "";
        int qtdVeiculos = listaVeiculos.size();

        for (int i = 0; i < qtdVeiculos; i++)
            veiculos += "Veículo " + i + "\n" + listaVeiculos.get(i);

        return veiculos;
    }

    public String toString()
    {
        return "Informações da frota" + "\nCódigo: " + codigo
                + "Lista de veículos: " + imprimirVeiculos();
    }
}