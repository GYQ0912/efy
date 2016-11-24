package com.efeiyi.website.dao;

import com.efeiyi.website.entity.LabelBatch;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
public class LabelBatchDao extends BaseDao<LabelBatch> {
    @Override
    protected BaseRdDao getRdDao() {
        return new LabelBatchRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new LabelBatchDbDao();
    }

    private class LabelBatchRdDao extends BaseRdDao<LabelBatch> {

    }

    private class LabelBatchDbDao extends BaseDbDao<LabelBatch> {

    }

    public void getLabelBatchList(List<LabelBatch> labelBatchList) throws Exception {
        super.get("get_label_batch_list", new Object[]{}, labelBatchList);
    }
}
