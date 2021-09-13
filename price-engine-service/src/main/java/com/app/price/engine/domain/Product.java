package com.app.price.engine.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * The Product class.
 */
@Entity
@Table(name = "Product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "units_per_carton")
    private long unitsPerCarton;

    @Column(name = "carton_price")
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

}
