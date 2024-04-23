package br.victoremerick.khipoteste.order.model.dto;

import br.victoremerick.khipoteste.order.model.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@Data
public class OrderDTO {
    private Long id;
    private BigInteger totalValue;
    private List<OrderProductDTO> products;

    public static OrderDTO from(Order order){
        BigInteger sum = order.getOrderProducts()
                .stream()
                .map(orderProduct -> orderProduct.getAmount().multiply(orderProduct.getProduct().getValue()))
                .reduce(BigInteger.ZERO, BigInteger::add);
        List<OrderProductDTO> productDTOS = order.getOrderProducts()
                .stream()
                .map(OrderProductDTO::from)
                .collect(Collectors.toList());
        return OrderDTO.builder()
                .id(order.getId())
                .totalValue(sum)
                .products(productDTOS)
                .build();
    }
}
