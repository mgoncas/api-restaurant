package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.restaurant.apirestaurant.dtos.BebidaDTO;
import prueba.restaurant.apirestaurant.services.BebidaService;

import java.util.List;

@RestController
@RequestMapping("/api/bebida")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @GetMapping
    public ResponseEntity<List<BebidaDTO>> getBebidas(){
        List<BebidaDTO> bebidas = bebidaService.findAll();
        if (bebidas !=null && !bebidas.isEmpty()){
            return ResponseEntity.ok(bebidas);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BebidaDTO> getBebida(@PathVariable Long id){
        BebidaDTO bebidaDTO = bebidaService.findById(id);
        if (bebidaDTO != null){
            return ResponseEntity.ok(bebidaDTO);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BebidaDTO> postBebida (@RequestBody BebidaDTO nuevaBebida){
        BebidaDTO nuevoBebidaDTO = bebidaService.save(nuevaBebida);
        if (nuevoBebidaDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoBebidaDTO);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BebidaDTO> putBebida (@PathVariable Long id, @RequestBody BebidaDTO cambioBebida){
        if (!cambioBebida.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        BebidaDTO bebidaDTO = bebidaService.findById(id);
        if (bebidaDTO == null){
            return ResponseEntity.noContent().build();
        }
        bebidaService.save(cambioBebida);
        return ResponseEntity.ok(cambioBebida);
    }
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BebidaDTO> deleteBebida(@PathVariable Long id){
        bebidaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
