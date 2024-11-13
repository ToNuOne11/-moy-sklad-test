package ru.moysklad.romashka.api.factories;

import org.springframework.stereotype.Component;
import ru.moysklad.romashka.api.dto.ProductDto;
import ru.moysklad.romashka.store.entity.ProductEntity;

@Component
public class ProductDtoFactory {
    public ProductDto makeProductDto(ProductEntity entity){
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .inStock(entity.getInStock())
                .build();
    }
}
