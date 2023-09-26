package prueba.restaurant.apirestaurant.mappers;

import prueba.restaurant.apirestaurant.dtos.IngredienteDTO;
import prueba.restaurant.apirestaurant.entities.Ingrediente;

public interface IngredienteMapper {
    IngredienteDTO toDto (Ingrediente entity);
    Ingrediente toEntity (IngredienteDTO dto);
}
