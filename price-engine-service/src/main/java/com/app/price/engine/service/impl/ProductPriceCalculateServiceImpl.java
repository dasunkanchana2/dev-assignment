package com.app.price.engine.service.impl;

import com.app.price.engine.domain.Product;
import com.app.price.engine.dto.ProductDto;
import com.app.price.engine.dto.ProductPriceCalculateDto;
import com.app.price.engine.exception.EntityNotFoundException;
import com.app.price.engine.repository.ProductRepository;
import com.app.price.engine.service.ProductPriceCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The ProductPriceCalculateServiceImpl class.
 */
@Service
public class ProductPriceCalculateServiceImpl implements ProductPriceCalculateService {

    @Autowired
    private ProductRepository productRepository;

    private final static int LABOUR_TAX = 30;

    /**
     * Calculate product price
     *
     * @param productName              : product name
     * @param productPriceCalculateDto : {ProductPriceCalculateDto}
     * @return : {ProductPriceCalculateDto}
     */
    @Override
    public ProductPriceCalculateDto calculateProductPrice(String productName,
                                                          ProductPriceCalculateDto productPriceCalculateDto) {
        Optional<Product> product = productRepository.findByProductName(productName);
        if (product.isPresent()) {
            if (productPriceCalculateDto.getProductQty() != product.get().getUnitsPerCarton()) {
                productPriceCalculateDto.setProductPrice(addLabourCostForCartonPrice(
                        product.get().getCartonPrice(),
                        product.get().getUnitsPerCarton()));
            }else{
                productPriceCalculateDto.setProductPrice(product.get().getCartonPrice());
            }
            return productPriceCalculateDto;
        } else {
            throw new EntityNotFoundException();
        }
    }

    /**
     * Add labour cost for carton price
     *
     * @param cartonPrice    : carton price
     * @param unitsPerCarton : units per carton
     * @return : product price + labour cost
     */
    private Double addLabourCostForCartonPrice(double cartonPrice, long unitsPerCarton) {
        return ((cartonPrice * LABOUR_TAX / 100) + cartonPrice )/ unitsPerCarton;
    }
}
