package sm.dsw.ms.usuario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dsw.ms.usuario.dto.UsuarioDto;
import sm.dsw.ms.usuario.model.Usuario;
import sm.dsw.ms.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaService personaService;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioDto findById(Long id_usuario) {
        Usuario usuario = usuarioRepository.findById(id_usuario).orElseThrow();
        return UsuarioDto
                .builder()
                .usuario(usuario)
                .persona(personaService.getPersonaById(usuario.getId_persona()))
                .build();
    }

    @Override
    public void save(Usuario usuario) {
        // Lógica para validar el id_persona antes de guardar
        // personaService.getPersonaById(usuario.getId_persona());
        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId_usuario())) {
            // Lógica para validar el id_persona antes de actualizar
            personaService.getPersonaById(usuario.getId_persona());
            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario not found");
        }
    }

    @Override
    public void deleteById(Long id_usuario) {
        usuarioRepository.deleteById(id_usuario);
    }
}
