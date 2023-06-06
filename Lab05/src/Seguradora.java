import java.util.ArrayList;

public class Seguradora
{
    private final String cnpj;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;
    
    public Seguradora(String cnpj, String nome, String telefone, String endereco, String email, ArrayList<Cliente> listaClientes, ArrayList<Seguro> listaSeguros) 
    {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
    }
    
    public String getCnpj() 
    {
        return cnpj;
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
    
    public ArrayList<Cliente> getListaClientes() 
    {
        return listaClientes;
    }
    
    public void setListaClientes(ArrayList<Cliente> listaClientes) 
    {
        this.listaClientes = listaClientes;
    }
    
    public ArrayList<Seguro> getListaSeguros() 
    {
        return listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) 
    {
        this.listaSeguros = listaSeguros;
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

    public boolean excluirCliente(String documento)
    {
        if (listaClientes.isEmpty() == true)
        {
            System.out.println("ERRO: Não há clientes para serem removidos");
            return false;
        }
        else if (!Validacao.validarCPF(documento) && !Validacao.validarCNPJ(documento))
        {
            System.out.println("ERRO: Documento inválido");
            return false;
        }

        char tipoCliente;
        if (Validacao.validarCPF(documento))
            tipoCliente = 'f';
        else
            tipoCliente = 'j';

        for (Cliente cliente: listaClientes)
            switch (tipoCliente)
            {
                case 'f':
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

                case 'j':
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

        System.out.println("ERRO: Não há cliente com este documento cadastrado");
        return false;
    }

    public boolean gerarSeguro(Seguro seguro)
    {
        if (listaSeguros.contains(seguro))
        {
            System.out.println("ERRO: Seguro já registrado");
            return false;
        }
        else
        {
            listaSeguros.add(seguro);
            return true;
        }
    }

    public boolean cancelarSeguro(Seguro seguro)
    {
        if (!listaSeguros.contains(seguro))
        {
            System.out.println("ERRO: Seguro não registrado");
            return false;
        }
        else
        {
            listaSeguros.remove(seguro);
            return true;
        }
    }

    private ClientePF getClientePorCpf(String cpf)
    {
        for (Cliente cl: listaClientes)
        {
            if (cl instanceof ClientePF)
            {
                ClientePF cliente = (ClientePF)cl;

                if (cliente.getCpf().equals(cpf))
                    return cliente;
            }
        }

        System.out.println("ERRO: Não há cliente cadastrado com esse documento");
        return null;
    }

    private ClientePJ getClientePorCnpj(String cnpj)
    {
        for (Cliente cl: listaClientes)
        {
            if (cl instanceof ClientePJ)
            {
                ClientePJ cliente = (ClientePJ)cl;

                if (cliente.getCnpj().equals(cnpj))
                    return cliente;
            }
        }

        System.out.println("ERRO: Não há cliente cadastrado com esse documento");
        return null;
    }

    public ArrayList<Seguro> getSegurosPorCliente(String documento)
    {
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();

        if (!Validacao.validarCNPJ(documento) && !Validacao.validarCPF(documento))
        {
            System.out.println("ERRO: Documento inválido");
            return null;
        }

        if (Validacao.validarCNPJ(documento))
        {
            ClientePF clientePf = getClientePorCpf(documento);

            for (Seguro seguro: listaSeguros)
            if (seguro instanceof SeguroPF)
            {
                SeguroPF seguroPf = (SeguroPF)seguro;

                if (seguroPf.getCliente().equals(clientePf))
                    segurosCliente.add(seguroPf);
            }
        }
        else if (Validacao.validarCPF(documento))
        {
            ClientePJ clientePj = getClientePorCnpj(documento);

            for (Seguro seguro: listaSeguros)
                if (seguro instanceof SeguroPJ)
                {
                    SeguroPJ seguroPj = (SeguroPJ)seguro;
    
                    if (seguroPj.getCliente().equals(clientePj))
                        segurosCliente.add(seguroPj);
                }
        }

        return segurosCliente;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(String documento)
    {        
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();

        if (!Validacao.validarCNPJ(documento) && !Validacao.validarCPF(documento))
        {
            System.out.println("ERRO: Documento inválido");
            return null;
        }

        if (Validacao.validarCPF(documento))
        {
            ClientePF clientePf = getClientePorCpf(documento);

            for (Seguro seguro: listaSeguros)
            if (seguro instanceof SeguroPF)
            {
                SeguroPF seguroPf = (SeguroPF)seguro;

                if (seguroPf.getCliente().equals(clientePf))
                    sinistrosCliente.addAll(seguroPf.getListaSinistros());
            }
        }
        else if (Validacao.validarCNPJ(documento))
        {
            ClientePJ clientePj = getClientePorCnpj(documento);

            for (Seguro seguro: listaSeguros)
                if (seguro instanceof SeguroPJ)
                {
                    SeguroPJ seguroPj = (SeguroPJ)seguro;
    
                    if (seguroPj.getCliente().equals(clientePj))
                        sinistrosCliente.addAll(seguroPj.getListaSinistros());
                }
        }

        return sinistrosCliente;
    }

    public double calcularReceita()
    {
        double receita = 0.0;
        
        for (Seguro seguro: listaSeguros)
            receita += seguro.getValorMensal();
        
        return receita;
    }

    public void listarClientesPorSeguradora()
    {
        int tam = listaClientes.size();

        if (tam == 0)
            System.out.println("ERRO: Não há clientes cadastrados nesta seguradora");

        for (int i = 0; i < tam; i++)
        {
            Cliente cliente = listaClientes.get(i);
            System.out.print("Cliente " + (i + 1));
            
            if (cliente instanceof ClientePF)
                System.out.println(" (PF)");
            else
                System.out.println(" (PJ)");

            System.out.println(cliente);
        }
    }
    
    @Override
    public String toString()
    {
        return "Informações da seguradora" + "\nCNPJ: " + cnpj + "\nNome: " + nome
        + "\nTelefone: " + telefone + "\nEndereço: " + endereco + "E-mail: " + email
        + "Clientes: " + listaClientes + "Seguros: " + listaSeguros;
    }

    // Métodos de listagem
    /* 

    public boolean listarSinistrosPorCliente(String documento)
    {
        boolean listouSinistros = false;

        if (!Validacao.validarCPF(documento) && !Validacao.validarCNPJ(documento))
        {
            System.out.println("ERRO: Documento inválido");
            return false;
        }

        int i = 1;
        for (Sinistro sinistro: listaSinistros)
        {
            if (sinistro.getCliente() instanceof ClientePF)
            {
                ClientePF cliente = (ClientePF)sinistro.getCliente();
                if (cliente.getCpf().equals(documento))
                {
                    System.out.println("Sinistro " + (i + 1));
                    System.out.println(sinistro);
                    listouSinistros = true;
                    i++;
                }
            }
            else
            {
                ClientePJ cliente = (ClientePJ)sinistro.getCliente();
                if (cliente.getCnpj().equals(documento))
                {
                    System.out.println("Sinistro " + (i + 1));
                    System.out.println(sinistro);
                    listouSinistros = true;
                    i++;
                }
            }
        }

        if (!listouSinistros)
        {
            System.out.println("ERRO: Não há cliente com este documento cadastrado");
            return false;
        }
        else
            return true;
    }

    public void listarSinistrosPorSeguradora()
    {
        if (listaSinistros.isEmpty())
            System.out.println("ERRO: Não há sinistros registrados nesta seguradora");

        int i = 1;
        for (Sinistro sinistro: listaSinistros)
        {
            System.out.println("Sinistro " + (i + 1));
            System.out.println(sinistro);
            i++;
        }
    }

    public void listarVeiculosPorSeguradora()
    {
        boolean existemVeiculos = false;

        if (listaClientes.isEmpty())
            System.out.println("ERRO: Não há clientes cadastrados");

        for (Cliente cliente: listaClientes)
        {
            System.out.println("Veículos de " + cliente.getNome() + ": ");

            if (cliente.getListaVeiculos().isEmpty())
                System.out.println("Nenhum registrado");
            else
            {  
                existemVeiculos = true;
                int i = 1;
                for (Veiculo veiculo: cliente.getListaVeiculos())
                {
                    System.out.println("Veículo " + (i + 1));
                    System.out.println(veiculo);
                    i++;
                }
            }
        }

        if (!existemVeiculos)
            System.out.println("ERRO: Nenhum veículo registrado nesta seguradora");
        else;
    } 
    */
}