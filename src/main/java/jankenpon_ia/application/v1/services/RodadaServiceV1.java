package jankenpon_ia.application.v1.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jankenpon_ia.application.abstractions.services.RodadaService;
import jankenpon_ia.common.EnumExtensions;
import jankenpon_ia.contracts.JsonResponse;
import jankenpon_ia.domain.enums.MovimentoEnum;
import jankenpon_ia.domain.enums.ResultadoRodadaEnum;
import jankenpon_ia.domain.models.RodadaRequestModel;
import jankenpon_ia.domain.models.RodadaResponseModel;

@Service
public class RodadaServiceV1 implements RodadaService
{
    public ResponseEntity<JsonResponse<RodadaResponseModel>> criarRodada(RodadaRequestModel RodadaJogador)
    {
        if(RodadaJogador == null)
            return new ResponseEntity<JsonResponse<RodadaResponseModel>>(
                new JsonResponse<RodadaResponseModel>("Os parãmetros da rodada não podem ser nulos"), 
                HttpStatus.BAD_REQUEST
            );

        var movimentoCPU = EnumExtensions.getRandomEnum(MovimentoEnum.class);

        var response = new JsonResponse<RodadaResponseModel>(new RodadaResponseModel(
            calcularResultadoRodada(RodadaJogador.getMovimento(), movimentoCPU), movimentoCPU
        ));

        return new ResponseEntity<JsonResponse<RodadaResponseModel>>(response, HttpStatus.OK);
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
