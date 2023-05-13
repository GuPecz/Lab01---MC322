public enum MenuOperacoes 
{
    PRINCIPAL(0),
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    SAIR(-1);

    public final int operacao;
    public final int subOperacao;
    
    MenuOperacoes(int operacao)
    {
        this.operacao = operacao;
        this.subOperacao = 0;
    }

    public int getOperacao()
    {
        return this.operacao;
    }
    
    public void menuPrincipal()
    {
        System.out.println("Menu principal:");
        System.out.println("1 - Cadastrar\n2 - Listar\n3 - Excluir\n4 - Gerar sinistro\n5 - Transferir seguro\n6 - Calcular receita da seguradora");
    }
    
    private void menuCadastrar()
    {
        System.out.println("Cadastrar:");
        System.out.println("1 - Cliente PF/PJ\n2 - Veículo\n3 - Seguradora");
        System.out.println("4 - Voltar");
    }

    private void menuListar()
    {
        System.out.println("Listar:");
        System.out.println("1 - Cliente (PF/PJ) por seguradora\n2 - Sinistros por seguradora\n3 - Sinistros por cliente\n4 - Veículo por cliente\n5 - Veículo por seguradora");
        System.out.println("6 - Voltar");
    }

    private void menuExcluir()
    {
        System.out.println("Excluir:");
        System.out.println("1 - Cliente\n2 - Veículo\n3 - Sinistro");
        System.out.println("4 - Voltar");
    }

    public void operacoes()
    {
        switch(operacao)
        {
            case 0:
            menuPrincipal();
            break;

            case 1:
            menuCadastrar();
            break;

            case 2:
            menuListar();
            break;

            case 3:
            menuExcluir();
            break;

            case -1:
            System.out.println("Obrigado por utilizar nossos serviços!");
            break;
        }
    }
}