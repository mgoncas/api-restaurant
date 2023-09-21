package prueba.restaurant.apirestaurant.services;

import prueba.restaurant.apirestaurant.dtos.PanDTO;

import java.util.List;

public interface PanService {
    List<PanDTO> findAll();

    PanDTO findById(Long id);

    PanDTO save (PanDTO nuevoPanDto);

    void update(PanDTO panDTOCambiado);

    void delete(Long id);
}
