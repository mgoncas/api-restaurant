package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Pan;

@Repository
public interface PanRepository extends JpaRepository<Pan,Long> {
}
