package co.floristeria.api.pedido;


import co.floristeria.api.arregloFloral.ArregloFloralDTO;
import co.floristeria.api.cliente.ClienteDTO;
import co.floristeria.api.destinatario.DestinatarioDTO;
import co.floristeria.model.pedido.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;
    private ClienteDTO cliente;
    private ArregloFloralDTO arreglo;
    private DestinatarioDTO destinatario;
    private String fechaEntrega;
    private EstadoPedido estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
