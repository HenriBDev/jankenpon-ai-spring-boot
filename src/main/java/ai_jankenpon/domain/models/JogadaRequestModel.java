package ai_jankenpon.domain.models;

import ai_jankenpon.domain.enums.MovimentoEnum;

public class JogadaRequestModel 
{
    public MovimentoEnum Movimento;
    public MovimentoEnum getMovimento() 
    {
        return Movimento;
    }
    public void setMovimento(MovimentoEnum movimento) 
    {
        Movimento = movimento;
    }
}
