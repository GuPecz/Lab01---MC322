import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor 
{
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private ArrayList<Sinistro> listaSinistros;
    
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento, ArrayList<Sinistro> listaSinistros) 
    {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = listaSinistros;
    }
    
    public String getCpf() 
    {
        return cpf;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getTelefone() 
    {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public String getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public LocalDate getDataNascimento() 
    {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() 
    {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) 
    {
        this.listaSinistros = listaSinistros;
    }

    public void adicionarSinistro(Sinistro sinistro)
    {
        listaSinistros.add(sinistro);
    }

    public boolean excluirSinistro(int id)
    {   
        if (listaSinistros.isEmpty())
        {
            System.out.println("ERRO: Não há sinistros registrados");
            return false;
        }

        for (Sinistro sinistro: listaSinistros)
        {
            if (sinistro.getId() == id)
            {
                listaSinistros.remove(sinistro);
                System.out.println("Sinistro " + sinistro.getId() + " removido");
                return true;
            }
        }

        System.out.println("ERRO: Não há sinistro com este id cadastrado");
        return false;
    }
}