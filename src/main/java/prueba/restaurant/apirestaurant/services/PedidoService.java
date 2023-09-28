package prueba.restaurant.apirestaurant.services;

import prueba.restaurant.apirestaurant.dtos.PedidoDTO;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> findAll();

    PedidoDTO findById(Long id);
}
