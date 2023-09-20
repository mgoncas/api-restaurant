package prueba.restaurant.apirestaurant.mappers;

import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.ClienteDTO;
import prueba.restaurant.apirestaurant.entities.Cliente;
@Component
public class ClienteMapperlmpl implements  ClienteMapper{

    @Override
    public ClienteDTO toDto(Cliente entity) {
        if(entity==null){
            return null;
        }else {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(entity.getId());
            clienteDTO.setTelefono(entity.getTelefono());
            clienteDTO.setDireccion(entity.getDireccion());
            return clienteDTO;
        }
    }

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if (dto==null){
            return null;
        }else{
            Cliente cliente=new Cliente();
            cliente.setId(dto.getId());
            cliente.setDireccion(dto.getDireccion());
            cliente.setTelefono(dto.getTelefono());
            return cliente;

        }
    }
}
