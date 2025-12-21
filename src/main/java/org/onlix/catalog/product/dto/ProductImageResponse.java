package org.onlix.catalog.product.dto;

import lombok.Builder;
import org.onlix.catalog.core.url.StaticUrlResolver;
import org.onlix.catalog.product.domain.entity.ProductImage;

public record ProductImageResponse(
        String imageUrl,
        int sortOrder
) {
    public static ProductImageResponse of(String imageUrl, int sortOrder) {
        return new ProductImageResponse(imageUrl, sortOrder);
    }
}
