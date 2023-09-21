package prueba.restaurant.apirestaurant.mappers;

import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.TipoCarneDTO;
import prueba.restaurant.apirestaurant.entities.TipoCarne;

@Component
public class TipoCarneMapperlmpl implements TipoCarneMapper{
    @Override
    public TipoCarneDTO toDto(TipoCarne entity) {
        if(entity == null){
            return null;
        }else {
            TipoCarneDTO tipoCarneDTO = new TipoCarneDTO();
            tipoCarneDTO.setId(entity.getId());
            tipoCarneDTO.setNombre(entity.getNombre());
            tipoCarneDTO.setPrecio(entity.getPrecio());
            return  tipoCarneDTO;
        }
    }

    @Override
    public TipoCarne toEntity(TipoCarneDTO dto) {
        if(dto == null){
            return null;
        }else{
            TipoCarne tipoCarne = new TipoCarne();
            tipoCarne.setId(dto.getId());
            tipoCarne.setNombre(dto.getNombre());
            tipoCarne.setPrecio(dto.getPrecio());
            return tipoCarne;
        }

    }
}
