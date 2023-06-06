import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente
{
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;
    
    public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, LocalDate dataNascimento, ArrayList<Veiculo> listaVeiculos) 
    {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = listaVeiculos;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public String getGenero() 
    {
        return genero;
    }
    
    public void setGenero(String genero) 
    {
        this.genero = genero;
    }
    
    public String getEducacao() 
    {
        return educacao;
    }
    
    public void setEducacao(String educacao) 
    {
        this.educacao = educacao;
    }
    
    public LocalDate getDataNascimento() 
    {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
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

    public String listarVeiculos()
    {
        String veiculos = "Veiculos:";
        int tam = listaVeiculos.size();

        if (tam <= 0)
            return "Nenhum veículo registrado";
        else
        {
            for (int i = 0; i < tam - 1; i++)
            {
                veiculos += "\n" + (i + 1) + listaVeiculos.get(i).getPlaca();
            }

            return veiculos;
        }
    }

    public int calculaIdade()
    {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nCPF: " + cpf + "\nGênero: " + genero 
                + "\nEducação: " + educacao + "\nData de nascimento: " + dataNascimento
                + "\nLista de veículos: " + listarVeiculos();
    }
}