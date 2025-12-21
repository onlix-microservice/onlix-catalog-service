package org.onlix.catalog.product.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.onlix.catalog.product.enums.ProductDisplayStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "product")
@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "open_datetime", nullable = false)
    private LocalDateTime openDateTime;

    @Column(name = "sold_count", nullable = false)
    private int soldCount;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "thumbnail_url", nullable = false, length = 500)
    private String thumbnailUrl;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "sold_out", nullable = false)
    private boolean soldOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "display_status", nullable = false)
    private ProductDisplayStatus displayStatus;

    @Builder
    public Product(Brand brand,
                   String name,
                   LocalDate releaseDate,
                   LocalDateTime openDateTime,
                   int soldCount,
                   int price,
                   String thumbnailUrl,
                   String description) {
        this.brand = brand;
        this.name = name;
        this.releaseDate = releaseDate;
        this.openDateTime = openDateTime;
        this.soldCount = soldCount;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.soldOut = false;
        this.displayStatus = ProductDisplayStatus.DRAFT;
    }

    // 상품 생성
    public static Product create(
            Brand brand,
            String name,
            LocalDate releaseDate,
            LocalDateTime openDateTime,
            int soldCount,
            int price,
            String thumbnailUrl,
            String description
    ) {
        // TODO: VALIDATE 검증로직 추가
        return Product.builder()
                .brand(brand)
                .name(name)
                .releaseDate(releaseDate)
                .openDateTime(openDateTime)
                .soldCount(soldCount)
                .price(price)
                .thumbnailUrl(thumbnailUrl)
                .description(description)
                .build();
    }
}
