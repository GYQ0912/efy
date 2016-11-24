package com.efeiyi.website.entity;

import java.util.Date;
import java.util.List;

public class Label extends Entity {
    private String id;
    private long serial;//序列号
    private String code;//防伪码
    private String labelBatchId;
    private String tenantId;
    private String status;//1.未分配  2.已分配  3.已激活  4.已作废
    private Date firstCheckDateTime;
    private Date lastCheckDateTime;
    private int checkCount;
    private String purchaseOrderLabelId;
    private List<LabelCheckRecord> labelCheckRecordList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFirstCheckDateTime() {
        return firstCheckDateTime;
    }

    public void setFirstCheckDateTime(Date firstCheckDateTime) {
        this.firstCheckDateTime = firstCheckDateTime;
    }

    public Date getLastCheckDateTime() {
        return lastCheckDateTime;
    }

    public void setLastCheckDateTime(Date lastCheckDateTime) {
        this.lastCheckDateTime = lastCheckDateTime;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(int checkCount) {
        this.checkCount = checkCount;
    }

    public List<LabelCheckRecord> getLabelCheckRecordList() {
        return labelCheckRecordList;
    }

    public void setLabelCheckRecordList(List<LabelCheckRecord> labelCheckRecordList) {
        this.labelCheckRecordList = labelCheckRecordList;
    }

    public String getLabelBatchId() {
        return labelBatchId;
    }

    public void setLabelBatchId(String labelBatchId) {
        this.labelBatchId = labelBatchId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPurchaseOrderLabelId() {
        return purchaseOrderLabelId;
    }

    public void setPurchaseOrderLabelId(String purchaseOrderLabelId) {
        this.purchaseOrderLabelId = purchaseOrderLabelId;
    }
}
