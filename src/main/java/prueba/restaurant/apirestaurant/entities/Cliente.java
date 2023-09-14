package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "complemento")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numero_mesa")
    private int numMesa;
    @Column(name="telefono")
    private int telefono;
    @Column(name="direccion")
    private String direccion;
}
