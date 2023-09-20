package prueba.restaurant.apirestaurant.services;

import prueba.restaurant.apirestaurant.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> findAll();
    ClienteDTO findById(Long id);

    ClienteDTO save(ClienteDTO nuevoClienteDto);

    void update(ClienteDTO clienteDTOCambiado);

    void delete(Long id);
}
