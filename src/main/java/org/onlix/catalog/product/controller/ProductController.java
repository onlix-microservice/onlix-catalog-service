package org.onlix.catalog.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.onlix.catalog.product.dto.ProductDetailResponse;
import org.onlix.catalog.product.dto.ProductResponse;
import org.onlix.catalog.product.service.query.ProductQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Catalog - Product")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog/products")
public class ProductController {
    private final ProductQueryService productService;

    @Operation(
            summary = "상품 리스트 조회",
            description = "노출 상태가 'VISIBLE'인 상품 목록을 조회합니다."
    )
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @Operation(
            summary = "상품 상세 조회",
            description = "상품의 상세정보를 조회합니다."
    )
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailResponse> getProductDetail(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductDetail(productId));
    }
}
