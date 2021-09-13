package com.app.price.engine.service.impl;


import com.app.price.engine.domain.Product;
import com.app.price.engine.dto.ProductDto;
import com.app.price.engine.exception.EntityNotFoundException;
import com.app.price.engine.repository.ProductRepository;
import com.app.price.engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The ProductServiceImpl class.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Save product
     *
     * @param productDto : {ProductDto}
     * @return : {ProductDto}
     */
    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setCartonPrice(productDto.getCartonPrice());
        product.setUnitsPerCarton(productDto.getUnitsPerCarton());
        productRepository.save(product);
        return new ProductDto().build(product);
    }

    /**
     * Get product by Name
     *
     * @param productName : product name
     * @return : {ProductDto}
     */
    @Override
    public ProductDto getProductByName(String productName) {
        Optional<Product> product = productRepository.findByProductName(productName);
        if (product.isPresent()) {
            return new ProductDto().build(product.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

    /**
     * Update product by name
     *
     * @param productName : product name
     * @param productDto  : {ProductDto}
     * @return : {ProductDto}
     */
    @Override
    public ProductDto updateProductByName(String productName, ProductDto productDto) {
        Optional<Product> product = productRepository.findByProductName(productName);
        if (product.isPresent()) {
            product.get().setProductName(productDto.getProductName());
            product.get().setCartonPrice(productDto.getCartonPrice());
            product.get().setUnitsPerCarton(productDto.getUnitsPerCarton());
            productRepository.save(product.get());
            return new ProductDto().build(product.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

    /**
     * Get all products
     *
     * @return : List => {ProductDto}
     */
    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productList = new ArrayList<>();
        productRepository.findAll().forEach(product ->
                productList
                        .add(buildProductDto(product)));
        return productList;
    }

    /**
     * Build product dto
     *
     * @param product : {Product}
     * @return : {ProductDto}
     */
    private ProductDto buildProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setCartonPrice(product.getCartonPrice());
        productDto.setUnitsPerCarton(product.getUnitsPerCarton());
        return productDto;
    }
}
