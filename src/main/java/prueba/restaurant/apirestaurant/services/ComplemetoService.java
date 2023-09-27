package prueba.restaurant.apirestaurant.services;

import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.ComplementoDTO;

import java.util.List;


public interface ComplemetoService  {

    List<ComplementoDTO> findAll();

    ComplementoDTO findById(Long id);

    ComplementoDTO save (ComplementoDTO nuevoComplementoDTO);

    void update (ComplementoDTO complementoDTOCambiado);

    void delete(Long id);
}
