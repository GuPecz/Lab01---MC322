public enum CalcSeguro 
{
    VALOR_BASE(10.0),
    FATOR_30_MENOS(1.25),
    FATOR_30_60(1.0),
    FATOR_60_MAIS(1.5);

    private final double valor;
    
    private CalcSeguro(double valor) 
    {
        this.valor = valor;
    }

    public double getValor() 
    {
        return valor;
    }
}