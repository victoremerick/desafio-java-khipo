package br.victoremerick.khipoteste.order.repository;

import br.victoremerick.khipoteste.order.model.entity.Order;
import br.victoremerick.khipoteste.order.model.entity.OrderProduct;
import br.victoremerick.khipoteste.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>, PagingAndSortingRepository<OrderProduct, Long> {

    Optional<OrderProduct> findByOrderAndProduct(Order order, Product product);
}
