package com.app.price.engine.service;

import com.app.price.engine.dto.ProductPriceCalculateDto;

/**
 * The ProductPriceCalculateService.
 */
public interface ProductPriceCalculateService {

    ProductPriceCalculateDto calculateProductPrice(String productName, ProductPriceCalculateDto productPriceCalculateDto);
}
