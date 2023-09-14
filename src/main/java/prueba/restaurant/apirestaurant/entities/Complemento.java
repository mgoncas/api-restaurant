package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "complemento")
public class Complemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="precio")
    private Double precio;
    @Column(name="nombre")
    private String nombre;
    @ManyToOne
    private Pedido pedido;
}
