package org.onlix.catalog.product.service.query;

import lombok.RequiredArgsConstructor;
import org.onlix.catalog.product.domain.entity.Product;
import org.onlix.catalog.product.domain.repository.ProductRepository;
import org.onlix.catalog.product.dto.ProductDetailResponse;
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

    @Override
    public List<ProductResponse> getProducts() {
        return productRepository.findAllByDisplayStatus(ProductDisplayStatus.VISIBLE).stream()
                .map(ProductResponse::from)
                .toList();
    }

    @Override
    public ProductDetailResponse getProductDetail(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductCustomException(ProductCustomErrorCode.NOT_FOUND)
                );

        if (product.getDisplayStatus() != ProductDisplayStatus.VISIBLE) {
            throw new ProductCustomException(ProductCustomErrorCode.NOT_VISIBLE);
        }

        return ProductDetailResponse.from(product);
    }
}
