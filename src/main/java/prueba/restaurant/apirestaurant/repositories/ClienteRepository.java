package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
