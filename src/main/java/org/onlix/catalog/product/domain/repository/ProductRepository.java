package org.onlix.catalog.product.domain.repository;

import org.onlix.catalog.product.domain.entity.Product;
import org.onlix.catalog.product.enums.ProductDisplayStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByDisplayStatus(ProductDisplayStatus displayStatus);
}
