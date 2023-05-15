public enum SubmenuOperacoes 
{
	CADASTRAR_CLIENTE("Cliente"),
	CADASTRAR_VEICULO("Veículo"),
	CADASTRAR_SEGURADORA("Seguradora"),
	LISTAR_CLIENTES_POR_SEGURADORA("Clientes por seguradora"),
	LISTAR_SINISTROS_POR_SEGURADORA("Sinistros por seguradora"),
	LISTAR_SINISTROS_POR_CLIENTE("Sinistros por cliente"),
	LISTAR_VEICULOS_POR_SEGURADORA("Veículos por seguradora"),
	LISTAR_VEICULOS_POR_CLIENTE("Veículos por cliente"),
	EXCLUIR_CLIENTE("Cliente"),
	EXCLUIR_VEICULO("Veículo"),
	EXCLUIR_SINISTRO("Sininstro"),
	VOLTAR("Voltar");
	
	private final String descricao;
	
	SubmenuOperacoes(String descricao)
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
}