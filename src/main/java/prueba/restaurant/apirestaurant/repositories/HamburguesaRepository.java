package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Hamburguesa;

@Repository
public interface HamburguesaRepository extends JpaRepository<Hamburguesa,Long> {
}
