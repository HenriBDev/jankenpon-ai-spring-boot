package jankenpon_ia.api.controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jankenpon_ia.application.abstractions.services.RodadaService;
import jankenpon_ia.contracts.JsonResponse;
import jankenpon_ia.domain.models.RodadaRequestModel;
import jankenpon_ia.domain.models.RodadaResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Rodada", description = "Manutenção de rodadas em uma sessão")
@RequestMapping("api/v1/rodada")
public class RodadaController 
{
    @Autowired
    private RodadaService _service;

    @PostMapping
    @Operation(summary = "Inicializa rodada", description = "Instancia uma nova Rodada e insere na base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rodada realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Houve um erro no sistema")
    })
    public ResponseEntity<JsonResponse<RodadaResponseModel>> criarRodada(
        @Parameter(description = "Informações da Rodada realizada", required = true)
        @RequestBody(required = true) RodadaRequestModel Rodada)
    {
        try
        {
            var response = _service.criarRodada(Rodada);
            return response;
        }
        catch(Exception e)
        {
            System.out.println("a");
            System.err.println(e.getMessage());
            return new ResponseEntity<JsonResponse<RodadaResponseModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
