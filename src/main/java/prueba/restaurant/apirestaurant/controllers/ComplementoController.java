package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.restaurant.apirestaurant.dtos.ComplementoDTO;
import prueba.restaurant.apirestaurant.services.ComplemetoService;

import java.util.List;

@RestController
@RequestMapping("/api/complemento")
public class ComplementoController {

    @Autowired
    private ComplemetoService complemetoService;

    @GetMapping
    public ResponseEntity<List<ComplementoDTO>> getComplementos(){
        List<ComplementoDTO> complementoDTOS = complemetoService.findAll();
        if (complementoDTOS != null && !complementoDTOS.isEmpty()){
            return ResponseEntity.ok(complementoDTOS);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplementoDTO> getComplemento(@PathVariable Long id){
        ComplementoDTO complementoDTO = complemetoService.findById(id);
        if (complementoDTO != null){
            return ResponseEntity.ok(complementoDTO);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ComplementoDTO> postComplemento (@RequestBody ComplementoDTO nuevoComplemento){
        ComplementoDTO complementoDTO = complemetoService.save(nuevoComplemento);
        if (complementoDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(complementoDTO);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ComplementoDTO> putComplemento (@PathVariable Long id, @RequestBody ComplementoDTO cambioComplemento){
        if (!cambioComplemento.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        ComplementoDTO complementoDTO = complemetoService.findById(id);
        if (complementoDTO == null){
            return ResponseEntity.noContent().build();
        }
        complemetoService.update(cambioComplemento);
        return ResponseEntity.ok(cambioComplemento);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ComplementoDTO> deleteComplemento (@PathVariable Long id){
        complemetoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
