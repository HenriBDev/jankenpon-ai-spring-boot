package jankenpon_ia.domain.models;

import jankenpon_ia.domain.enums.MovimentoEnum;

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
