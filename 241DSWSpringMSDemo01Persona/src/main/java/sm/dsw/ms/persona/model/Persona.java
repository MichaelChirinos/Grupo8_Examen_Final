package sm.dsw.ms.persona.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String documento;
    private String telefono;
}