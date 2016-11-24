package com.efeiyi.website.service;

import com.efeiyi.website.dao.LabelBatchDao;
import com.efeiyi.website.entity.LabelBatch;
import com.efeiyi.website.service.inter.ILabelBatchService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
@Service
public class LabelBatchService implements ILabelBatchService {
    @Override
    public void getLabelBatchList(List<LabelBatch> labelBatchList) throws Exception {
        LabelBatchDao labelBatchDao = new LabelBatchDao();
        labelBatchDao.getLabelBatchList(labelBatchList);
    }
}
