package co.floristeria.model.destinatario;
import co.floristeria.model.pedido.Pedido;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Destinatario {

    private Long id;
    private String nombre;
    private String telfono;
    private String ciudad;
    private String direccion;
    private List<Pedido> pedidos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
