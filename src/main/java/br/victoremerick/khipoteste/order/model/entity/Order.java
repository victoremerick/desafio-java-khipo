package br.victoremerick.khipoteste.order.model.entity;

import br.victoremerick.khipoteste.order.model.dto.OrderDTO;
import br.victoremerick.khipoteste.product.model.entity.Product;
import br.victoremerick.khipoteste.order.model.dto.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERP")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    private ZonedDateTime createdAt;
    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    public static Order create(){
        return Order.builder()
                .createdAt(ZonedDateTime.now())
                .status(OrderStatusEnum.PENDING)
                .build();
    }

    public static Order from(OrderDTO orderDTO){
        return Order.builder()
                .createdAt(ZonedDateTime.now())
                .id(orderDTO.getId())
                .build();
    }

}
