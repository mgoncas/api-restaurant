package prueba.restaurant.apirestaurant.mappers;

import prueba.restaurant.apirestaurant.dtos.ComplementoDTO;
import prueba.restaurant.apirestaurant.entities.Complemento;

public interface ComplementoMapper {

    ComplementoDTO toDto (Complemento entity);

    Complemento toEntity (ComplementoDTO dto);
}
