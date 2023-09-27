package prueba.restaurant.apirestaurant.services;

import prueba.restaurant.apirestaurant.dtos.IngredienteDTO;

import java.util.List;

public interface IngredienteService {

    List<IngredienteDTO> findAll();

    IngredienteDTO findById(Long id);

    IngredienteDTO save(IngredienteDTO nuevoIngredienteDTO);

    void update (IngredienteDTO ingredienteDTOCambio);

    void delete (Long id);
}
