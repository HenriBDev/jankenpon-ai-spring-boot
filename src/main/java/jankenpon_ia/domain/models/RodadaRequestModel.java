package jankenpon_ia.domain.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jankenpon_ia.domain.enums.MovimentoEnum;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RodadaRequestModel 
{
    private MovimentoEnum movimento;
    public MovimentoEnum getMovimento() 
    {
        return movimento;
    }
}
