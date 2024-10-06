package jankenpon_ia.application.abstractions.services;

import jankenpon_ia.contracts.abstractions.responses.BaseResponse;
import jankenpon_ia.domain.models.RodadaRequestModel;

public interface RodadaService 
{
    BaseResponse criarRodada(RodadaRequestModel Rodada);
}
