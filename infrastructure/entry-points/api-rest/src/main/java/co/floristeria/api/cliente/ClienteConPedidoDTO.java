package co.floristeria.api.cliente;

import co.floristeria.api.pedido.PedidoResumenDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteConPedidoDTO {

    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String ciudad;
    private String direccion;
    private List<PedidoResumenDTO> pedidos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
