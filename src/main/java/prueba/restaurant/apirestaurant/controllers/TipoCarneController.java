package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.restaurant.apirestaurant.dtos.TipoCarneDTO;
import prueba.restaurant.apirestaurant.services.TipoCarneService;

import java.util.List;

@RestController
@RequestMapping("/api/tipoCarne")
public class TipoCarneController {

    @Autowired
    private TipoCarneService tipoCarneService;

    @GetMapping
    public ResponseEntity<List<TipoCarneDTO>> getTiposCarne(){
        List<TipoCarneDTO> tiposCarne= tipoCarneService.findAll();
        if(tiposCarne != null && !tiposCarne.isEmpty()){
            return ResponseEntity.ok(tiposCarne);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping ("/{id}")
    public ResponseEntity<TipoCarneDTO> getTipoCarne(@PathVariable Long id){
        TipoCarneDTO tipoCarneDTO = tipoCarneService.findById(id);
        if(tipoCarneDTO !=null){
            return ResponseEntity.ok(tipoCarneDTO);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<TipoCarneDTO> postTipoCarne(@RequestBody TipoCarneDTO nuevoTipoCarne){
        TipoCarneDTO nuevoTipoCarneDTO = tipoCarneService.save(nuevoTipoCarne);
        if(nuevoTipoCarneDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipoCarneDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TipoCarneDTO> putTipoCarne (@PathVariable Long id, @RequestBody TipoCarneDTO cambioTipoCarne){
        if(!cambioTipoCarne.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        TipoCarneDTO tipoCarneDTO = tipoCarneService.findById(id);
        if(tipoCarneDTO==null){
            return ResponseEntity.noContent().build();
        }
        tipoCarneService.update(cambioTipoCarne);
        return ResponseEntity.ok(cambioTipoCarne);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TipoCarneDTO> deleteTipoCarne (@PathVariable Long id){
        tipoCarneService.delete(id);
        return ResponseEntity.ok().build();
    }
}
