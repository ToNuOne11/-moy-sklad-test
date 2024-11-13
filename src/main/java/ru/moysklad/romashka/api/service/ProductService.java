package ru.moysklad.romashka.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.moysklad.romashka.api.dto.AckDto;
import ru.moysklad.romashka.api.dto.ProductDto;
import ru.moysklad.romashka.api.exeptions.BadRequestException;
import ru.moysklad.romashka.api.exeptions.NotFoundException;
import ru.moysklad.romashka.api.factories.ProductDtoFactory;
import ru.moysklad.romashka.store.entity.ProductEntity;
import ru.moysklad.romashka.store.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoFactory productDtoFactory;

    public ProductDto add(ProductEntity product) {
        checkValidProductOrThrowException(product);
        productRepository.saveAndFlush(product);
        return productDtoFactory.makeProductDto(product);
    }

    public List<ProductDto> getAll() {
        return productRepository.streamAllBy()
                .map(productDtoFactory::makeProductDto)
                .toList();
    }

    public ProductDto getById(Long productId) {
        return productDtoFactory.makeProductDto(findProductOrThrowException(productId));
    }

    public ProductDto updateProduct(Long productId, ProductEntity product) {
        checkValidProductOrThrowException(product);
        ProductEntity savedProduct = findProductOrThrowException(productId);

        if (Objects.nonNull(product.getName())) {
            savedProduct.setName(product.getName());
        }
        if (Objects.nonNull(product.getDescription())) {
            savedProduct.setDescription(product.getDescription());
        }
        if (Objects.nonNull(product.getPrice())) {
            savedProduct.setPrice(product.getPrice());
        }
        if (Objects.nonNull(product.getInStock())) {
            savedProduct.setInStock(product.getInStock());
        }

        productRepository.saveAndFlush(savedProduct);

        return productDtoFactory.makeProductDto(savedProduct);
    }

    private ProductEntity findProductOrThrowException(Long productId) {
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public AckDto remove(Long productId) {
        productRepository.deleteById(productId);
        return AckDto.makeDefault(true);
    }

    private void checkValidProductOrThrowException(ProductEntity product) {
        if (Objects.nonNull(product.getName()) && product.getName().length() > 255) {
            throw new BadRequestException("Name length mustn`t > 255");
        }
        if (Objects.nonNull(product.getDescription()) && product.getDescription().length() > 4096) {
            throw new BadRequestException("Name length mustn`t > 4096 ");
        }
        if (Objects.nonNull(product.getPrice()) && product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("price mustn`t be < 0");
        }
    }
}
