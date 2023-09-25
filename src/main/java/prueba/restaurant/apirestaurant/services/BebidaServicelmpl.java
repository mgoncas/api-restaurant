package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.BebidaDTO;
import prueba.restaurant.apirestaurant.entities.Bebida;
import prueba.restaurant.apirestaurant.mappers.BebidaMapper;
import prueba.restaurant.apirestaurant.repositories.BebidaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BebidaServicelmpl implements BebidaService {
    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private BebidaMapper bebidaMapper;

    @Override
    public List<BebidaDTO> findAll() {
        List<Bebida> bebidas= bebidaRepository.findAll();
        List<BebidaDTO> bebidasDTOS = new ArrayList<>();
        if (bebidas == null || bebidas.isEmpty()){
            return null;
        }
        for (Bebida bebida:bebidas) {
            BebidaDTO bebidaDTO = bebidaMapper.toDto(bebida);
            bebidasDTOS.add(bebidaDTO);
        }
        return bebidasDTOS;
    }

    @Override
    public BebidaDTO findById(Long id) {
        Optional<Bebida> bebida = bebidaRepository.findById(id);
        if (bebida.isPresent()){
            BebidaDTO bebidaDTO = bebidaMapper.toDto(bebida.get());
            return bebidaDTO;
        }
        return null;
    }

    @Override
    public BebidaDTO save(BebidaDTO nuevaBebidaDTO) {
        Bebida bebida = bebidaMapper.toEntity(nuevaBebidaDTO);
        Bebida bebidaGuardada = bebidaRepository.save(bebida);
        BebidaDTO bebidaDTO = bebidaMapper.toDto(bebidaGuardada);
        return bebidaDTO;

    }

    @Override
    public void update(BebidaDTO bebidaDTOCambiado) {
        Bebida bebida = bebidaMapper.toEntity(bebidaDTOCambiado);
        bebidaRepository.save(bebida);
    }

    @Override
    public void delete(Long id) {
        Optional<Bebida> bebida = bebidaRepository.findById(id);
        if (bebida.isPresent()){
            bebidaRepository.delete(bebida.get());
        }
    }
}
