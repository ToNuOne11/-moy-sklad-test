package ru.moysklad.romashka.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.moysklad.romashka.store.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:price IS NULL OR p.price = :price) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "AND (:inStock IS NULL OR p.inStock = :inStock) " +
            "ORDER BY " +
            "CASE WHEN :sortBy = 'name' AND :sortOrder = 'ASC' THEN p.name END ASC," +
            "CASE WHEN :sortBy = 'name' AND :sortOrder = 'DESC' THEN p.name END DESC," +
            "CASE WHEN :sortBy = 'price' AND :sortOrder = 'ASC' THEN p.price END ASC," +
            "CASE WHEN :sortBy = 'price' AND :sortOrder = 'DESC' THEN p.price END DESC"
    )
    Stream<ProductEntity> streamByFiltersAndSort(
            @Param("name") String name,
            @Param("price") BigDecimal price,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("inStock") Boolean inStock,
            @Param("sortBy") String sortBy,
            @Param("sortOrder") String sortOrder
    );
}