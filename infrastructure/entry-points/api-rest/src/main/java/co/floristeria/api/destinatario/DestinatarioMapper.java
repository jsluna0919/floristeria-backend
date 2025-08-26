package co.floristeria.api.destinatario;

import co.floristeria.api.pedido.PedidoResumenDTO;
import co.floristeria.model.destinatario.Destinatario;
import co.floristeria.model.pedido.Pedido;

import java.util.List;


public class DestinatarioMapper {

    public static DestinatarioDTO toDestinatarioDTO(Destinatario destinatario) {
        return DestinatarioDTO.builder()
                .nombre(destinatario.getNombre())
                .telfono(destinatario.getTelfono())
                .ciudad(destinatario.getCiudad())
                .direccion(destinatario.getDireccion())
                .build();
    }
    public static DestinatarioDetalleDTO toDestinatarioDetalleDTO(Destinatario destinatario){
        return DestinatarioDetalleDTO.builder()
                .id(destinatario.getId())
                .nombre(destinatario.getNombre())
                .telfono(destinatario.getTelfono())
                .ciudad(destinatario.getCiudad())
                .direccion(destinatario.getDireccion())
                .fechaCreacion(destinatario.getFechaCreacion())
                .fechaModificacion(destinatario.getFechaModificacion())
                .build();
    }

    public static DestinatarioConPedidoDTO toDestinatarioConPedidoDTO(Destinatario destinatario){
        return DestinatarioConPedidoDTO.builder()
                .id(destinatario.getId())
                .nombre(destinatario.getNombre())
                .telfono(destinatario.getTelfono())
                .ciudad(destinatario.getCiudad())
                .direccion(destinatario.getDireccion())
                .pedidos(mapPedidos(destinatario.getPedidos()))
                .fechaCreacion(destinatario.getFechaCreacion())
                .fechaModificacion(destinatario.getFechaModificacion())
                .build();
    }

    private static List<PedidoResumenDTO> mapPedidos(List<Pedido> pedidos){
        if (pedidos == null) return List.of();
        return pedidos.stream()
                .map(pedido -> PedidoResumenDTO.builder()
                        .id(pedido.getId())
                        .fechaCreacion(pedido.getFechaCreacion())
                        .build())
                .toList();
    }

}