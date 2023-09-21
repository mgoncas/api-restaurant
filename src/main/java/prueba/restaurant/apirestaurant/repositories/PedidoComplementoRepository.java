package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.PedidoComplemento;

@Repository
public interface PedidoComplementoRepository extends JpaRepository<PedidoComplemento,Long> {
}
