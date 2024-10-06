package jankenpon_ia.contracts;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse<T> 
{
    public String mensagem;
    public T dados;

    public JsonResponse(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public JsonResponse(String mensagem, T dados)
    {
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public JsonResponse(T dados)
    {
        this.dados = dados;
    }
}
