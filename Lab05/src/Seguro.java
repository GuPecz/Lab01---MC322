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
    private int valorMensal;
    
    public Seguro(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
    ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, int valorMensal) 
    {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = listaSinistros;
        this.listaCondutores = listaCondutores;
        this.valorMensal = valorMensal;
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

    public int getValorMensal() 
    {
        return valorMensal;
    }

    public void setValorMensal(int valorMensal) 
    {
        this.valorMensal = valorMensal;
    }

    public abstract void desautorizarCondutor();

    public abstract void autorizarCondutor();

    public abstract double calcularValor();

    public abstract boolean gerarSinistro(Sinistro sinistro);
}