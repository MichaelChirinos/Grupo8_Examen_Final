package sm.dsw.ms.persona.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import sm.dsw.ms.persona.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
 
}
