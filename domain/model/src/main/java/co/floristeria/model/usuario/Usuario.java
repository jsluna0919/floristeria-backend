package co.floristeria.model.usuario;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private RolUsuario rol;
    private Boolean estado;
    private LocalDateTime ultimaConexion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
