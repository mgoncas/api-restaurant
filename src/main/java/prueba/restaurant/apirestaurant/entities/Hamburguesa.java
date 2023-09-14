package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hamburguesa")
public class Hamburguesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="precio")
    private Double precio;
    @Column(name="nombre")
    private String nombre;
    @ManyToOne
    private Pedido pedido;
    @OneToOne
    private Pan pan;
    @OneToOne
    private TipoCarne tipoCarne;

}
