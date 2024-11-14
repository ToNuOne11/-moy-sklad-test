package ru.moysklad.romashka.api.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.moysklad.romashka.api.dto.AckDto;
import ru.moysklad.romashka.api.dto.ProductDto;
import ru.moysklad.romashka.api.service.ProductService;
import ru.moysklad.romashka.store.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<ProductDto> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) BigDecimal min_price,
            @RequestParam(required = false) BigDecimal max_price,
            @RequestParam(required = false) Boolean in_stock,
            @RequestParam(required = false) String sort_by,
            @RequestParam(required = false) String sort_order
    ) {
        return productService.getAll(name, price, min_price, max_price, in_stock, sort_by, sort_order);
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





