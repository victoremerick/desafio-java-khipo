package br.victoremerick.khipoteste.order.model.dto;

import br.victoremerick.khipoteste.order.model.entity.Order;
import br.victoremerick.khipoteste.order.model.entity.OrderProduct;
import br.victoremerick.khipoteste.product.model.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@Data
public class OrderProductDTO {
    private BigInteger amount;
    private ProductDTO product;
    private OrderDTO order;

    public static OrderProductDTO from(OrderProduct order){
        return OrderProductDTO.builder()
                .amount(order.getAmount())
                .product(ProductDTO.from(order.getProduct()))
                .order(OrderDTO.from(order.getOrder()))
                .build();
    }
}
