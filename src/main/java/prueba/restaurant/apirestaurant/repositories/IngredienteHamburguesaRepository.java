package prueba.restaurant.apirestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.restaurant.apirestaurant.entities.IngredienteHamburguesa;

@Repository
public interface IngredienteHamburguesaRepository extends JpaRepository<IngredienteHamburguesa,Long> {
}
