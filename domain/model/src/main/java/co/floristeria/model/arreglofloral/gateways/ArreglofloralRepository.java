package co.floristeria.model.arreglofloral.gateways;

import co.floristeria.model.arreglofloral.Arreglofloral;

import java.util.List;
import java.util.Optional;

public interface ArreglofloralRepository {

    Optional<Arreglofloral> arregloFloralFindById(Long id);
    List<Arreglofloral> arregloFloralFindAll();
    Arreglofloral save(Arreglofloral arreglofloral);
    void deleteById(Long id);
}
