package prueba.restaurant.apirestaurant.mappers;

import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.BebidaDTO;
import prueba.restaurant.apirestaurant.entities.Bebida;

@Component
public class BebidaMapperlmpl implements BebidaMapper{

    @Override
    public BebidaDTO toDto(Bebida entity) {
        if (entity == null){
            return null;
        }else {
            BebidaDTO bebidaDTO = new BebidaDTO();
            bebidaDTO.setId(entity.getId());
            bebidaDTO.setNombre(entity.getNombre());
            bebidaDTO.setPrecio(entity.getPrecio());
            return bebidaDTO;
        }

    }

    @Override
    public Bebida toEntity(BebidaDTO dto) {
        if(dto == null){
            return null;
        }else {
            Bebida bebida = new Bebida();
            bebida.setId(dto.getId());
            bebida.setNombre(dto.getNombre());
            bebida.setPrecio(dto.getPrecio());
            return bebida;
        }
    }
}
