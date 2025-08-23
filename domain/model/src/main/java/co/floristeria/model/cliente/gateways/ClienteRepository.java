package co.floristeria.model.cliente.gateways;

import co.floristeria.model.cliente.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> clienteFindById(Long id);
    List<Cliente> clienteFindAll();
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    void deleteByDocumento(String tipoDocumento, String numeroDocumento);
    Optional<Cliente> findByDocumento(String tipoDocumento, String numeroDocumento);

}
