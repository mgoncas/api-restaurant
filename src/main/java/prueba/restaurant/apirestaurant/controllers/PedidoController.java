package prueba.restaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prueba.restaurant.apirestaurant.dtos.PedidoDTO;
import prueba.restaurant.apirestaurant.services.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getPedidos(){
        List<PedidoDTO> pedidos = pedidoService.findAll();
        if (pedidos != null || !pedidos.isEmpty()){
            return ResponseEntity.ok(pedidos);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping ("{id}")
    public ResponseEntity<PedidoDTO> getPeido(@PathVariable Long id){
        PedidoDTO pedidoDTO = pedidoService.findById(id);
        if (pedidoDTO != null){
            return ResponseEntity.ok(pedidoDTO);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

}
