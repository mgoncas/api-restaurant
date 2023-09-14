package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.TipoCarne;

@Repository
public interface TipoCarneRepository extends JpaRepository<TipoCarne,Long> {
}
