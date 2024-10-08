package jankenpon_ia.application.v1.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jankenpon_ia.application.abstractions.services.SessaoService;
import jankenpon_ia.common.EnumExtensions;
import jankenpon_ia.contracts.abstractions.responses.BaseResponse;
import jankenpon_ia.contracts.responses.JsonResponse;
import jankenpon_ia.domain.enums.MovimentoEnum;
import jankenpon_ia.domain.enums.ResultadoRodadaEnum;
import jankenpon_ia.domain.models.RodadaModel;
import jankenpon_ia.domain.models.RodadaRequestModel;
import jankenpon_ia.domain.models.RodadaResponseModel;
import jankenpon_ia.domain.models.SessaoModel;
import jankenpon_ia.domain.models.SessaoResponseModel;
import jankenpon_ia.infrastructure.abstractions.repositories.SessaoRepository;

@Service
public class SessaoServiceV1 implements SessaoService
{
    @Autowired
    private SessaoRepository _repository;

    public BaseResponse executarRodada(RodadaRequestModel rodadaJogador)
    {
        if(rodadaJogador == null || rodadaJogador.getMovimento() == null)
            return new JsonResponse<RodadaResponseModel>(
                HttpStatus.BAD_REQUEST,
                "Os parãmetros da rodada não podem ser nulos"
            );

        var movimentoCPU = EnumExtensions.getRandomEnum(MovimentoEnum.class);
        var movimentoJogador = rodadaJogador.getMovimento();

        var resultadoRodada = calcularResultadoRodada(movimentoJogador, movimentoCPU);

        var rodada = new RodadaModel(UUID.randomUUID(), movimentoJogador, movimentoCPU, resultadoRodada);

        var sessao = _repository.findById(rodadaJogador.getSessaoId()).get();

        sessao.rodadas.add(rodada);

        _repository.save(sessao);

        var dadosResponse = new RodadaResponseModel(
            resultadoRodada, 
            movimentoCPU
        );

        return new JsonResponse<RodadaResponseModel>(HttpStatus.OK, dadosResponse);
    }

    public BaseResponse iniciarSessao()
    {
        var sessao = _repository.save(new SessaoModel());

        return new JsonResponse<SessaoResponseModel>(HttpStatus.CREATED, new SessaoResponseModel(sessao.id));
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
