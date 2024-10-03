package jankenpon_ia.api.controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jankenpon_ia.application.abstractions.services.JogadaService;
import jankenpon_ia.domain.models.JogadaRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Jogada", description = "Manutenção de jogadas de uma sessão")
@RequestMapping("api/v1/jogada")
public class JogadaController 
{
    @Autowired
    private JogadaService _service;

    @PostMapping
    @Operation(summary = "Inicializa jogada", description = "Instancia uma nova jogada e insere na base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogada realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Houve um erro no sistema")
    })
    public void criarJogada(
        @Parameter(description = "Informações da jogada realizada", required = true)
        @RequestBody(required = true) JogadaRequestModel jogada)
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
