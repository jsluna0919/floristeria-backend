package co.floristeria.api.destinatario;

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
public class DestinatarioConPedidoDTO {
    private Long id;
    private String nombre;
    private String telfono;
    private String ciudad;
    private String direccion;
    private List<PedidoResumenDTO> pedidos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
