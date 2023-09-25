package prueba.restaurant.apirestaurant.services;

import prueba.restaurant.apirestaurant.dtos.BebidaDTO;

import java.util.List;

public interface BebidaService {
    List<BebidaDTO> findAll();

    BebidaDTO findById(Long id);

    BebidaDTO save(BebidaDTO nuevaBebidaDTO);

    void update (BebidaDTO bebidaDTOCambiado);

    void delete (Long id);
}
