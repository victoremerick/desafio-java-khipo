package br.victoremerick.khipoteste.product.api;

import br.victoremerick.khipoteste.product.model.dto.ProductDTO;
import br.victoremerick.khipoteste.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(service.create(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> edit(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(service.edit(id, productDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> find(
            @PathVariable Long id){
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> list(
            @RequestParam(required = false, defaultValue = "20") int quantityByPage,
            @RequestParam(required = false, defaultValue = "1") int page){
        return ResponseEntity.ok().body(service.find(page, quantityByPage));
    }

}
