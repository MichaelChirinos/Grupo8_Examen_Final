package sm.dsw.ms.persona.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dsw.ms.persona.model.Persona;
import sm.dsw.ms.persona.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona findById(Long id_persona) {
        return personaRepository.findById(id_persona).orElseThrow();
    }

    @Override
    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void update(Persona persona) {
        if(personaRepository.existsById(persona.getId_persona())) {
            personaRepository.save(persona);
        } else {
            throw new RuntimeException("Persona not found");
        }
    }

    @Override
    public void deleteById(Long id_persona) {
        personaRepository.deleteById(id_persona);
    }
}
