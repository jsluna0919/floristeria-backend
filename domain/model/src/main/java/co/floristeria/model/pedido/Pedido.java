package co.floristeria.model.pedido;
import co.floristeria.model.arreglofloral.Arreglofloral;
import co.floristeria.model.cliente.Cliente;
import co.floristeria.model.destinatario.Destinatario;
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
public class Pedido {

    private Long id;
    private Cliente cliente;
    private Arreglofloral arreglofloral;
    private Destinatario destinatario;
    private String fechaEntrega;
    private EstadoPedido estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
