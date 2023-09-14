package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "complemento")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numero_mesa")
    private Integer numMesa;
    @Column(name="telefono")
    private Integer telefono;
    @Column(name="direccion")
    private String direccion;
}
