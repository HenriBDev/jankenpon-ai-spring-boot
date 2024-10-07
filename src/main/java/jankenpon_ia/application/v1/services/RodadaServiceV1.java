package jankenpon_ia.application.v1.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jankenpon_ia.application.abstractions.services.RodadaService;
import jankenpon_ia.common.EnumExtensions;
import jankenpon_ia.contracts.abstractions.responses.BaseResponse;
import jankenpon_ia.contracts.responses.JsonResponse;
import jankenpon_ia.domain.enums.MovimentoEnum;
import jankenpon_ia.domain.enums.ResultadoRodadaEnum;
import jankenpon_ia.domain.models.RodadaRequestModel;
import jankenpon_ia.domain.models.RodadaResponseModel;

@Service
public class RodadaServiceV1 implements RodadaService
{
    public BaseResponse criarRodada(RodadaRequestModel RodadaJogador)
    {
        if(RodadaJogador == null || RodadaJogador.getMovimento() == null)
            return new JsonResponse<RodadaResponseModel>(
                HttpStatus.BAD_REQUEST,
                "Os parãmetros da rodada não podem ser nulos"
            );

        var movimentoCPU = EnumExtensions.getRandomEnum(MovimentoEnum.class);

        var dadosResponse = new RodadaResponseModel(
            calcularResultadoRodada(RodadaJogador.getMovimento(), movimentoCPU), 
            movimentoCPU
        );

        return new JsonResponse<RodadaResponseModel>(HttpStatus.OK, dadosResponse);
    }

    private ResultadoRodadaEnum calcularResultadoRodada(MovimentoEnum movimentoJogador, MovimentoEnum movimentoCPU)
    {
        if(movimentoJogador == movimentoCPU)
            return ResultadoRodadaEnum.EMPATOU;

        if(
            (movimentoJogador == MovimentoEnum.PEDRA && movimentoCPU == MovimentoEnum.TESOURA) ||
            (movimentoJogador == MovimentoEnum.PAPEL && movimentoCPU == MovimentoEnum.PEDRA) ||
            (movimentoJogador == MovimentoEnum.TESOURA && movimentoCPU == MovimentoEnum.PAPEL)
        )
            return ResultadoRodadaEnum.VENCEU;
        else
            return ResultadoRodadaEnum.PERDEU;
    }
}
