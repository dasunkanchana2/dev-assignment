package com.app.price.engine.dto;

import com.app.price.engine.domain.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The ProductDto class.
 */
public class ProductDto {

    @JsonProperty(required = false)
    private long id;

    private String productName;

    private long unitsPerCarton;

    private Double cartonPrice;

    /**
     * Get id
     *
     * @return : product id
     */
    public long getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id : product id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get product name
     *
     * @return : product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set product name
     *
     * @param productName : product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get units per carton
     *
     * @return : units per carton
     */
    public long getUnitsPerCarton() {
        return unitsPerCarton;
    }

    /**
     * Set units per carton
     *
     * @param unitsPerCarton : units per carton
     */
    public void setUnitsPerCarton(long unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }

    /**
     * Get carton price
     *
     * @return : carton price
     */
    public Double getCartonPrice() {
        return cartonPrice;
    }


    /**
     * Set carton price
     *
     * @param cartonPrice : carton price
     */
    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }


    /**
     * This method use to build {ProductDto} using {Product} model
     *
     * @param product : {Feature}
     * @return : {FeatureDto}
     */
    public ProductDto build(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.unitsPerCarton = product.getUnitsPerCarton();
        this.cartonPrice = product.getCartonPrice();
        return this;
    }
}
