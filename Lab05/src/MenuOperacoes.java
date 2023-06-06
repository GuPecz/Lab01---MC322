public enum MenuOperacoes 
{
	CADASTRAR("Cadastrar", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.CADASTRAR_CLIENTE,
			SubmenuOperacoes.CADASTRAR_VEICULO_PF,
			SubmenuOperacoes.CADASTRAR_FROTA,
			SubmenuOperacoes.CADASTRAR_VEICULO_FROTA,
			SubmenuOperacoes.CADASTRAR_SEGURADORA,
			SubmenuOperacoes.VOLTAR
	}),
	LISTAR("Listar", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.LISTAR_SEGUROS_POR_SEGURADORA,
			SubmenuOperacoes.LISTAR_CLIENTES_POR_SEGURADORA,
			SubmenuOperacoes.LISTAR_SEGUROS_POR_CLIENTE,
			SubmenuOperacoes.LISTAR_CONDUTOR_POR_SEGURO,
			SubmenuOperacoes.LISTAR_SINISTROS_POR_SEGURO,
			SubmenuOperacoes.LISTAR_SINISTROS_POR_CONDUTOR,
			SubmenuOperacoes.LISTAR_VEICULOS_POR_PF,
			SubmenuOperacoes.LISTAR_FROTAS_POR_PJ,
			SubmenuOperacoes.LISTAR_VEICULOS_POR_FROTA,
			SubmenuOperacoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.EXCLUIR_CLIENTE,
			SubmenuOperacoes.EXCLUIR_VEICULO_PF,
			SubmenuOperacoes.EXCLUIR_VEICULO_FROTA,
			SubmenuOperacoes.EXCLUIR_FROTA,
			SubmenuOperacoes.VOLTAR
	}),
	GERAR_SINISTRO("Gerar Sinistro", new SubmenuOperacoes[] 
	{
			SubmenuOperacoes.GERAR_SINISTRO_POR_CLIENTE,
			SubmenuOperacoes.GERAR_SINISTRO_POR_CONDUTOR,
			SubmenuOperacoes.VOLTAR
	}),
	SEGURO("Seguro", new SubmenuOperacoes[]
	{
			SubmenuOperacoes.GERAR_SEGURO,
			SubmenuOperacoes.CANCELAR_SEGURO,
			SubmenuOperacoes.AUTORIZAR_CONDUTOR,
			SubmenuOperacoes.DESAUTORIZAR_CONDUTOR,
			SubmenuOperacoes.VOLTAR
	}),
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