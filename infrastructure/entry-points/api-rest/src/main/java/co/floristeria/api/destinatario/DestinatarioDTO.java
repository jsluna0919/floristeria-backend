package co.floristeria.api.destinatario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinatarioDTO {

    private Long id;
    private String nombre;
    private String telfono;
    private String ciudad;
    private String direccion;
}
