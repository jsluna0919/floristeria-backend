package co.floristeria.jpa.cliente;

import co.floristeria.jpa.helper.AdapterOperations;
import co.floristeria.model.cliente.Cliente;
import co.floristeria.model.cliente.gateways.ClienteRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteJPARepositoryAdapter extends AdapterOperations<Cliente, ClienteEntity, Long, ClienteJPARepository>
implements ClienteRepository
{

    public ClienteJPARepositoryAdapter(ClienteJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cliente.class));
    }

    @Override
    public Optional<Cliente> clienteFindById(Long id) {
        return this.repository.findById(id).map(this::toEntity);
    }

    @Override
    public List<Cliente> clienteFindAll() {
        List<ClienteEntity> clientes = (List<ClienteEntity>) this.repository.findAll();
        return clientes.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }


    @Override
    public void deleteByDocumento(String tipoDocumento, String numeroDocumento) {
        this.repository.deleteByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);

    }

    @Override
    public Optional<Cliente> findByDocumento(String tipoDocumento, String numeroDocumento) {
        return this.repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento)
                .map(this::toEntity);
    }
}
