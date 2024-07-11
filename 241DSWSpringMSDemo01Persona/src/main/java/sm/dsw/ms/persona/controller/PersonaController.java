package sm.dsw.ms.persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sm.dsw.ms.persona.model.Persona;
import sm.dsw.ms.persona.service.IPersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePersona(@RequestBody Persona persona){
        personaService.save(persona);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(personaService.findAll());
    }
    
    @GetMapping("/search/{id_persona}")
    public ResponseEntity<?> findById(@PathVariable Long id_persona){
        return ResponseEntity.ok(personaService.findById(id_persona));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePersona(@RequestBody Persona persona) {
        try {
            personaService.update(persona);
            return new ResponseEntity<>("Persona updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id_persona}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id_persona) {
        try {
            personaService.deleteById(id_persona);
            return new ResponseEntity<>("Persona deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
}
