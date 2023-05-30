import java.util.List;

public class Seguradora
{
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Cliente> listaClientes;
    private List<Seguro> listaSeguros;
    
    public Seguradora(String nome, String telefone, String email, String endereco, List<Cliente> listaClientes, List<Seguro> listaSeguros) 
    {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
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
    
    public List<Cliente> getListaClientes() 
    {
        return listaClientes;
    }
    
    public void setListaClientes(List<Cliente> listaClientes) 
    {
        this.listaClientes = listaClientes;
    }
    
    public List<Seguro> getListaSeguros() 
    {
        return listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) 
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

    public boolean excluirSinistro(int id)
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

        for (Sinistro sinistro: listaSinistros)
        {
            if (sinistro.getId() == id)
            {
                listaSinistros.remove(sinistro);
                System.out.println("Sinistro " + sinistro.getId() + " removido");
                sinistro.getCliente().setValorSeguro(calcularPrecoSeguroCliente(sinistro.getCliente()));
                return true;
            }
        }

        System.out.println("ERRO: Não há sinistro com este id cadastrado");
        return false;
    }

    public boolean excluirVeiculo(String placa)
    {
        if (listaClientes.isEmpty())
        {
            System.out.println("ERRO: Não há clientes cadastrados");
            return false;
        }

        for (Cliente cliente: listaClientes)
        {
            if (cliente.excluirVeiculo(placa))
            {
                cliente.setValorSeguro(calcularPrecoSeguroCliente(cliente));
                return true;
            }
        }

        System.out.println("ERRO: Não há veículo com esta placa cadastrado");
        return false;
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

    public double calcularReceita()
    {
        double receita = 0.0;

        for (Cliente cliente: listaClientes)
            receita += calcularPrecoSeguroCliente(cliente);

        return receita;
    }
}