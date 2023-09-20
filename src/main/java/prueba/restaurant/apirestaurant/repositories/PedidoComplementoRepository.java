package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoComplementoRepository extends JpaRepository<PedidoComplementoRepository,Long> {
}
