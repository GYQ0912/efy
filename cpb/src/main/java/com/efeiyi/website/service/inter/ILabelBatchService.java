package com.efeiyi.website.service.inter;

import com.efeiyi.website.entity.LabelBatch;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
public interface ILabelBatchService {
    void getLabelBatchList(List<LabelBatch> labelBatchList) throws Exception;
}
