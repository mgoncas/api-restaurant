package prueba.restaurant.apirestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.restaurant.apirestaurant.dtos.PedidoDTO;
import prueba.restaurant.apirestaurant.entities.Pedido;
import prueba.restaurant.apirestaurant.mappers.PedidoMapper;
import prueba.restaurant.apirestaurant.repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicelmpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        if (pedidos ==null || pedidos.isEmpty()){
            return null;
        }
        for (Pedido pedido:pedidos) {
            PedidoDTO pedidoDTO = pedidoMapper.toDto(pedido);
            pedidosDTO.add(pedidoDTO);
        }
        return pedidosDTO;
    }

    @Override
    public PedidoDTO findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()){
            PedidoDTO pedidoDTO = pedidoMapper.toDto(pedido.get());
            return pedidoDTO;
        }
        return null;
    }
}
