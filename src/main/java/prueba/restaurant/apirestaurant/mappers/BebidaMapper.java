package prueba.restaurant.apirestaurant.mappers;

import prueba.restaurant.apirestaurant.dtos.BebidaDTO;
import prueba.restaurant.apirestaurant.entities.Bebida;

public interface BebidaMapper {

    BebidaDTO toDto (Bebida entity);

    Bebida toEntity (BebidaDTO dto);
}
