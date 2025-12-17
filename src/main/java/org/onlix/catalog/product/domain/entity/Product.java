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
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "open_datetime", nullable = false)
    private LocalDateTime openDateTime;

    @Lob
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "display_status", nullable = false)
    private ProductDisplayStatus displayStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Builder
    public Product(Brand brand,
                   String name,
                   LocalDate releaseDate,
                   LocalDateTime openDateTime,
                   String description) {
        this.brand = brand;
        this.name = name;
        this.releaseDate = releaseDate;
        this.openDateTime = openDateTime;
        this.description = description;
        this.displayStatus = ProductDisplayStatus.DRAFT;
    }
}
