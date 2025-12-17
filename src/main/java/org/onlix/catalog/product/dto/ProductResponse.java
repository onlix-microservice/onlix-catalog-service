package org.onlix.catalog.product.dto;

import lombok.Builder;
import org.onlix.catalog.product.domain.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record ProductResponse(
    Long productId,
    String name,
    LocalDateTime openDateTime,
    String displayStatus
) {
    public static ProductResponse from(Product product){
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .openDateTime(product.getOpenDateTime())
                .displayStatus(product.getDisplayStatus().name())
                .build();
    }
}
