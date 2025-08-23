package co.floristeria.jpa.pedido;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PedidoJPARepository extends CrudRepository<PedidoEntity, Long>, QueryByExampleExecutor<PedidoEntity> {
}
