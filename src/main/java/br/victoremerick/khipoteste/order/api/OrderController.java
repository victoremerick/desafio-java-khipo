package br.victoremerick.khipoteste.order.api;

import br.victoremerick.khipoteste.order.model.dto.OrderDTO;
import br.victoremerick.khipoteste.order.model.dto.OrderProductDTO;
import br.victoremerick.khipoteste.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedido")
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<Long> create(){
        return ResponseEntity.ok(service.create().getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> find(
            @PathVariable Long id){
        return ResponseEntity.ok().body(service.find(id));
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(
            @RequestBody OrderProductDTO orderProductDTO
    ){
        service.addProduct(orderProductDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/product")
    public ResponseEntity<OrderDTO> removeProduct(
            @RequestBody OrderProductDTO orderProductDTO
    ){
        service.removeProduct(orderProductDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> list(
            @RequestParam(required = false, defaultValue = "5") int quantityByPage,
            @RequestParam(required = false, defaultValue = "1") int page){
        return ResponseEntity.ok().body(service.find(page, quantityByPage));
    }

}
