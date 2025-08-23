package co.floristeria.usecase.arreglofloral;

import co.floristeria.model.arreglofloral.Arreglofloral;
import co.floristeria.model.arreglofloral.gateways.ArreglofloralRepository;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ArreglofloralUseCase {
    private final ArreglofloralRepository repository;

    public Arreglofloral crearArregloFloral(Arreglofloral arreglofloral) {

        var Creararreglofloral = Arreglofloral.builder()
                .nombre(arreglofloral.getNombre())
                .descripcion(arreglofloral.getDescripcion())
                .anexos(arreglofloral.getAnexos())
                .precio(arreglofloral.getPrecio())
                .imagen(arreglofloral.getImagen())
                .mensaje(arreglofloral.getMensaje())
                .fechaCreacion(LocalDateTime.now())
                .build();
        return repository.save(Creararreglofloral);
    }

    public Arreglofloral modificarArregloFloral(Long id, Arreglofloral arreglofloral) {
        var arregloFloralExistente = repository.arregloFloralFindById(id)
                .orElseThrow(() -> new RuntimeException("Arreglo floral no encontrado"));

        for(Field field : Arreglofloral.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object nuevoValor = field.get(arreglofloral);
                if(nuevoValor != null){
                    field.set(arregloFloralExistente, nuevoValor);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error actualizando arreglo floral", e);
            }
        }

        return repository.save(arregloFloralExistente);

    }

    public void deleteById(Long id) {
        var arregloFloral = repository.arregloFloralFindById(id)
                .orElseThrow(() -> new RuntimeException("Arreglo floral no encontrado"));
        repository.deleteById(arregloFloral.getId());
    }

    public List<Arreglofloral> findAll() {
        var arreglosFlorales = repository.arregloFloralFindAll();
        if (arreglosFlorales.isEmpty()) {
            throw new RuntimeException("No se encontraron arreglos florales");
        }
        return arreglosFlorales;
    }

    public Arreglofloral findById(Long id) {
        return repository.arregloFloralFindById(id)
                .orElseThrow(() -> new RuntimeException("Arreglo floral no encontrado"));
    }
}
