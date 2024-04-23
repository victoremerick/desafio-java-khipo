package br.victoremerick.khipoteste.order.service;

import br.victoremerick.khipoteste.order.model.dto.OrderDTO;
import br.victoremerick.khipoteste.order.model.dto.OrderProductDTO;
import br.victoremerick.khipoteste.order.model.entity.Order;
import br.victoremerick.khipoteste.order.model.entity.OrderProduct;
import br.victoremerick.khipoteste.order.repository.OrderProductRepository;
import br.victoremerick.khipoteste.order.repository.OrderRepository;
import br.victoremerick.khipoteste.product.model.entity.Product;
import br.victoremerick.khipoteste.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    private final ProductService productService;

    public Order create(){
        log.log(Level.ALL, "C:OrderService - M:create - M:Creation started");
        Order order = Order.create();
        order = orderRepository.save(order);
        log.log(Level.ALL, "C:OrderService - M:create - M:Creation finished");
        return order;
    }

    public OrderDTO find(Long id){
        log.log(Level.ALL, "C:OrderService - M:find - M:Search started");
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            log.log(Level.ALL, "C:OrderService - M:find - M:Search finished");
            return OrderDTO.from(order.get());
        }
        log.log(Level.ALL, "C:OrderService - M:find - M:Unsuccesss search");
        throw new ResourceNotFoundException("Order not found.");
    }

    public List<OrderDTO> find(Integer page, Integer quantity){
        log.log(Level.ALL, "C:OrderService - M:find - M:Search started");
        Pageable pageable = PageRequest.of(page-1, quantity);
        log.log(Level.ALL, "C:OrderService - M:find - M:Search finished on list");
        return orderRepository.findAll(pageable)
                .map(OrderDTO::from)
                .stream()
                .collect(Collectors.toList());
    }

    public void addProduct(OrderProductDTO orderProductDTO){
        log.log(Level.ALL, "C:OrderService - M:addProduct - M:Validating order and product");
        OrderProduct orderProduct = OrderProduct.from(orderProductDTO);
        Optional<Order> orderOpt = orderRepository.findById(orderProduct.getId());
        if(orderOpt.isPresent()) {
            Order order = orderOpt.get();
            Product product = productService.findEntity(orderProduct.getProduct().getId());
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);
            orderProductRepository.save(orderProduct);
            log.log(Level.ALL, "C:OrderService - M:addProduct - M:Product added");
            return;
        }
        log.log(Level.ALL, "C:OrderService - M:addProduct - M:Order not found");
        throw new ResourceNotFoundException("Order not found.");
    }

    public void removeProduct(OrderProductDTO orderProductDTO){
        log.log(Level.ALL, "C:OrderService - M:addProduct - M:Validating order and product");
        OrderProduct orderProduct = OrderProduct.from(orderProductDTO);
        Optional<Order> orderOpt = orderRepository.findById(orderProduct.getId());
        if(orderOpt.isPresent()) {
            Order order = orderOpt.get();
            Product product = productService.findEntity(orderProduct.getProduct().getId());
            Optional<OrderProduct> orderProduct1 = orderProductRepository.findByOrderAndProduct(order, product);
            if(orderProduct1.isPresent()) {
                orderProductRepository.delete(orderProduct1.get());
                log.log(Level.ALL, "C:OrderService - M:addProduct - M:Product removed");
            }
        }
        log.log(Level.ALL, "C:OrderService - M:addProduct - M:Order not found");
        throw new ResourceNotFoundException("Order not found.");
    }

}
