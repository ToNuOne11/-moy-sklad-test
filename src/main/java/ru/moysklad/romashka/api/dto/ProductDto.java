package ru.moysklad.romashka.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    Long id;
    @NonNull
    String name;
    String description;
    @Builder.Default
    BigDecimal price = new BigDecimal("0.00");
    @Builder.Default
    Boolean inStock = false;
}
