package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;
    @Column(name="numero_mesa")
    private Integer numMesa;
    @OneToOne
    private Cliente cliente;




}
