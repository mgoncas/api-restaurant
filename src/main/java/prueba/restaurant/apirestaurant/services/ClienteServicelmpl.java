package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.ClienteDTO;
import prueba.restaurant.apirestaurant.entities.Cliente;
import prueba.restaurant.apirestaurant.mappers.ClienteMapper;
import prueba.restaurant.apirestaurant.repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteServicelmpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        if (clientes == null || clientes.isEmpty()) {
            return null;
        }
        for (Cliente cliente : clientes) {
            ClienteDTO clienteDTO = clienteMapper.toDto(cliente);
            clientesDTO.add(clienteDTO);
        }
        return clientesDTO;
    }

    @Override
    public ClienteDTO findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            ClienteDTO clienteDTO = clienteMapper.toDto(cliente.get());
            return clienteDTO;
        }
        return null;

    }

    @Override
    public ClienteDTO save(ClienteDTO nuevoClienteDTO) {
        Cliente cliente = clienteMapper.toEntity(nuevoClienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        ClienteDTO clienteDTOGuardado = clienteMapper.toDto(clienteGuardado);
        return clienteDTOGuardado;
    }

    @Override
    public void update(ClienteDTO clienteDTOCambiado) {
        Cliente cliente = clienteMapper.toEntity(clienteDTOCambiado);
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            clienteRepository.delete(cliente.get());
        }

    }


}
