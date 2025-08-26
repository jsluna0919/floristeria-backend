package co.floristeria.api.arregloFloral;

import co.floristeria.api.ApiResponse;
import co.floristeria.model.arreglofloral.Arreglofloral;
import co.floristeria.usecase.arreglofloral.ArreglofloralUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/listar")
    public ResponseEntity<?> getArregloFloraesl() {
        try {
            var arregloFloral = useCase.findAll();
            var dto =ArregloFloralMapper.arregloFloralDTOList(arregloFloral);
            return ResponseEntity.ok(new ApiResponse<>(true,"Arreglo florales",dto));
        }catch (Exception e){
            return  ResponseEntity.ok(new ApiResponse<>(false,e.getMessage(),null));
        }
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarArregloFloral(@PathVariable("id") Long id) {
        try {
            useCase.deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>(true,"Arreglo floral eliminado exitosamente",null));
        } catch (Exception e) {
            return  ResponseEntity.ok(new ApiResponse<>(false,e.getMessage(),null));
        }
    }

    @PutMapping(path = "/modificar/{id}")
    public ResponseEntity<?> modificarArregloFloral(
            @PathVariable("id") Long id
            , @RequestBody ArregloFloralDTO dto) {
        try {
            var entity = ArregloFloralMapper.toArreglofloral(dto);
            var arregloFloral = useCase.modificarArregloFloral(id,entity);
            return ResponseEntity.ok(new ApiResponse<>(true,"Arreglo floral modificado",arregloFloral));
        }catch (Exception e){
            return  ResponseEntity.ok(new ApiResponse<>(false,e.getMessage(),null));
        }
    }

}