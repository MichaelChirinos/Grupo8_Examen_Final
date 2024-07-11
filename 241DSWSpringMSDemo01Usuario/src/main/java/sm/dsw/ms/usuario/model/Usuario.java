package sm.dsw.ms.usuario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id_usuario;
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false)
    private String contraseña;
    @Column(name = "id_persona")
    private Long id_persona;
}
