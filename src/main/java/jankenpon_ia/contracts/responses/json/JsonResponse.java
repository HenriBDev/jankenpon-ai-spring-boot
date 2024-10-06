package jankenpon_ia.contracts.responses.json;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jankenpon_ia.contracts.abstractions.responses.BaseResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse<T> implements BaseResponse
{
    @JsonIgnore
    public HttpStatus statusCode;
    public String mensagem;
    public T dados;

    public JsonResponse(HttpStatus statusCode)
    {
        this.statusCode = statusCode;
    }

    public JsonResponse(HttpStatus statusCode, String mensagem)
    {
        this.statusCode = statusCode;
        this.mensagem = mensagem;
    }

    public JsonResponse(HttpStatus statusCode, String mensagem, T dados)
    {
        this.statusCode = statusCode;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public JsonResponse(HttpStatus statusCode, T dados)
    {
        this.statusCode = statusCode;
        this.dados = dados;
    }

    public ResponseEntity<?> toResponseEntity()
    {
        if(this.mensagem == null && this.dados == null)
            return new ResponseEntity<T>(statusCode);
        else
            return new ResponseEntity<JsonResponse<T>>(this, statusCode);
    }
}
