package org.onlix.catalog.product.dto;

import lombok.Builder;
import org.onlix.catalog.product.domain.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record ProductDetailResponse(
        String brandName,
        String name,
        LocalDate releaseDate,
        LocalDateTime openDateTime,
        String description
) {
    public static ProductDetailResponse from(Product product){
        return ProductDetailResponse.builder()
                .brandName(product.getBrand().getName())
                .name(product.getName())
                .releaseDate(product.getReleaseDate())
                .openDateTime(product.getOpenDateTime())
                .description(product.getDescription())
                .build();
    }
}
