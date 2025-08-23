package co.floristeria.jpa.destinatario;

import co.floristeria.jpa.helper.AdapterOperations;
import co.floristeria.model.destinatario.Destinatario;
import co.floristeria.model.destinatario.gateways.DestinatarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DestinatarioJPARepositoryAdapter extends AdapterOperations<Destinatario, DestinatarioEntity, Long, DestinatarioJPARepository>
implements DestinatarioRepository
{

    public DestinatarioJPARepositoryAdapter(DestinatarioJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Destinatario.class));
    }

    @Override
    public Optional<Destinatario> destinatarioFindById(Long id) {
        return this.repository.findById(id).map(this::toEntity);
    }

    @Override
    public Optional<Destinatario> findByNombreAndTelefono(String nombre, String telefono) {
        return this.repository.findByNombreAndTelefono(nombre, telefono).map(this::toEntity);
    }

    @Override
    public List<Destinatario> destinatarioFindAll() {
       List<DestinatarioEntity> destinatarios = (List<DestinatarioEntity>) this.repository.findAll();
         return destinatarios.stream()
                 .map(this::toEntity)
                 .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void deleteByNombreAndTelefono(String nombre, String telefono) {
        this.repository.deleteByNombreAndTelefono(nombre, telefono);

    }
}
