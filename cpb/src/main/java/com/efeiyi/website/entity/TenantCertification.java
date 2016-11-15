package com.efeiyi.website.entity;

import java.util.Date;
import java.util.List;

public class TenantCertification extends Entity {

    private String id;
    private String tenantId;
    private String name;//认证证书
    private String org;//认证机构
    private Date theDate;//认证时间
    private String level;
    private String imgUrl;
    private String status;
    private List<TenantCertificationImg> imgList;
    private List<TenantProductSeries> tenantProductSeriesList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TenantCertificationImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<TenantCertificationImg> imgList) {
        this.imgList = imgList;
    }

    public List<TenantProductSeries> getTenantProductSeriesList() {
        return tenantProductSeriesList;
    }

    public void setTenantProductSeriesList(List<TenantProductSeries> tenantProductSeriesList) {
        this.tenantProductSeriesList = tenantProductSeriesList;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
