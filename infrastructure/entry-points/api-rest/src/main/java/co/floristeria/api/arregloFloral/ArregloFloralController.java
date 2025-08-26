package co.floristeria.api.arregloFloral;

import co.floristeria.api.ApiResponse;
import co.floristeria.usecase.arreglofloral.ArreglofloralUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/arreglos-florales")
@AllArgsConstructor
class ArregloFloralController {

    private final ArreglofloralUseCase useCase;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getArregloFloral(@PathVariable("id") Long id) {
        try {
            var arregloFloral = useCase.findById(id);
            var dto = ArregloFloralMapper.toArregloFloralDTO(arregloFloral);
            return ResponseEntity.ok(new ApiResponse<>(true,"Arreglo floral encontrado",dto));
        } catch (Exception e) {
            return  ResponseEntity.ok(new ApiResponse<>(false,e.getMessage(),null));
        }
    }

}