package ai_jankenpon.application.abstractions.services;

import ai_jankenpon.domain.models.JogadaRequestModel;

public interface JogadaService 
{
    void criarJogada(JogadaRequestModel jogada);
}
