package com.efeiyi.website.service;

import com.efeiyi.website.dao.LabelDao;
import com.efeiyi.website.entity.Label;
import com.efeiyi.website.service.inter.ILabelService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
@Service
public class LabelService extends BaseService<Label> implements ILabelService {

    @Override
    public void getLabel(String id, Label label) throws Exception {
        LabelDao dao = new LabelDao();
        dao.get(id, label);
    }

    @Override
    public void getLabels(List<Label> list) throws Exception {
        LabelDao labelDao = new LabelDao();
        labelDao.get("get_all_label", new Object[]{}, list);
    }

    @Override
    public void getLabelByCode(String code, Label label, Connection conn) throws Exception {
        LabelDao labelDao = new LabelDao();
        labelDao.get("get_label_by_code", new Object[]{code}, label, conn);
    }

}
