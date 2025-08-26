package co.floristeria.api.pedido;


import co.floristeria.api.arregloFloral.ArregloFloralMapper;
import co.floristeria.api.cliente.ClienteMapper;
import co.floristeria.api.destinatario.DestinatarioMapper;
import co.floristeria.model.pedido.Pedido;

public class PedidoMapper {

    public static PedidoDTO toPedidoDTO(Pedido pedido) {
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

    public static Pedido toCrearPedido(PedidoDTO pedidoDTO) {
        return Pedido.builder()
                .cliente(ClienteMapper.toCliente(pedidoDTO.getCliente()))
                .arreglofloral(ArregloFloralMapper.toArreglofloral(pedidoDTO.getArreglo()))
                .destinatario(DestinatarioMapper.toDestinatario(pedidoDTO.getDestinatario()))
                .fechaEntrega(pedidoDTO.getFechaEntrega())
                .estado(pedidoDTO.getEstado())

                .build();
    }



}