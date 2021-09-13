package com.app.price.engine.service;

import com.app.price.engine.dto.ProductDto;

import java.util.List;

/**
 * The ProductService.
 */
public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);

    ProductDto getProductByName(String productName);

    ProductDto updateProductByName(String productName, ProductDto productDto);

    List<ProductDto> getAllProducts();
}
