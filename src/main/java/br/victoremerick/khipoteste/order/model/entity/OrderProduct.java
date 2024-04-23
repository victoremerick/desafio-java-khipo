package br.victoremerick.khipoteste.order.model.entity;

import br.victoremerick.khipoteste.order.model.dto.OrderProductDTO;
import br.victoremerick.khipoteste.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigInteger amount;
    private ZonedDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public static OrderProduct from(OrderProductDTO orderProductDTO){
        return OrderProduct.builder()
                .product(Product.from(orderProductDTO.getProduct()))
                .amount(orderProductDTO.getAmount())
                .createdAt(ZonedDateTime.now())
                .order(Order.from(orderProductDTO.getOrder()))
                .build();
    }

}
