package prueba.restaurant.apirestaurant.mappers;

import prueba.restaurant.apirestaurant.dtos.ClienteDTO;
import prueba.restaurant.apirestaurant.entities.Cliente;

public interface ClienteMapper {
    ClienteDTO toDto(Cliente entity);
    Cliente toEntity(ClienteDTO dto);
}
