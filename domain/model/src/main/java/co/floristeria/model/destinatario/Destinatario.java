package co.floristeria.model.destinatario;
import co.floristeria.model.pedido.Pedido;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
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
