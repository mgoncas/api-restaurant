package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="precio")
    private Double precio;
    @Column(name="nombre")
    private String nombre;
}
