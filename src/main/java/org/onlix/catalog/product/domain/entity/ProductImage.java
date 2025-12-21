package org.onlix.catalog.product.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Table(name = "product_image")
@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;

    @Column(name = "sort_order", nullable = false)
    private int sortOrder;

    @Builder
    private ProductImage(
            Long productId,
            String imageUrl,
            int sortOrder
    ) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.sortOrder = sortOrder;
    }

    // 상품이미지 생성
    public static ProductImage create(
            Long productId,
            String imageUrl,
            int sortOrder
    ) {
        return ProductImage.builder()
                .productId(productId)
                .imageUrl(imageUrl)
                .sortOrder(sortOrder)
                .build();
    }
}
