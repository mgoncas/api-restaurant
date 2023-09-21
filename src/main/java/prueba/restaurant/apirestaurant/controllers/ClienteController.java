package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.restaurant.apirestaurant.dtos.ClienteDTO;
import prueba.restaurant.apirestaurant.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping ("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getClientes(){
        List<ClienteDTO> clientes = clienteService.findAll();
        if(clientes != null && !clientes.isEmpty()){
            return ResponseEntity.ok(clientes);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id){
        ClienteDTO clienteDTO= clienteService.findById(id);
        if(clienteDTO !=null){
            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ClienteDTO> postCliente(@RequestBody ClienteDTO nuevoCliente){
        ClienteDTO nuevoClienteDto= clienteService.save(nuevoCliente);
        if(nuevoClienteDto != null ){
            return  ResponseEntity.status(HttpStatus.CREATED).body(nuevoClienteDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClienteDTO> putCliente(@PathVariable Long id,@RequestBody ClienteDTO cambioCliente){
        if (!cambioCliente.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        ClienteDTO clienteDTO= clienteService.findById(id);
        if(clienteDTO==null){
            return ResponseEntity.noContent().build();
        }
        clienteService.update(cambioCliente);
        return ResponseEntity.ok(cambioCliente);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable Long id){

        clienteService.delete(id);
        return  ResponseEntity.ok().build();
    }



}
