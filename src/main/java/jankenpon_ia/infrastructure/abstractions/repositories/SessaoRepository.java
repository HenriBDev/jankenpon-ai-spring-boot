package jankenpon_ia.infrastructure.abstractions.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jankenpon_ia.domain.models.SessaoModel;

@Repository
public interface SessaoRepository extends MongoRepository<SessaoModel, UUID>
{
    
}
