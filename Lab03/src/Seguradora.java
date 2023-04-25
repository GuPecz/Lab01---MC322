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

    public boolean removerCliente(String documento)
    {
        if (listaClientes.isEmpty() == true)
        {
            System.out.println("ERRO: Não há clientes para serem removidos");
            return false;
        }
        else if (!ClientePF.validarCPF(documento) && !ClientePJ.validarCNPJ(documento))
        {
            System.out.println("ERRO: Documento inválido");
            return false;
        }

        String tipoCliente;
        if (ClientePF.validarCPF(documento))
            tipoCliente = "f";
        else
            tipoCliente = "j";

        for (Cliente cliente: listaClientes)
        {
            switch (tipoCliente)
            {
                case "f":
                if (cliente instanceof ClientePF)
                {
                    ClientePF clientePF = (ClientePF)cliente;

                    if (clientePF.getCpf().equals(documento))
                    {
                        listaClientes.remove(clientePF);
                        System.out.println("Cliente " + clientePF.getNome() + " removido");
                        return true;
                    }
                }
                break;

                case "j":
                if (cliente instanceof ClientePJ)
                {
                    ClientePJ clientePJ = (ClientePJ)cliente;

                    if (clientePJ.getCnpj().equals(documento))
                    {
                        listaClientes.remove(clientePJ);
                        System.out.println("Cliente " + clientePJ.getNome() + " removido");
                        return true;
                    }
                }
            }
        }

        System.out.println("ERRO: Não há cliente com este documento cadastrado");
        return false;
    }

    public void listarClientes(String tipoCliente)
    {
        for (Cliente cliente: this.listaClientes)
        {
            switch (tipoCliente)
            {
                case "f":
                if (cliente instanceof ClientePF)
                {
                    System.out.println(cliente);
                }
                break;

                case "j":
                if (cliente instanceof ClientePJ)
                {
                    System.out.println(cliente);
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

    public boolean visualizarSinistro(String documento)
    {
        if (listaSinistros.isEmpty())
        {
            System.out.println("ERRO: Não há sinistros registrados");
            return false;
        }
        else if (listaClientes.isEmpty())
        {
            System.out.println("ERRO: Não há clientes cadastrados");
            return false;
        }
        else if (!ClientePF.validarCPF(documento) && !ClientePJ.validarCNPJ(documento))
        {
            System.out.println("ERRO: Documento inválido");
            return false;
        }

        for (Sinistro sinistro: listaSinistros)
        {
            if (sinistro.getCliente() instanceof ClientePF)
            {
                ClientePF cliente = (ClientePF)sinistro.getCliente();
                if (cliente.getCpf().equals(documento))
                    System.out.println(sinistro);

                return true;
            }
            else
            {
                ClientePJ cliente = (ClientePJ)sinistro.getCliente();
                if (cliente.getCnpj().equals(documento))
                    System.out.println(sinistro);

                return true;
            }
        }

        System.out.println("ERRO: Não há cliente com este documento cadastrado");
        return false;
    }

    public void listarSinistros()
    {
        for (Sinistro sinistro: listaSinistros)
        {
            System.out.println(sinistro);
        }
    }
}