package sm.dsw.ms.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sm.dsw.ms.usuario.model.Persona;

@Service
public class PersonaService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public Persona getPersonaById(Long id_persona) {
        return restTemplate().getForObject("http://localhost:8081/api/persona/search/" + id_persona, Persona.class);
    }
}
