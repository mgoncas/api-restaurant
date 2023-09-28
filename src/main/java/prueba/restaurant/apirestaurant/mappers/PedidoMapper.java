package prueba.restaurant.apirestaurant.mappers;

import prueba.restaurant.apirestaurant.dtos.PedidoDTO;
import prueba.restaurant.apirestaurant.entities.Pedido;

public interface PedidoMapper {

    PedidoDTO toDto (Pedido entity);

    Pedido toEntity (PedidoDTO dto);
}
