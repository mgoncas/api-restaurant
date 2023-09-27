package prueba.restaurant.apirestaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteDTO {
    private Long id;
    private Double precio;
    private String nombre;
}
