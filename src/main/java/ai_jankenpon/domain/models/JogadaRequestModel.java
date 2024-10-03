package ai_jankenpon.domain.models;

import ai_jankenpon.domain.enums.MovimentoEnum;

public class JogadaRequestModel 
{
    public MovimentoEnum movimento;
    public MovimentoEnum getMovimento() 
    {
        return movimento;
    }
    public void setMovimento(MovimentoEnum movimento) 
    {
        this.movimento = movimento;
    }
}
