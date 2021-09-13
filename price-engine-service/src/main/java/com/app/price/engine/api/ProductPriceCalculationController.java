package com.app.price.engine.api;

import com.app.price.engine.dto.ProductDto;
import com.app.price.engine.dto.ProductPriceCalculateDto;
import com.app.price.engine.service.ProductPriceCalculateService;
import com.app.price.engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The ProductPriceCalculationController.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductPriceCalculationController {

    @Autowired
    private ProductPriceCalculateService productPriceCalculateService;


    /**
     * Calculate product price
     *
     * @param name                     : product name
     * @param productPriceCalculateDto : {productPriceCalculateDto}
     * @return : {productPriceCalculateDto}
     */
    @PostMapping(value = "/price/{name}")
    public ResponseEntity<ProductPriceCalculateDto> calculateProductPrice(@PathVariable(value = "name") String name
            , @RequestBody ProductPriceCalculateDto productPriceCalculateDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productPriceCalculateService.calculateProductPrice(name, productPriceCalculateDto));
    }
}
