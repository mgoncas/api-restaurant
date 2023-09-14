package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Complemento;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento,Long> {
}
