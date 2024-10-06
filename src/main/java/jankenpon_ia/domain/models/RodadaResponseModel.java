package jankenpon_ia.domain.models;

import jankenpon_ia.domain.enums.MovimentoEnum;
import jankenpon_ia.domain.enums.ResultadoRodadaEnum;

public class RodadaResponseModel 
{
    public ResultadoRodadaEnum resultadoRodada;
    public MovimentoEnum movimentoCPU;
    public RodadaResponseModel(ResultadoRodadaEnum resultadoRodada, MovimentoEnum movimentoCPU)
    {
        this.resultadoRodada = resultadoRodada;
        this.movimentoCPU = movimentoCPU;
    }
}
