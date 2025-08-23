package co.floristeria.usecase.destinatario;

import co.floristeria.model.destinatario.Destinatario;
import co.floristeria.model.destinatario.gateways.DestinatarioRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DestinatarioUseCase {
    private final DestinatarioRepository repository;

    public Destinatario crearDestinatario(Destinatario destinatario) {

        var crearDestinatario = Destinatario.builder()
                .nombre(destinatario.getNombre())
                .telfono(destinatario.getTelfono())
                .ciudad(destinatario.getCiudad())
                .direccion(destinatario.getDireccion())
                .fechaCreacion(LocalDateTime.now())
                .build();
        return  repository.save(crearDestinatario);
    }

    public Destinatario modificarDestinatario(Long id, Destinatario destinatario) {
        var destinatarioExistente = repository.destinatarioFindById(destinatario.getId())
                .orElseThrow(() -> new RuntimeException("Destinatario no encontrado"));

        Optional.ofNullable(destinatario.getNombre())
                .filter(nombre -> !nombre.equals(destinatarioExistente.getNombre()))
                .ifPresent(destinatarioExistente::setNombre);

        Optional.ofNullable(destinatario.getTelfono())
                .filter(telefono -> !telefono.equals(destinatarioExistente.getTelfono()))
                .ifPresent(destinatarioExistente::setTelfono);

        Optional.ofNullable(destinatario.getCiudad())
                .filter(ciudad -> !ciudad.equals(destinatarioExistente.getCiudad()))
                .ifPresent(destinatarioExistente::setCiudad);

        Optional.ofNullable(destinatario.getDireccion())
                .filter(direccion -> !direccion.equals(destinatarioExistente.getDireccion()))
                .ifPresent(destinatarioExistente::setDireccion);

        destinatarioExistente.setFechaModificacion(LocalDateTime.now());

        return repository.save(destinatarioExistente);
    }

    public void deleteById(Long id) {
       var destinatario = repository.destinatarioFindById(id)
                .orElseThrow(() -> new RuntimeException("Destinatario no encontrado"));
         repository.deleteById(id);
    }

    public void deleteByNombreAndTelefono(String nombre, String telefono) {
       var destinatario = repository.findByNombreAndTelefono(nombre, telefono)
                .orElseThrow(() -> new RuntimeException("Destinatario no encontrado"));
         repository.deleteByNombreAndTelefono(nombre, telefono);
    }

    public List<Destinatario> findAll() {
        var destinatarios = repository.destinatarioFindAll();
        if(destinatarios.isEmpty()){
            throw new RuntimeException("No hay destinatarios registrados");
        }
        return destinatarios;
    }

    public Destinatario findById(Long id) {
        return repository.destinatarioFindById(id)
                .orElseThrow(() -> new RuntimeException("Destinatario no encontrado"));
    }
}
