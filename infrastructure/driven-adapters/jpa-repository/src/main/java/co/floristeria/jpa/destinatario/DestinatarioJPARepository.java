package co.floristeria.jpa.destinatario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface DestinatarioJPARepository extends CrudRepository<DestinatarioEntity, Long>, QueryByExampleExecutor<DestinatarioEntity> {

    Optional<DestinatarioEntity> findByNombreAndTelefono(String nombre, String telefono);
    void deleteByNombreAndTelefono(String nombre, String telefono);

}
