package ru.moysklad.romashka.api.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.moysklad.romashka.api.dto.AckDto;
import ru.moysklad.romashka.api.dto.ProductDto;
import ru.moysklad.romashka.api.service.ProductService;
import ru.moysklad.romashka.store.entity.ProductEntity;

import java.util.List;

@Transactional
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<ProductDto> getProducts(){
        return  productService.getAll();
    }

    @GetMapping("/api/product/{product_id}")
    public ProductDto getProductById(@PathVariable Long product_id){
        return  productService.getById(product_id);
    }

    @PostMapping("/api/product")
    public ProductDto addProduct(@RequestBody ProductEntity product){
        return  productService.add(product);
    }

    @PatchMapping("/api/product/{product_id}")
    public ProductDto updateProduct(@PathVariable Long product_id, @RequestBody ProductEntity product){
        return  productService.updateProduct(product_id, product);
    }

    @DeleteMapping("/api/product/{product_id}")
    public AckDto deleteProduct(@PathVariable Long product_id){
        return  productService.remove(product_id);
    }
}





