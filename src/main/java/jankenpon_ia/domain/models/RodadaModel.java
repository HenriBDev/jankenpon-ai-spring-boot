package jankenpon_ia.domain.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Data;

import jankenpon_ia.domain.enums.MovimentoEnum;
import jankenpon_ia.domain.enums.ResultadoRodadaEnum;

@Data
public class RodadaModel 
{
    @Id
    public UUID id = UUID.randomUUID();
    public MovimentoEnum movimentoJogador;
    public MovimentoEnum movimentoCPU;
    public ResultadoRodadaEnum resultadoRodada;

    public RodadaModel(UUID id, MovimentoEnum movimentoJogador, MovimentoEnum movimentoCPU, ResultadoRodadaEnum resultadoRodada)
    {
        if(id == null)
            this.id = UUID.randomUUID();
        else
            this.id = id;

        this.movimentoJogador = movimentoJogador;
        this.movimentoCPU = movimentoCPU;
        this.resultadoRodada = resultadoRodada;
    }
}
