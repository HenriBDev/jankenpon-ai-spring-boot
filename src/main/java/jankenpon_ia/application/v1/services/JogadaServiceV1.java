package jankenpon_ia.application.v1.services;

import org.springframework.stereotype.Service;

import jankenpon_ia.application.abstractions.services.JogadaService;
import jankenpon_ia.domain.models.JogadaRequestModel;

@Service
public class JogadaServiceV1 implements JogadaService
{
    public void criarJogada(JogadaRequestModel jogada)
    {
        System.out.println(jogada.movimento);
    }
}
