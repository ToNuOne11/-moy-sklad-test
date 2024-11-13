package ru.moysklad.romashka.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    public static Integer Identity = 0;
    @Builder.Default
    Integer id = Identity;
    @NonNull
    String name;
    String description;
    @Builder.Default
    BigDecimal price = new BigDecimal("0.00");
    @Builder.Default
    Boolean inStock = false;
}
