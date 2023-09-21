package prueba.restaurant.apirestaurant.mappers;

import prueba.restaurant.apirestaurant.dtos.TipoCarneDTO;
import prueba.restaurant.apirestaurant.entities.TipoCarne;

public interface TipoCarneMapper {
    TipoCarneDTO toDto(TipoCarne entity);
    TipoCarne toEntity(TipoCarneDTO dto);
}
