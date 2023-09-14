package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bebida")
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="precio")
    private double precio;
    @Column(name="nombre")
    private String nombre;
    @ManyToOne
    private Pedido pedido;
}
