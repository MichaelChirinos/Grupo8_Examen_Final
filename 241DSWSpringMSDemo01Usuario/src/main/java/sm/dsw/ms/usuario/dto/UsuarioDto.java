package sm.dsw.ms.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sm.dsw.ms.usuario.model.Persona;
import sm.dsw.ms.usuario.model.Usuario;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
    private Usuario usuario;
    private Persona persona;
}
