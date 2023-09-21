package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.restaurant.apirestaurant.dtos.PanDTO;
import prueba.restaurant.apirestaurant.services.PanService;

import java.util.List;

@RestController
@RequestMapping("/api/pan")
public class PanController {
    @Autowired
    private PanService panService;

    @GetMapping
    public ResponseEntity<List<PanDTO>> getPanes(){
        List<PanDTO> panes = panService.findAll();
        if(panes != null && !panes.isEmpty()){
            return ResponseEntity.ok(panes);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanDTO> getPan(@PathVariable Long id){
        PanDTO panDTO = panService.findById(id);
        if(panDTO !=null){
            return ResponseEntity.ok(panDTO);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<PanDTO> postPan(@RequestBody PanDTO nuevoPan){
        PanDTO nuevoPanDto = panService.save(nuevoPan);
        if (nuevoPanDto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPanDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PanDTO> putPan(@PathVariable Long id, @RequestBody PanDTO cambioPan){
        if(!cambioPan.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        PanDTO panDTO = panService.findById(id);
        if(panDTO == null){
            return ResponseEntity.noContent().build();
        }
        panService.update(cambioPan);
        return ResponseEntity.ok(cambioPan);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PanDTO> deletePan (@PathVariable Long id){
        panService.delete(id);
        return ResponseEntity.ok().build();
    }
}
