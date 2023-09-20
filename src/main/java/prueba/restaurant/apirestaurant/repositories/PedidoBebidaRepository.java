package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Ingrediente;

@Repository
public interface PedidoBebidaRepository extends JpaRepository<PedidoBebidaRepository,Long> {
}
