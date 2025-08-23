package co.floristeria.model.usuario.gateways;

import co.floristeria.model.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    void deleteByEmail(String email);
    void deleteById(Long id);
}
