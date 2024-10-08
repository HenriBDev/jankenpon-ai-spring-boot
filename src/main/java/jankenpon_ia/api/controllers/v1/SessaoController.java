package jankenpon_ia.api.controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jankenpon_ia.application.abstractions.services.SessaoService;
import jankenpon_ia.domain.models.RodadaRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Sessão", description = "Manutenção de uma sessão do jogo")
@RequestMapping("api/v1/sessao")
public class SessaoController 
{
    @Autowired
    private SessaoService _service;

    @PostMapping
    @Operation(summary = "Inicia sessão", description = "Instancia uma nova sessão e insere na base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sessão criada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Houve um erro no sistema")
    })
    public ResponseEntity<?> iniciarSessao()
    {
        try
        {
            var response = _service.iniciarSessao().toResponseEntity();
            return response;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    @RequestMapping("rodadas")
    @Operation(summary = "Executa rodada", description = "Instancia uma nova rodada e insere na base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rodada realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Informações sobre a rodada inválidas"),
            @ApiResponse(responseCode = "500", description = "Houve um erro no sistema")
    })
    public ResponseEntity<?> executarRodada(
        @Parameter(description = "Informações da rodada realizada", required = true)
        @RequestBody(required = true) RodadaRequestModel Rodada)
    {
        try
        {
            var response = _service.executarRodada(Rodada).toResponseEntity();
            return response;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
