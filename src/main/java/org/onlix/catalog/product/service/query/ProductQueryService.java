package org.onlix.catalog.product.service.query;

import org.onlix.catalog.product.dto.ProductResponse;

import java.util.List;

public interface ProductQueryService {

    List<ProductResponse> getProducts();
}
