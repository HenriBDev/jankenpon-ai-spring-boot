package ai_jankenpon.application.v1.services;

import org.springframework.stereotype.Service;

import ai_jankenpon.application.abstractions.services.JogadaService;
import ai_jankenpon.domain.models.JogadaRequestModel;

@Service
public class JogadaServiceV1 implements JogadaService
{
    public void criarJogada(JogadaRequestModel jogada)
    {
        System.out.println(jogada.Movimento);
    }
}
