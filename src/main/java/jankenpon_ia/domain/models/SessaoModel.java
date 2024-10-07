package jankenpon_ia.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sessoesJogo")
public class SessaoModel 
{
    
    @Id
    public String id;

}
