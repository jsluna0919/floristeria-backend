package co.floristeria.api.arregloFloral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
