package prueba.restaurant.apirestaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedido_complemento")
public class PedidoComplemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pedido pedido;
    @OneToOne
    private Complemento complemento;
}
