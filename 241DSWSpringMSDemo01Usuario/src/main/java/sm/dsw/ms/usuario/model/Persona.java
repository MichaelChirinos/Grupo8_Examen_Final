package sm.dsw.ms.usuario.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private Long id_persona;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String documento;
    private String telefono;
}
