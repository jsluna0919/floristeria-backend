package co.floristeria.usecase.cliente;

import co.floristeria.model.cliente.Cliente;
import co.floristeria.model.cliente.gateways.ClienteRepository;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor

public class ClienteUseCase {

    private final ClienteRepository repository;

    public Cliente crearCliente(Cliente cliente) {

        var CrearCliente = Cliente.builder()
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .ciudad(cliente.getCiudad())
                .direccion(cliente.getDireccion())
                .fechaCreacion(LocalDateTime.now())
                .build();

        return repository.save(CrearCliente);
    }

    public Cliente modificarCliente(Long id, Cliente cliente) {

        var clienteExistente = repository.clienteFindById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        for(Field field : Cliente.class.getDeclaredFields()){
            field.setAccessible(true);
            try {
                Object nuevoValor = field.get(cliente);
                if(nuevoValor != null){
                    field.set(clienteExistente, nuevoValor);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error actualizando cliente", e);
            }
        }
        clienteExistente.setFechaModificacion(LocalDateTime.now());
        return  repository.save(clienteExistente);

    }

    public void deleteById(Long id) {
       var cliente = repository.clienteFindById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
         repository.deleteById(id);
    }

    public void deleteByDocumento(String tipoDocumento, String numeroDocumento) {
        var cliente = repository.findByDocumento(tipoDocumento, numeroDocumento)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        repository.deleteByDocumento(tipoDocumento, numeroDocumento);
    }

    public List<Cliente> findAll() {
        var clientes = repository.clienteFindAll();
        if(clientes.isEmpty()){
            throw new RuntimeException("No se encontraron clientes");
        }
        return clientes;
    }

    public Cliente findById(Long id) {
        return repository.clienteFindById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }


}