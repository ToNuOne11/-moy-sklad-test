package ru.moysklad.romashka.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.moysklad.romashka.api.dto.AckDto;
import ru.moysklad.romashka.api.dto.ProductDto;
import ru.moysklad.romashka.api.service.ProductService;

import java.util.List;


@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<ProductDto> getProducts(){
        return  productService.getAll();
    }

    @GetMapping("/api/product/{product_index}")
    public ProductDto getProductByIndex(@PathVariable Integer product_index){
        return  productService.getByIndex(product_index);
    }

    @PostMapping("/api/product")
    public ProductDto addProduct(@RequestBody ProductDto product){
        return  productService.add(product);
    }

    @PutMapping("/api/product/{product_index}")
    public ProductDto changeProduct(@PathVariable Integer product_index, @RequestBody ProductDto product){
        return  productService.changeProduct(product_index, product);
    }

    @DeleteMapping("/api/product/{product_index}")
    public AckDto deleteProduct(@PathVariable Integer product_index){
        return  productService.remove(product_index);
    }
}





