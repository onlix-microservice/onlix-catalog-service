package org.onlix.catalog.product.dto;

import org.onlix.catalog.product.domain.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ProductDetailResponse(

        String thumbnailUrl,
        List<ProductImageResponse> detailImages,
        String brandName,
        String name,
        LocalDate releaseDate,
        LocalDateTime openDateTime,
        int soldCount,
        int price,
        String description
) {
    public static ProductDetailResponse of(
            Product product,
            String thumbnailUrl,
            List<ProductImageResponse> detailImages
    ) {
        return new ProductDetailResponse(
                thumbnailUrl,
                detailImages,
                product.getBrand().getName(),
                product.getName(),
                product.getReleaseDate(),
                product.getOpenDateTime(),
                product.getSoldCount(),
                product.getPrice(),
                product.getDescription()
        );
    }
}
