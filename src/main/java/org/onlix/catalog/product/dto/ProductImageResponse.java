package org.onlix.catalog.product.dto;

public record ProductImageResponse(
        String imageUrl,
        int sortOrder
) {
    public static ProductImageResponse of(String imageUrl, int sortOrder) {
        return new ProductImageResponse(imageUrl, sortOrder);
    }
}
