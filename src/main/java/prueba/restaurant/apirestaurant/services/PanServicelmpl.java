package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.PanDTO;
import prueba.restaurant.apirestaurant.entities.Pan;
import prueba.restaurant.apirestaurant.mappers.PanMapper;
import prueba.restaurant.apirestaurant.repositories.PanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PanServicelmpl implements PanService{
    @Autowired
    private PanRepository panRepository;

    @Autowired
    private PanMapper panMapper;

    @Override
    public List<PanDTO> findAll() {
        List<Pan> panes = panRepository.findAll();
        List<PanDTO> panesDTO = new ArrayList<>();
        if ( panes == null || panes.isEmpty()){
            return null;
        }
        for(Pan pan:panes){
            PanDTO panDTO = panMapper.toDto(pan);
            panesDTO.add(panDTO);
        }
        return panesDTO;
    }

    @Override
    public PanDTO findById(Long id) {
        Optional<Pan> pan = panRepository.findById(id);
        if (pan.isPresent()){
            PanDTO panDTO = panMapper.toDto(pan.get());
            return panDTO;
        }
        return null;
    }

    @Override
    public PanDTO save(PanDTO nuevoPanDto) {
        Pan pan = panMapper.toEntity(nuevoPanDto);
        Pan panGuardado = panRepository.save(pan);
        PanDTO panDTOGuardado = panMapper.toDto(panGuardado);
        return panDTOGuardado;
    }

    @Override
    public void update(PanDTO panDTOCambiado) {
        Pan pan = panMapper.toEntity(panDTOCambiado);
        panRepository.save(pan);
    }

    @Override
    public void delete(Long id) {
        Optional<Pan> pan = panRepository.findById(id);
        if(pan.isPresent()){
            panRepository.delete(pan.get());
        }
    }
}
