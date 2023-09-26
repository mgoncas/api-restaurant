package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.IngredienteDTO;
import prueba.restaurant.apirestaurant.entities.Ingrediente;
import prueba.restaurant.apirestaurant.mappers.IngredienteMapper;
import prueba.restaurant.apirestaurant.repositories.IngredienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServicelmpl implements IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private IngredienteMapper ingredienteMapper;

    @Override
    public List<IngredienteDTO> findAll() {
        List<Ingrediente> ingredientes = ingredienteRepository.findAll();
        List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
        if (ingredientes == null || ingredientes.isEmpty()){
            return null;
        }
        for (Ingrediente ingrediente:ingredientes) {
            IngredienteDTO ingredienteDTO = ingredienteMapper.toDto(ingrediente);
            ingredientesDTO.add(ingredienteDTO);
        }
        return ingredientesDTO;
    }

    @Override
    public IngredienteDTO findById(Long id) {
        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
        if (ingrediente.isPresent()){
            IngredienteDTO ingredienteDTO = ingredienteMapper.toDto(ingrediente.get());
            return ingredienteDTO;
        }
        return null;
    }

    @Override
    public IngredienteDTO save(IngredienteDTO nuevoIngredienteDTO) {
        Ingrediente ingrediente = ingredienteMapper.toEntity(nuevoIngredienteDTO);
        Ingrediente ingredienteGuardador = ingredienteRepository.save(ingrediente);
        IngredienteDTO ingredienteDTOGuardado = ingredienteMapper.toDto(ingredienteGuardador);
        return ingredienteDTOGuardado;
    }

    @Override
    public void update(IngredienteDTO ingredienteDTOCambio) {
        Ingrediente ingrediente = ingredienteMapper.toEntity(ingredienteDTOCambio);
        ingredienteRepository.save(ingrediente);
    }

    @Override
    public void delete(Long id) {
        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
        if (ingrediente.isPresent()){
            ingredienteRepository.delete(ingrediente.get());
        }

    }
}
