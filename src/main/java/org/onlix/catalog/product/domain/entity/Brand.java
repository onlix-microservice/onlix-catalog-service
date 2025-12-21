package org.onlix.catalog.product.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "brand")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Builder
    public Brand(String name,
                 String description) {
        this.name = name;
        this.description = description;
    }

    // 브랜드 생성
    public static Brand create(
            String name,
            String description
    ) {
        return Brand.builder()
                .name(name)
                .description(description)
                .build();
    }
}
