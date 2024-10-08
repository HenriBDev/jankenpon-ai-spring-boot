package jankenpon_ia.domain.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jankenpon_ia.domain.enums.MovimentoEnum;
import lombok.Getter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
public class RodadaRequestModel 
{
    private UUID sessaoId;
    private MovimentoEnum movimento;
}
