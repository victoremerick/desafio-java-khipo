package br.victoremerick.khipoteste.product.model.dto;

import br.victoremerick.khipoteste.product.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Builder
@JsonIgnoreProperties
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigInteger value;

    public static ProductDTO from(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .value(product.getValue())
                .build();
    }
}
