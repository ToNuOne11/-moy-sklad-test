package ru.moysklad.romashka.store.repositories;

import org.springframework.stereotype.Component;
import ru.moysklad.romashka.api.dto.AckDto;
import ru.moysklad.romashka.api.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<ProductDto> products = new ArrayList<>();

    public ProductDto add(ProductDto product) {
        products.add(product);
        return product;
    }

    public List<ProductDto> getAll() {
        return products;
    }

    public AckDto remove(Integer productId) {
        products.remove(productId.intValue());
        return AckDto.makeDefault(true);
    }

    public ProductDto getByIndex(Integer index) {
        return products.get(index);
    }

    public ProductDto changeProduct(Integer index, ProductDto product) {
        products.set(index, product);
        return product;
    }
}
