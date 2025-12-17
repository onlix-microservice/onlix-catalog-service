package org.onlix.catalog.product.controller;

import lombok.RequiredArgsConstructor;
import org.onlix.catalog.product.dto.ProductResponse;
import org.onlix.catalog.product.service.query.ProductQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog/products")
public class ProductController {
    private final ProductQueryService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
