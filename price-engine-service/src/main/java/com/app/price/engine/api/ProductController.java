package com.app.price.engine.api;

import com.app.price.engine.dto.ProductDto;
import com.app.price.engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ProductController.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * Save Product
     *
     * @param productDto : {ProductDto}
     * @return {ResponseEntity<ProductDto>}
     */
    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productDto));
    }


    /**
     * Get all products
     *
     * @return : List {ProductDto}
     */
    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(Model model) {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    /**
     * Get product by name
     *
     * @param name : product name
     * @return : {ProductDto}
     */
    @GetMapping(value = "/product")
    public ResponseEntity<ProductDto> getProductByName(
            @RequestParam(name = "name", required = true) String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }


    /**
     * Update product by name
     *
     * @param name : product name
     * @return : {ProductDto}
     */
    @PutMapping(value = "/product")
    public ResponseEntity<ProductDto> updateProductByName(
            @RequestParam(name = "name", required = true) String name, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProductByName(name, productDto));
    }
}
