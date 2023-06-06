import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro 
{
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;
    
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores) 
    {
        this.id = gerarId();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = listaSinistros;
        this.listaCondutores = listaCondutores;
        this.valorMensal = calcularValor();
    }
    
    private int gerarId()
    {
        return hashCode();
    }

    public int getId() 
    {
        return id;
    }

    public LocalDate getDataInicio() 
    {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) 
    {
        this.dataInicio = dataInicio;
    }
    
    public LocalDate getDataFim() 
    {
        return dataFim;
    }
    
    public void setDataFim(LocalDate dataFim) 
    {
        this.dataFim = dataFim;
    }
    
    public Seguradora getSeguradora() 
    {
        return seguradora;
    }
    
    public void setSeguradora(Seguradora seguradora) 
    {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() 
    {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) 
    {
        this.listaSinistros = listaSinistros;
    }
    
    public ArrayList<Condutor> getListaCondutores() 
    {
        return listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) 
    {
        this.listaCondutores = listaCondutores;
    }
    
    public double getValorMensal() 
    {
        return valorMensal;
    }
    
    public void setValorMensal(double valorMensal) 
    {
        this.valorMensal = valorMensal;
    }
    
    public abstract void desautorizarCondutor(Condutor condutor);

    public abstract void autorizarCondutor(Condutor condutor);
    
    public abstract double calcularValor();
    
    public abstract boolean gerarSinistro(Sinistro sinistro);

    public void listarSinistrosPorSeguro()
    {
        if (listaSinistros.isEmpty())
            System.out.println("ERRO: Não há sinistros registrados nesta seguro");

        int i = 1;
        for (Sinistro sinistro: listaSinistros)
        {
            System.out.println("Sinistro " + (i + 1));
            System.out.println(sinistro);
            i++;
        }
    }

    @Override
    public String toString() 
    {
        return "Informações do seguro" + "\nID: " + id + "\nData de início: " + dataInicio 
                + "\nData de fim: " + dataFim + "\nSeguradora: " + seguradora
                + "\nLista de sinistros: " + listaSinistros 
                + "\nLista de condutores: " + listaCondutores 
                + "\nValor mensal: " + valorMensal;
    }
}