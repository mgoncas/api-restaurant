package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingrediente_hamburguesa")
public class IngredienteHamburguesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Hamburguesa hamburguesa;
    @OneToOne
    private Ingrediente ingrediente;
}
