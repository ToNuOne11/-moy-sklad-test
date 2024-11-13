package ru.moysklad.romashka.api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.moysklad.romashka.api.dto.AckDto;
import ru.moysklad.romashka.api.dto.ProductDto;
import ru.moysklad.romashka.api.exeptions.BadRequestException;
import ru.moysklad.romashka.store.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto add(ProductDto product) {
        checkValidProductOrThrowException(product);
        ProductDto.Identity++;
        return productRepository.add(product);
    }

    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    public AckDto remove(Integer productId) {
        return productRepository.remove(productId);
    }

    public ProductDto getByIndex(Integer index) {
        return productRepository.getByIndex(index);
    }

    public ProductDto changeProduct(Integer index, ProductDto product) {
        checkValidProductOrThrowException(product);
        return productRepository.changeProduct(index, product);
    }

    private void checkValidProductOrThrowException(ProductDto product) {
        if (product.getName().length() > 255) {
            throw new BadRequestException("Name length mustn`t > 255");
        }
        if (Objects.nonNull(product.getDescription()) && product.getDescription().length() > 4096) {
            throw new BadRequestException("Name length mustn`t > 4096 ");
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("price mustn`t be < 0");
        }
    }
}
