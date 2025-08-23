package co.floristeria.jpa.arreglofloral;

import co.floristeria.jpa.helper.AdapterOperations;
import co.floristeria.model.arreglofloral.Arreglofloral;
import co.floristeria.model.arreglofloral.gateways.ArreglofloralRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ArregloFloralJPARepositoryAdapter extends AdapterOperations<Arreglofloral, ArregloFloralEntity, Long, ArregloFloralJPARepository>
implements ArreglofloralRepository
{

    public ArregloFloralJPARepositoryAdapter(ArregloFloralJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Arreglofloral.class));
    }

    @Override
    public Optional<Arreglofloral> arregloFloralFindById(Long id) {
        return this.repository.findById(id).map(this::toEntity);
    }

    @Override
    public List<Arreglofloral> arregloFloralFindAll() {
        List<ArregloFloralEntity> arregloFlorales = (List<ArregloFloralEntity>) this.repository.findAll();
        return arregloFlorales.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}