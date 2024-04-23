package br.victoremerick.khipoteste.product.model.entity;


import br.victoremerick.khipoteste.product.model.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigInteger value;
    @OneToMany
    private List<Product> transactions;

    public static Product from(ProductDTO client){
        return Product.builder()
                .name(client.getName())
                .value(client.getValue())
                .build();
    }
}
