package com.app.price.engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The ProductPriceCalculateDto.
 */
public class ProductPriceCalculateDto {

    private int productQty;

    @JsonProperty(required = false)
    private double productPrice;

    /**
     * Get product qty
     *
     * @return : product qty
     */
    public int getProductQty() {
        return productQty;
    }

    /**
     * Set product qty
     *
     * @param productQty : product qty
     */
    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }


    /**
     * Get product price
     *
     * @return : product price
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Set product price
     *
     * @param productPrice : product price
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
