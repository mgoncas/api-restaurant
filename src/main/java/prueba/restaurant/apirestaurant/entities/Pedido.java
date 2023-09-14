package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "fecha y hora")
    private LocalDateTime fechaHora;
    @OneToOne
    private Cliente cliente;




}
