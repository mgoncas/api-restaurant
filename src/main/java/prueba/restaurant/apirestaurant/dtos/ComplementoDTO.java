package prueba.restaurant.apirestaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComplementoDTO {
    private Long id;
    private String nombre;
    private Double precio;
}
