package prueba.restaurant.apirestaurant.services;

import prueba.restaurant.apirestaurant.dtos.TipoCarneDTO;

import java.util.List;

public interface TipoCarneService {
    List<TipoCarneDTO> findAll();

    TipoCarneDTO findById(Long id);

    TipoCarneDTO save(TipoCarneDTO nuevotipoCarne);

    void update(TipoCarneDTO tipoCarneDTOCambiado);

    void delete(Long id);
}
