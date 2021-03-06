package com.efeiyi.website.service.inter;

import com.efeiyi.website.entity.Label;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public interface ILabelService {

    void getLabel(String id, Label label) throws Exception;

    void getLabels(List<Label> list) throws Exception;

    void getLabelByCode(String code, Label label, Connection conn) throws Exception;
}
