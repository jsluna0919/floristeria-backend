package co.floristeria.jpa.arreglofloral;


import co.floristeria.jpa.destinatario.DestinatarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface ArregloFloralJPARepository extends CrudRepository<ArregloFloralEntity, Long>,QueryByExampleExecutor<ArregloFloralEntity> {

}
