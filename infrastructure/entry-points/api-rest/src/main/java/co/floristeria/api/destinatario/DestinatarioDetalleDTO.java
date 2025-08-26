package co.floristeria.api.destinatario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinatarioDetalleDTO {

    private Long id;
    private String nombre;
    private String telfono;
    private String ciudad;
    private String direccion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
