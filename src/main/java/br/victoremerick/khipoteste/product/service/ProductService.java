package br.victoremerick.khipoteste.product.service;

import br.victoremerick.khipoteste.product.model.dto.ProductDTO;
import br.victoremerick.khipoteste.product.model.entity.Product;
import br.victoremerick.khipoteste.product.repository.ProductRepository;
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
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO create(ProductDTO productDTO){
        log.log(Level.ALL, "C:ProductService - M:create - M:Creation started");
        Product product = Product.from(productDTO);
        product = productRepository.save(product);
        log.log(Level.ALL, "C:ProductService - M:create - M:Creation finished");
        return ProductDTO.from(product);
    }

    public ProductDTO edit(Long id, ProductDTO productDTO){
        log.log(Level.ALL, "C:ProductService - M:edit - M:Edit started  I:"+id);
        if(productRepository.existsById(id)) {
            productDTO.setId(id);
            Product product = Product.from(productDTO);
            product = productRepository.save(product);
            log.log(Level.ALL, "C:ProductService - M:edit - M:Product changed");
            return ProductDTO.from(product);
        }
        log.log(Level.ALL, "C:ProductService - M:edit - M:Product not found");
        throw new ResourceNotFoundException("Product not found.");
    }

    public ProductDTO find(Long id){
        log.log(Level.ALL, "C:ProductService - M:find - M:Find product by Id I:"+id);
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            log.log(Level.ALL, "C:ProductService - M:find - M:Product found");
            return ProductDTO.from(product.get());
        }
        log.log(Level.ALL, "C:ProductService - M:find - M:Product not found");
        throw new ResourceNotFoundException("Product not found.");
    }

    public Product findEntity(Long id){
        log.log(Level.ALL, "C:ProductService - M:findEntity - M:Find product I:"+id);
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            log.log(Level.ALL, "C:ProductService - M:findEntity - M:Product found");
            return product.get();
        }
        log.log(Level.ALL, "C:ProductService - M:findEntity - M:Product not found");
        throw new ResourceNotFoundException("Product not found.");
    }

    public List<ProductDTO> find(Integer page, Integer quantity){
        log.log(Level.ALL, "C:ProductService - M:find - M:List products started P:"+page+" Q:"+quantity);
        Pageable pageable = PageRequest.of(page-1, quantity);
        log.log(Level.ALL, "C:ProductService - M:find - M:List products finished");
        return productRepository.findAll(pageable)
                .map(ProductDTO::from)
                .stream()
                .collect(Collectors.toList());
    }

}
