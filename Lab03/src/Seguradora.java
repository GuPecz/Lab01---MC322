import java.util.List;

public class Seguradora
{
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros;
    private List<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco, List<Sinistro> listaSinistros, List<Cliente> listaClientes) 
    {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.listaClientes = listaClientes;
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
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEndereco()
    {
        return endereco;
    }
    
    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public List<Sinistro> getListaSinistros() 
    {
        return listaSinistros;
    }
    
    public void setListaSinistros(List<Sinistro> listaSinistros) 
    {
        this.listaSinistros = listaSinistros;
    }
    
    public List<Cliente> getListaClientes() 
    {
        return listaClientes;
    }
    
    public void setListaClientes(List<Cliente> listaClientes) 
    {
        this.listaClientes = listaClientes;
    }

    public boolean cadastrarCliente(Cliente cliente)
    {
        // Stub
        return true;
    }

    public boolean removerCliente(String cliente)
    {
        // Stub
        return true;
    }

    public List<Cliente> listarClientes(String tipoCliente)
    {
        // Stub
        return listaClientes;
    }

    public boolean gerarSinistro()
    {
        // Stub
        return true;
    }

    public boolean visualizarSinistro(String cliente)
    {
        // Stub
        return true;
    }

    public List<Sinistro> listarSinistros()
    {
        // Stub
        return listaSinistros;
    }
}