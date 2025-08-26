package co.floristeria.api.pedido;

import co.floristeria.model.pedido.Pedido;
import co.floristeria.usecase.pedido.PedidoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
class PedidoController {
    private final PedidoUseCase useCase;

    @PostMapping(path = "/crear")
    public ResponseEntity<?> crearPedido(@RequestBody PedidoDTO pedido) {
        var entity = PedidoMapper.toCrearPedido(pedido);
        var crearPedido = useCase.crearPedido(entity);
        return ResponseEntity.ok(crearPedido);
    }
}
