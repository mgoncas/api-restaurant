package prueba.restaurant.apirestaurant.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prueba.restaurant.apirestaurant.dtos.ClienteDTO;
import prueba.restaurant.apirestaurant.dtos.PedidoDTO;
import prueba.restaurant.apirestaurant.entities.Cliente;
import prueba.restaurant.apirestaurant.entities.Pedido;

@Component
public class PedidoMapperlmpl implements PedidoMapper{
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public PedidoDTO toDto(Pedido entity) {
        if (entity == null){
            return null;
        }else {
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setId(entity.getId());
            pedidoDTO.setPrecio(entity.getPrecio());
            pedidoDTO.setFechaHora(entity.getFechaHora());
            pedidoDTO.setNumMesa(entity.getNumMesa());

            if (entity.getCliente() != null){
                ClienteDTO clienteDTO = clienteMapper.toDto(entity.getCliente());
                pedidoDTO.setClienteDTO(clienteDTO);
            }
            return pedidoDTO;
        }
    }

    @Override
    public Pedido toEntity(PedidoDTO dto) {
        if (dto == null){
            return null;
        }else {
            Pedido pedido = new Pedido();
            pedido.setId(dto.getId());
            pedido.setPrecio(dto.getPrecio());
            pedido.setFechaHora(dto.getFechaHora());
            pedido.setNumMesa(dto.getNumMesa());

            if (dto.getClienteDTO() != null){
                Cliente cliente = clienteMapper.toEntity(dto.getClienteDTO());
                pedido.setCliente(cliente);
            }
            return pedido;
        }
    }
}
