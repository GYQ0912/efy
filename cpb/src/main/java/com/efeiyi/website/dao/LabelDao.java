package com.efeiyi.website.dao;

import com.efeiyi.website.entity.Label;

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
}
