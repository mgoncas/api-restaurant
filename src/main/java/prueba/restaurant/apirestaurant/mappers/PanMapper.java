package prueba.restaurant.apirestaurant.mappers;


import prueba.restaurant.apirestaurant.dtos.PanDTO;
import prueba.restaurant.apirestaurant.entities.Pan;

public interface PanMapper {
    PanDTO toDto(Pan entity);
    Pan toEntity(PanDTO dto);
}
