import java.util.ArrayList;
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
        if (listaClientes.contains(cliente))
        {
            System.out.println("ERRO: Cliente já cadastrado!");
            return false;
        }
        else
        {
            System.out.println("Cadastro realizado");
            listaClientes.add(cliente);
            return true;
        }
    }

    public boolean removerCliente(String cliente)
    {

        if (listaClientes.isEmpty() == true)
        {
            System.out.println("Não há clientes para serem removidos");
            return false;
        }
        
        int tam = listaClientes.size();
        for (int i = 0; i < tam; i++)
        {
            if (listaClientes.get(i).getNome() == cliente)
            {
                System.out.println("Cliente" + cliente + " removido");
                listaClientes.remove(i);
                return true;
            }
        }

        return false;
    }

    public void listarClientes(String tipoCliente)
    {
        List<Cliente> lista = new ArrayList<>();

        for (Cliente cliente: this.listaClientes)
        {
            switch (tipoCliente)
            {
                case "f":
                if (cliente instanceof ClientePF)
                {
                    lista.add(cliente);
                }
                break;

                case "j":
                if (cliente instanceof ClientePJ)
                {
                    lista.add(cliente);
                }
                break;
            }
        }
    }

    public boolean gerarSinistro(Sinistro sinistro)
    {
        if (listaSinistros.contains(sinistro))
        {
            System.out.println("ERRO: Sinistro já registrado");
            return false;
        }
        else if (listaClientes.isEmpty() == true)
        {
            System.out.println("ERRO: Não há cliente cadastrado para gerar este sinistro");
            return false;
        }
        else
        {
            listaSinistros.add(sinistro);
            return true;
        }
    }

    public boolean visualizarSinistro(String cliente)
    {
        if (listaSinistros.isEmpty() == true || listaClientes.isEmpty() == true)
        {
            return false;
        }

        int tam = listaSinistros.size();
        for (int i = 0; i < tam; i++)
        {
            Sinistro sin = listaSinistros.get(i);
            
            if (sin.getCliente().getNome() == cliente)
            {
                System.out.println(sin);
                return true;
            }
        }

        System.out.print("ERRO: Cliente não encontrado");
        return false;
    }

    public void listarSinistros()
    {
        // Stub?????
    }
}