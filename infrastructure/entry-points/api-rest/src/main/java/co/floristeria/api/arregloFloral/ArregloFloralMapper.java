package co.floristeria.api.arregloFloral;

import co.floristeria.model.arreglofloral.Arreglofloral;

public class ArregloFloralMapper {

    public static ArregloFloralDTO toArregloFloralDTO (Arreglofloral arreglofloral) {
        if (arreglofloral == null) {
            return null;
        }
        return ArregloFloralDTO.builder()
                .id(arreglofloral.getId())
                .nombre(arreglofloral.getNombre())
                .descripcion(arreglofloral.getDescripcion())
                .anexos(arreglofloral.getAnexos())
                .precio(arreglofloral.getPrecio())
                .imagen(arreglofloral.getImagen())
                .mensaje(arreglofloral.getMensaje())
                .fechaCreacion(arreglofloral.getFechaCreacion())
                .fechaModificacion(arreglofloral.getFechaModificacion())
                .build();
    }
}