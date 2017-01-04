package com.efeiyi.website.dao;

import com.efeiyi.website.entity.Label;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class LabelDao extends BaseDao<Label>{

    @Override
    protected BaseRdDao getRdDao() {
        return new LabelRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new LabelDbDao();
    }

    private class LabelRdDao extends BaseRdDao<Label> {
    }

    private class LabelDbDao extends BaseDbDao<Label> {
    }

    public void getAllLabel(List<Label> labelList) throws Exception {
        super.get("get_all_label", new Object[]{}, labelList);
    }

    public void getLabelByCode(String code, Label label, Connection conn) throws Exception {
        super.get("get_label_by_code", new Object[]{code}, label, conn);
    }

    public void getLabelList(List<Label> labelList, String labelBatchId,String status) throws Exception {
        super.get("get_label_by_batch_id", new Object[]{ labelBatchId, status}, labelList);
    }

    public void updateCodeById(String labelId, String code, String status, Connection conn) throws Exception {
        super.execute("update_code_of_label_by_id", new Object[]{labelId, code, status}, conn);
    }

    public Label getLabelByIdAndCode(String labelId, String code, Connection conn) throws Exception {
        Label label = new Label();
        get("get_label_by_id_and_code", new Object[]{labelId, code}, label, conn);
        return label;
    }

}
