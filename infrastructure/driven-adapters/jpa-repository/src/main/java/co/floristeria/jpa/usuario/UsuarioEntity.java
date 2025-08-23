package co.floristeria.jpa.usuario;

import co.floristeria.model.usuario.RolUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private RolUsuario rol;
    private Boolean estado;
    private LocalDateTime ultimaConexion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
