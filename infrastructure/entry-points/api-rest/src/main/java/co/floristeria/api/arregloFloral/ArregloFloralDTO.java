package co.floristeria.api.arregloFloral;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ArregloFloralDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String anexos;
    private BigDecimal precio;
    private String imagen;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
