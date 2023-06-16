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
    
    public boolean gerarSinistro(Sinistro sinistro)
    {
        if (listaSinistros.contains(sinistro))
        {
            System.out.println("ERRO: Sinistro já registrado");
            return false;
        }
        else
        {
            listaSinistros.add(sinistro);
            sinistro.getCondutor().adicionarSinistro(sinistro);
            valorMensal = calcularValor();
            return true;
        }
    }
    
    public String listarSinistros()
    {
        String sinistros = "";
        int tam = listaSinistros.size();
        
        if (listaSinistros.isEmpty())
        System.out.println("ERRO: Não há sinistros registrados neste seguro");
        
        for (int i = 0; i < tam; i++)
        sinistros += "Sinistro " + (i + 1) + "\n" + listaSinistros.get(i);
        
        return sinistros;
        }
        
        public String listarCondutores()
        {
            String condutores = "";
            int tam = listaSinistros.size();
            
            if (listaCondutores.isEmpty())
            System.out.println("ERRO: Não há sinistros registrados neste seguro");
        
        for (int i = 0; i < tam; i++)
            condutores += "Condutor " + (i + 1) + "\n" + listaCondutores.get(i);
            
            return condutores;
        }
        
        public Condutor selecionarCondutor() 
        {
            Condutor condutor;
            
            if (listaCondutores.isEmpty())
            {
                System.out.println("Por favor, primeiro cadastre um condutor");
                condutor = null;
            }
            else
            {
                int opcao;
			
                System.out.println("Selecione um condutor");
                System.out.println(listarCondutores());
                do
                {	
                    opcao = Leitura.leInt() - 1;
                } while (!Validacao.validarIndice(opcao, listaCondutores));
                condutor = listaCondutores.get(opcao);
            }
            
            return condutor;
        }
        
    public void desautorizarCondutor(Condutor condutor)
    {
        if (!listaCondutores.contains(condutor))
            System.out.println("ERRO: Este condutor não está autorizado neste seguro");
        else if (listaCondutores.isEmpty())
            System.out.println("ERRO: Não há condutores autorizados neste seguro");
        
        listaCondutores.remove(condutor);
    }

    public void autorizarCondutor(Condutor condutor)
    {
        if (listaCondutores.contains(condutor))
            System.out.println("ERRO: Este condutor já está autorizado");
            
        listaCondutores.add(condutor);
    }

    public abstract double calcularValor();

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