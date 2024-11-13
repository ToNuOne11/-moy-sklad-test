package ru.moysklad.romashka.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.moysklad.romashka.store.entity.ProductEntity;

import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Stream<ProductEntity> streamAllBy();
}
