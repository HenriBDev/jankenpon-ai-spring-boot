package jankenpon_ia.application.abstractions.services;

import java.util.concurrent.CompletableFuture;

import jankenpon_ia.contracts.abstractions.responses.BaseResponse;
import jankenpon_ia.domain.models.RodadaRequestModel;

public interface SessaoService 
{
    CompletableFuture<BaseResponse> executarRodadaAsync(RodadaRequestModel Rodada);
    CompletableFuture<BaseResponse> iniciarSessaoAsync();
}
