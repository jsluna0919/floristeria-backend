package co.floristeria.usecase.pedido;

import co.floristeria.model.arreglofloral.Arreglofloral;
import co.floristeria.model.arreglofloral.gateways.ArreglofloralRepository;
import co.floristeria.model.cliente.Cliente;
import co.floristeria.model.cliente.gateways.ClienteRepository;
import co.floristeria.model.destinatario.Destinatario;
import co.floristeria.model.destinatario.gateways.DestinatarioRepository;
import co.floristeria.model.pedido.EstadoPedido;
import co.floristeria.model.pedido.Pedido;
import co.floristeria.model.pedido.gateways.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class PedidoUseCase {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ArreglofloralRepository arreglofloralRepository;
    private final DestinatarioRepository destinatarioRepository;

    public Pedido crearPedido(Pedido pedido){

        var cliente = clienteRepository.findByDocumento(
                pedido.getCliente().getTipoDocumento(),
                pedido.getCliente().getNumeroDocumento()
        ).orElseGet(()-> clienteRepository.save(
                Cliente.builder()
                        .tipoDocumento(pedido.getCliente().getTipoDocumento())
                        .numeroDocumento(pedido.getCliente().getNumeroDocumento())
                        .nombre(pedido.getCliente().getNombre())
                        .apellido(pedido.getCliente().getApellido())
                        .telefono(pedido.getCliente().getTelefono())
                        .email(pedido.getCliente().getEmail())
                        .ciudad(pedido.getCliente().getCiudad())
                        .direccion(pedido.getCliente().getDireccion())
                        .fechaCreacion(LocalDateTime.now())
                        .build()
        ));


        var arregloFloral = arreglofloralRepository.save(
                Arreglofloral.builder()
                        .nombre(pedido.getArreglofloral().getNombre())
                        .descripcion(pedido.getArreglofloral().getDescripcion())
                        .precio(pedido.getArreglofloral().getPrecio())
                        .anexos(pedido.getArreglofloral().getAnexos())
                        .imagen(pedido.getArreglofloral().getImagen())
                        .mensaje(pedido.getArreglofloral().getMensaje())
                        .fechaCreacion(LocalDateTime.now())
                        .build()
        );

        var destinatario = destinatarioRepository.save(
                Destinatario.builder()
                        .nombre(pedido.getDestinatario().getNombre())
                        .telfono(pedido.getDestinatario().getTelfono())
                        .ciudad(pedido.getDestinatario().getCiudad())
                        .direccion(pedido.getDestinatario().getDireccion())
                        .fechaCreacion(LocalDateTime.now())
                        .build()
        );

        var pedidoCompleto = pedidoRepository.save(
                Pedido.builder()
                        .cliente(cliente)
                        .arreglofloral(arregloFloral)
                        .destinatario(destinatario)
                        .fechaEntrega(pedido.getFechaEntrega())
                        .estado(EstadoPedido.PENDIENTE) // Estado por defecto
                        .fechaCreacion(LocalDateTime.now())
                        .build()
        );

        return pedidoRepository.save(pedidoCompleto);
    }

    public Pedido findById(Long id){
        return pedidoRepository.pedidoFindById(id)
                .orElseThrow(()-> new RuntimeException("Pedido no encontrado"));
    }

    public List<Pedido> findAll(){
        var pedidos = pedidoRepository.pedidoFindAll();
        if (pedidos.isEmpty()){
            throw new RuntimeException("No hay pedidos");
        }
        return pedidos;
    }

    public void deleteById(Long id){
        if (pedidoRepository.pedidoFindById(id).isEmpty()){
            throw new RuntimeException("Pedido no encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
