public enum MenuOperacoes 
{
	CADASTRAR("Cadastrar", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.CADASTRAR_CLIENTE,
			SubmenuOperacoes.CADASTRAR_VEICULO,
			SubmenuOperacoes.CADASTRAR_SEGURADORA,
			SubmenuOperacoes.VOLTAR
	}),
	LISTAR("Listar", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.LISTAR_CLIENTES_POR_SEGURADORA,
			SubmenuOperacoes.LISTAR_SINISTROS_POR_SEGURADORA,
			SubmenuOperacoes.LISTAR_SINISTROS_POR_CLIENTE,
			SubmenuOperacoes.LISTAR_VEICULOS_POR_SEGURADORA,
			SubmenuOperacoes.LISTAR_VEICULOS_POR_CLIENTE,
			SubmenuOperacoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.EXCLUIR_CLIENTE,
			SubmenuOperacoes.EXCLUIR_VEICULO,
			SubmenuOperacoes.EXCLUIR_SINISTRO,
			SubmenuOperacoes.VOLTAR}),
	GERAR_SINISTRO("Gerar Sinistro", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
	TRANSFERIR_SEGURO("Transferir Seguro", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
	CALCULAR_RECEITA("Calcular Receita", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
	SAIR("Sair", new SubmenuOperacoes[] {});
	
	private final String descricao;
	private final SubmenuOperacoes[] submenu;
	
	MenuOperacoes(String descricao, SubmenuOperacoes[] submenu)
	{
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
	
	public SubmenuOperacoes[] getSubmenu() 
	{
		return submenu;
	}
}
