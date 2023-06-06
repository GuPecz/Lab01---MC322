public enum SubmenuOperacoes 
{
	CADASTRAR_CLIENTE("Cliente"),
	CADASTRAR_VEICULO_PF("Veículo em um cliente PF"),
	CADASTRAR_FROTA("Frota"),
	CADASTRAR_VEICULO_FROTA("Veículo em uma frota"),
	CADASTRAR_SEGURADORA("Seguradora"),
	LISTAR_SEGUROS_POR_SEGURADORA("Seguros por seguradora"),
	LISTAR_CLIENTES_POR_SEGURADORA("Clientes por seguradora"),
	LISTAR_SEGUROS_POR_CLIENTE("Seguros por cliente"),
	LISTAR_CONDUTOR_POR_SEGURO("Condutor por seguro"),
	LISTAR_SINISTROS_POR_SEGURO("Sinistros por seguro"),
	LISTAR_SINISTROS_POR_CONDUTOR("Sinistros por condutor"),
	LISTAR_VEICULOS_POR_PF("Veículos por cliente PF"),
	LISTAR_FROTAS_POR_PJ("Frotas por cliente PJ"),
	LISTAR_VEICULOS_POR_FROTA("Veículos por frota"),
	EXCLUIR_CLIENTE("Cliente"),
	EXCLUIR_VEICULO_PF("Veículo em um cliente PF"),
	EXCLUIR_VEICULO_FROTA("Veículo em uma frota"),
	EXCLUIR_FROTA("Frota"),
	GERAR_SINISTRO_POR_CLIENTE("Por cliente"),
	GERAR_SINISTRO_POR_CONDUTOR("Por condutor"),
	GERAR_SEGURO("Gerar"),
	CANCELAR_SEGURO("Cancelar"),
	AUTORIZAR_CONDUTOR("Autorizar condutor"),
	DESAUTORIZAR_CONDUTOR("Desautorizar condutor"),
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