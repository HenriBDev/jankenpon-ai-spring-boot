package jankenpon_ia.application.abstractions.services;

import org.springframework.http.ResponseEntity;

import jankenpon_ia.contracts.JsonResponse;
import jankenpon_ia.domain.models.RodadaRequestModel;
import jankenpon_ia.domain.models.RodadaResponseModel;

public interface RodadaService 
{
    ResponseEntity<JsonResponse<RodadaResponseModel>> criarRodada(RodadaRequestModel Rodada);
}
