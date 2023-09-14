package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Long> {
}
