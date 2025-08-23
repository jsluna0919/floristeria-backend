package co.floristeria.jpa.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface ClienteJPARepository extends CrudRepository<ClienteEntity,Long>, QueryByExampleExecutor<ClienteEntity> {

    Optional<ClienteEntity> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
    void deleteByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);

}
