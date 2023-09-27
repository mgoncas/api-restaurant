package prueba.restaurant.apirestaurant.mappers;

import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.ComplementoDTO;
import prueba.restaurant.apirestaurant.entities.Complemento;

@Component
public class ComplementoMapperlmpl implements ComplementoMapper{
    @Override
    public ComplementoDTO toDto(Complemento entity) {
        if (entity == null){
            return null;
        }else {
            ComplementoDTO complementoDTO = new ComplementoDTO();
            complementoDTO.setId(entity.getId());
            complementoDTO.setNombre(entity.getNombre());
            complementoDTO.setPrecio(entity.getPrecio());
            return complementoDTO;
        }
    }

    @Override
    public Complemento toEntity(ComplementoDTO dto) {
        if (dto == null){
            return null;
        }else {
            Complemento complemento = new Complemento();
            complemento.setId(dto.getId());
            complemento.setNombre(dto.getNombre());
            complemento.setPrecio(dto.getPrecio());
            return complemento;
        }
    }
}
