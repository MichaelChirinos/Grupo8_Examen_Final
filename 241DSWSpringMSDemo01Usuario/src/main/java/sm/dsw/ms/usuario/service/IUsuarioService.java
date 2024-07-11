package sm.dsw.ms.usuario.service;

import java.util.List;

import sm.dsw.ms.usuario.dto.UsuarioDto;
import sm.dsw.ms.usuario.model.Usuario;

public interface IUsuarioService {
    List<Usuario> findAll();
    UsuarioDto findById(Long id_usuario);
    void save(Usuario usuario);
    void update(Usuario usuario);
    void deleteById(Long id_usuario);
}
