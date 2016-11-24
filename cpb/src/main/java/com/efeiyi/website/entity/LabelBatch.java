package com.efeiyi.website.entity;

import java.util.Date;

public class LabelBatch extends Entity {

    private String id;
    private String setting;//标签批次
    private String serial;//批次序号
    private Integer amount;//标签数量
    private Date createDate;
    private String status;//1.待生成  2.已生成
    private String type; //1.二维码  2.NFC标签

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
