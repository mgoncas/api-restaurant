package prueba.restaurant.apirestaurant.mappers;

import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.IngredienteDTO;
import prueba.restaurant.apirestaurant.entities.Ingrediente;

@Component
public class IngredienteMapperlmpl implements IngredienteMapper{
    @Override
    public IngredienteDTO toDto(Ingrediente entity) {
        if (entity == null){
            return null;
        }else{
            IngredienteDTO ingredienteDTO = new IngredienteDTO();
            ingredienteDTO.setId(entity.getId());
            ingredienteDTO.setNombre(entity.getNombre());
            ingredienteDTO.setPrecio(entity.getPrecio());
            return ingredienteDTO;
        }
    }

    @Override
    public Ingrediente toEntity(IngredienteDTO dto) {
        if (dto == null){
            return null;
        }else {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setId(dto.getId());
            ingrediente.setNombre(dto.getNombre());
            ingrediente.setPrecio(dto.getPrecio());
            return ingrediente;
        }
    }
}
