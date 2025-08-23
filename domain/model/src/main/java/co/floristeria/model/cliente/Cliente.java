package co.floristeria.model.cliente;
import co.floristeria.model.pedido.Pedido;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cliente {

    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String ciudad;
    private String direccion;
    private List<Pedido> pedidos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
