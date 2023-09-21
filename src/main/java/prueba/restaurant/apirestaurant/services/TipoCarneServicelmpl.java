package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.TipoCarneDTO;
import prueba.restaurant.apirestaurant.entities.TipoCarne;
import prueba.restaurant.apirestaurant.mappers.TipoCarneMapper;
import prueba.restaurant.apirestaurant.repositories.TipoCarneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCarneServicelmpl implements TipoCarneService{
    @Autowired
    private TipoCarneRepository tipoCarneRepository;

    @Autowired
    private TipoCarneMapper tipoCarneMapper;

    @Override
    public List<TipoCarneDTO> findAll() {
        List<TipoCarne> tiposCarne = tipoCarneRepository.findAll();
        List<TipoCarneDTO> tiposCarneDTO = new ArrayList<>();
        if(tiposCarne == null || tiposCarne.isEmpty()){
            return null;
        }
        for (TipoCarne tipoCarne:tiposCarne){
            TipoCarneDTO tipoCarneDTO = tipoCarneMapper.toDto(tipoCarne);
            tiposCarneDTO.add(tipoCarneDTO);
        }
        return tiposCarneDTO;
    }

    @Override
    public TipoCarneDTO findById(Long id) {
        Optional<TipoCarne> tipoCarne = tipoCarneRepository.findById(id);
        if (tipoCarne.isPresent()){
            TipoCarneDTO tipoCarneDTO = tipoCarneMapper.toDto(tipoCarne.get());
            return tipoCarneDTO;
        }
        return null;
    }

    @Override
    public TipoCarneDTO save(TipoCarneDTO nuevotipoCarne) {
        TipoCarne tipoCarne = tipoCarneMapper.toEntity(nuevotipoCarne);
        TipoCarne tipoCarneGuardada = tipoCarneRepository.save(tipoCarne);
        TipoCarneDTO tipoCarneDTOGuardado  = tipoCarneMapper.toDto(tipoCarneGuardada);
        return tipoCarneDTOGuardado;
    }

    @Override
    public void update(TipoCarneDTO tipoCarneDTOCambiado) {
        TipoCarne tipoCarne = tipoCarneMapper.toEntity(tipoCarneDTOCambiado);
        tipoCarneRepository.save(tipoCarne);
    }

    @Override
    public void delete(Long id) {
        Optional<TipoCarne> tipoCarne = tipoCarneRepository.findById(id);
        if(tipoCarne.isPresent()){
            tipoCarneRepository.delete(tipoCarne.get());
        }
    }
}
