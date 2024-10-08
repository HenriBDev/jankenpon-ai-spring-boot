package jankenpon_ia.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sessoesJogo")
public class SessaoModel 
{
    @Id
    public UUID id = UUID.randomUUID();
    public List<RodadaModel> rodadas;

    public SessaoModel(UUID id, List<RodadaModel> rodadas)
    {
        if(id == null)
            this.id = UUID.randomUUID();
        else
            this.id = id;

        if(rodadas == null)
            this.rodadas = new ArrayList<RodadaModel>();
        else
            this.rodadas = rodadas;
    }
    public SessaoModel(UUID id)
    {
        if(id == null)
            this.id = UUID.randomUUID();
        else
            this.id = id;

        this.rodadas = new ArrayList<RodadaModel>();
    }
    public SessaoModel(List<RodadaModel> rodadas)
    {
        this.id = UUID.randomUUID();

        if(rodadas == null)
            this.rodadas = new ArrayList<RodadaModel>();
        else
            this.rodadas = rodadas;
    }
    public SessaoModel()
    {
        this.id = UUID.randomUUID();
        this.rodadas = new ArrayList<RodadaModel>();
    }
}
