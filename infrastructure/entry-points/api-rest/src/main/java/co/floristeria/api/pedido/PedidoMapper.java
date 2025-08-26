package co.floristeria.api.pedido;


import co.floristeria.api.arregloFloral.ArregloFloralMapper;
import co.floristeria.api.cliente.ClienteMapper;
import co.floristeria.api.destinatario.DestinatarioMapper;
import co.floristeria.model.pedido.Pedido;

public class PedidoMapper {

    public static PedidoDTO pedidoDTO(Pedido pedido) {
        return PedidoDTO.builder()
                .id(pedido.getId())
                .cliente(ClienteMapper.toClienteDTO(pedido.getCliente()))
                .arreglo(ArregloFloralMapper.toArregloFloralDTO(pedido.getArreglofloral()))
                .destinatario(DestinatarioMapper.toDestinatarioDTO(pedido.getDestinatario()))
                .fechaEntrega(pedido.getFechaEntrega())
                .estado(pedido.getEstado())
                .fechaCreacion(pedido.getFechaCreacion())
                .fechaModificacion(pedido.getFechaModificacion())
                .build();
    }



}