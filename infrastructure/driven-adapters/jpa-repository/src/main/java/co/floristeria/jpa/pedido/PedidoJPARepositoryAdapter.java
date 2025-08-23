package co.floristeria.jpa.pedido;

import co.floristeria.jpa.helper.AdapterOperations;
import co.floristeria.model.pedido.Pedido;
import co.floristeria.model.pedido.gateways.PedidoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PedidoJPARepositoryAdapter extends AdapterOperations<Pedido, PedidoEntity, Long, PedidoJPARepository>
implements PedidoRepository
{

    public PedidoJPARepositoryAdapter(PedidoJPARepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Pedido.class));
    }

    @Override
    public Optional<Pedido> pedidoFindById(long id) {
        return this.repository.findById(id).map(this::toEntity);
    }

    @Override
    public List<Pedido> pedidoFindAll() {
        List<PedidoEntity> pedidos = (List<PedidoEntity>) this.repository.findAll();
        return pedidos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        this.repository.deleteById(id);

    }
}
