package prueba.restaurant.apirestaurant.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoDTO {
    private Long id;
    private  Double precio;
    private LocalDateTime fechaHora;
    private Integer numMesa;
    private ClienteDTO clienteDTO;
}
