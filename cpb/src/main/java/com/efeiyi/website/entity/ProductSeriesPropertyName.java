package com.efeiyi.website.entity;

public class ProductSeriesPropertyName extends Entity {

    private String id;
    private String productSeriesId;
    private String name;
    private String status;
    private ProductPropertyValue productPropertyValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductSeriesId() {
        return productSeriesId;
    }

    public void setProductSeriesId(String productSeriesId) {
        this.productSeriesId = productSeriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductPropertyValue getProductPropertyValue() {
        return productPropertyValue;
    }

    public void setProductPropertyValue(ProductPropertyValue productPropertyValue) {
        this.productPropertyValue = productPropertyValue;
    }
}
