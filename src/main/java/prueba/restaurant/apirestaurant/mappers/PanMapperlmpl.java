package prueba.restaurant.apirestaurant.mappers;

import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.PanDTO;
import prueba.restaurant.apirestaurant.entities.Pan;

@Component
public class PanMapperlmpl implements PanMapper{

    @Override
    public PanDTO toDto(Pan entity) {
        if(entity == null){
            return null;
        }else {
            PanDTO panDTO = new PanDTO();
            panDTO.setId(entity.getId());
            panDTO.setNombre(entity.getNombre());
            panDTO.setPrecio(entity.getPrecio());
            return panDTO;
        }
    }

    @Override
    public Pan toEntity(PanDTO dto) {
        if (dto == null){
            return null;
        }else {
            Pan pan = new Pan();
            pan.setId(dto.getId());
            pan.setNombre(dto.getNombre());
            pan.setPrecio(dto.getPrecio());
            return pan;
        }
    }
}
