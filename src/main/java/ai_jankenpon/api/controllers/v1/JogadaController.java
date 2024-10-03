package ai_jankenpon.api.controllers.v1;

import ai_jankenpon.application.abstractions.services.JogadaService;
import ai_jankenpon.domain.models.JogadaRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/jogada")
public class JogadaController 
{
    @Autowired
    private JogadaService _service;

    @PostMapping
    public void criarJogada(@RequestBody() JogadaRequestModel jogada)
    {
        try
        {
            _service.criarJogada(jogada);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
