package org.onlix.catalog.product.dto;

import org.onlix.catalog.product.domain.entity.Product;

import java.time.LocalDateTime;

public record ProductResponse(
    Long productId,
    String name,
    LocalDateTime openDateTime,
    String thumbnailUrl,
    boolean soldOut,
    String displayStatus
) {
    public static ProductResponse of(Product product, String thumbnailUrl) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getOpenDateTime(),
                thumbnailUrl,
                product.isSoldOut(),
                product.getDisplayStatus().name()
        );
    }
}
