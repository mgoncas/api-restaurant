package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
