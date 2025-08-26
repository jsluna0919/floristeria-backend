package co.floristeria.api.arregloFloral;

import co.floristeria.model.arreglofloral.Arreglofloral;

import java.util.List;

public class ArregloFloralMapper {

    public static Arreglofloral toArreglofloral(ArregloFloralDTO dto) {

        return Arreglofloral.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .anexos(dto.getAnexos())
                .precio(dto.getPrecio())
                .imagen(dto.getImagen())
                .mensaje(dto.getMensaje())
                .fechaCreacion(dto.getFechaCreacion())
                .fechaModificacion(dto.getFechaModificacion())
                .build();
    }

    public static ArregloFloralDTO toArregloFloralDTO (Arreglofloral arreglofloral) {

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

    public static List<ArregloFloralDTO> arregloFloralDTOList (List<Arreglofloral> arreglofloral) {

        return arreglofloral.stream()
                .map(a -> ArregloFloralDTO.builder()
                        .id(a.getId())
                        .nombre(a.getNombre())
                        .descripcion(a.getDescripcion())
                        .anexos(a.getAnexos())
                        .precio(a.getPrecio())
                        .imagen(a.getImagen())
                        .mensaje(a.getMensaje())
                        .fechaCreacion(a.getFechaCreacion())
                        .fechaModificacion(a.getFechaModificacion())

                        .build()).toList();
    }
}