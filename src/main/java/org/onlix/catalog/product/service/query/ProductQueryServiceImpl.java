package org.onlix.catalog.product.service.query;

import lombok.RequiredArgsConstructor;
import org.onlix.catalog.core.url.StaticUrlResolver;
import org.onlix.catalog.product.domain.entity.Product;
import org.onlix.catalog.product.domain.repository.ProductImageRepository;
import org.onlix.catalog.product.domain.repository.ProductRepository;
import org.onlix.catalog.product.dto.ProductDetailResponse;
import org.onlix.catalog.product.dto.ProductImageResponse;
import org.onlix.catalog.product.dto.ProductResponse;
import org.onlix.catalog.product.enums.ProductDisplayStatus;
import org.onlix.catalog.product.exception.ProductCustomErrorCode;
import org.onlix.catalog.product.exception.ProductCustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final StaticUrlResolver staticUrlResolver;

    @Override
    public List<ProductResponse> getProducts() {
        return productRepository.findAllByDisplayStatus(ProductDisplayStatus.VISIBLE).stream()
                .map(product -> ProductResponse.of(
                        product,
                        staticUrlResolver.resolve(product.getThumbnailUrl())
                ))
                .toList();
    }

    @Override
    public ProductDetailResponse getProductDetail(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductCustomException(ProductCustomErrorCode.NOT_FOUND)
                );

        String thumbnailUrl = staticUrlResolver.resolve(product.getThumbnailUrl());
        List<ProductImageResponse> detailImages = productImageRepository
                .findAllByProductIdOrderBySortOrderAsc(productId)
                .stream()
                .map(productImage -> ProductImageResponse.of(
                        staticUrlResolver.resolve(productImage.getImageUrl()),
                        productImage.getSortOrder())
                )
                .toList();

        return ProductDetailResponse.of(product, thumbnailUrl, detailImages);
    }
}
