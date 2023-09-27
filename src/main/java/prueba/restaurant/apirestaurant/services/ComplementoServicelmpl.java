package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.ComplementoDTO;
import prueba.restaurant.apirestaurant.entities.Complemento;
import prueba.restaurant.apirestaurant.mappers.ComplementoMapper;
import prueba.restaurant.apirestaurant.repositories.ComplementoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplementoServicelmpl implements ComplemetoService{

    @Autowired
    private ComplementoRepository complementoRepository;

    @Autowired
    private ComplementoMapper complementoMapper;

    @Override
    public List<ComplementoDTO> findAll() {
        List<Complemento> complementos = complementoRepository.findAll();
        List<ComplementoDTO> complementosDTOS = new ArrayList<>();
        if (complementos == null || complementos.isEmpty()){
            return null;
        }
        for (Complemento complemento:complementos) {
            ComplementoDTO complementoDTO = complementoMapper.toDto(complemento);
            complementosDTOS.add(complementoDTO);
        }
        return complementosDTOS;
    }

    @Override
    public ComplementoDTO findById(Long id) {
        Optional<Complemento> complemento = complementoRepository.findById(id);
        if (complemento.isPresent()){
            ComplementoDTO complementoDTO = complementoMapper.toDto(complemento.get());
            return complementoDTO;
        }
        return null;
    }

    @Override
    public ComplementoDTO save(ComplementoDTO nuevoComplementoDTO) {
        Complemento complemento = complementoMapper.toEntity(nuevoComplementoDTO);
        Complemento complementoGuardado = complementoRepository.save(complemento);
        ComplementoDTO complementoDTO = complementoMapper.toDto(complementoGuardado);
        return complementoDTO;
    }

    @Override
    public void update(ComplementoDTO complementoDTOCambiado) {
        Complemento complemento = complementoMapper.toEntity(complementoDTOCambiado);
        complementoRepository.save(complemento);

    }

    @Override
    public void delete(Long id) {
        Optional<Complemento> complemento = complementoRepository.findById(id);
        if (complemento.isPresent()){
            complementoRepository.delete(complemento.get());
        }

    }
}
