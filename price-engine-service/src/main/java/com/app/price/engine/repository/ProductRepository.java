package com.app.price.engine.repository;

import com.app.price.engine.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The ProductRepository interface
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findByProductName(String productName);
}
