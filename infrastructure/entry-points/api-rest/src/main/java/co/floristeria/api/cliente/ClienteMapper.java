package co.floristeria.api.cliente;

import co.floristeria.api.pedido.PedidoResumenDTO;
import co.floristeria.model.cliente.Cliente;
import co.floristeria.model.pedido.Pedido;


import java.util.List;

public class ClienteMapper {

    public static Cliente toCliente (ClienteDTO dto) {
        return Cliente.builder()
                .tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .ciudad(dto.getCiudad())
                .direccion(dto.getDireccion())

                .build();
    }
    public static ClienteDTO toClienteDTO(Cliente cliente){
        return ClienteDTO.builder()
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .direccion(cliente.getDireccion())
                .build();
    }

    public static ClienteDetalleDTO toClienteDetalleDTO(Cliente cliente) {
        return ClienteDetalleDTO.builder()
                .id(cliente.getId())
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .direccion(cliente.getDireccion())
                .fechaCreacion(cliente.getFechaCreacion())
                .fechaModificacion(cliente.getFechaModificacion())
                .build();
    }

    public static ClienteConPedidoDTO toClienteConPedidoDTO(Cliente cliente) {
        return ClienteConPedidoDTO.builder()
                .id(cliente.getId())
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .direccion(cliente.getDireccion())
                .pedidos(mapPedidos(cliente.getPedidos()))
                .fechaCreacion(cliente.getFechaCreacion())
                .fechaModificacion(cliente.getFechaModificacion())
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
