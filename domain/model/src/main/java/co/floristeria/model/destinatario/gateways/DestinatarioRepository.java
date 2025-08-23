package co.floristeria.model.destinatario.gateways;

import co.floristeria.model.destinatario.Destinatario;

import java.util.List;
import java.util.Optional;

public interface DestinatarioRepository {

    Optional<Destinatario> destinatarioFindById(Long id);
    Optional<Destinatario> findByNombreAndTelefono(String nombre, String telefono);
    List<Destinatario> destinatarioFindAll();
    Destinatario save(Destinatario destinatario);
    void deleteById(Long id);
    void deleteByNombreAndTelefono(String nombre, String telefono);
}
