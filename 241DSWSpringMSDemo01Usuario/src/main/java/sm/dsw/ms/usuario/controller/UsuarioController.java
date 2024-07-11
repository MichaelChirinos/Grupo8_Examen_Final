package sm.dsw.ms.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sm.dsw.ms.usuario.model.Usuario;
import sm.dsw.ms.usuario.service.IUsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }
    
    @GetMapping("/search/{id_usuario}")
    public ResponseEntity<?> findById(@PathVariable Long id_usuario) {
        return ResponseEntity.ok(usuarioService.findById(id_usuario));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.update(usuario);
            return new ResponseEntity<>("Usuario updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id_usuario}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id_usuario) {
        try {
            usuarioService.deleteById(id_usuario);
            return new ResponseEntity<>("Usuario deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
