package sm.dsw.ms.persona.service;

import java.util.List;
import sm.dsw.ms.persona.model.Persona;

public interface IPersonaService {
    
    List<Persona> findAll();
    Persona findById(Long id_persona);
    void save(Persona persona);
    void update(Persona persona);
    void deleteById(Long id_persona);
}
