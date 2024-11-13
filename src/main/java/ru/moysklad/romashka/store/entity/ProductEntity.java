package ru.moysklad.romashka.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    String name;
    @Column(name = "description", columnDefinition = "varchar(4096)")
    String description;
    @Column(name = "price", columnDefinition = "numeric(19, 2)", nullable = false)
    BigDecimal price;
    @Column(name = "in_stock", columnDefinition = "boolean", nullable = false)
    Boolean inStock;
}
