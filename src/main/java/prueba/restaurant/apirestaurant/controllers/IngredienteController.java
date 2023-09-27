package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.restaurant.apirestaurant.dtos.IngredienteDTO;
import prueba.restaurant.apirestaurant.services.IngredienteService;

import java.util.List;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {
   @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> getIngredientes(){
        List<IngredienteDTO> ingredientes = ingredienteService.findAll();
        if (ingredientes != null && !ingredientes.isEmpty()){
            return ResponseEntity.ok(ingredientes);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteDTO> getIngrediente(@PathVariable Long id){
        IngredienteDTO ingredienteDTO = ingredienteService.findById(id);
        if (ingredienteDTO !=null){
            return ResponseEntity.ok(ingredienteDTO);
        }else {
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<IngredienteDTO> postIngrediente (@RequestBody IngredienteDTO nuevoIngrediente){
        IngredienteDTO nuevoIngredienteDTO = ingredienteService.save(nuevoIngrediente);
        if (nuevoIngrediente != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoIngredienteDTO);
        }else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IngredienteDTO> putIngrediente(@PathVariable Long id, @RequestBody IngredienteDTO cambioIngrediente){
        if (!cambioIngrediente.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        IngredienteDTO ingredienteDTO = ingredienteService.findById(id);
        if (ingredienteDTO==null){
            return ResponseEntity.noContent().build();
        }
        ingredienteService.update(cambioIngrediente);
        return ResponseEntity.ok(cambioIngrediente);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IngredienteDTO> deleteIngrediente(@PathVariable Long id){
        ingredienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}

