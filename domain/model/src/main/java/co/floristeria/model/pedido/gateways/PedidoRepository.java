package co.floristeria.model.pedido.gateways;

import co.floristeria.model.pedido.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    Optional<Pedido> pedidoFindById(long id);
    List<Pedido> pedidoFindAll();
    Pedido save(Pedido pedido);
    void deleteById(long id);
}