package com.efeiyi.website.dao;

import com.efeiyi.website.entity.ProductSeries;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ProductSeriesDao extends BaseDao<ProductSeries> {
    @Override
    protected BaseRdDao getRdDao() {
        return new ProductSeriesRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new ProductSeriesDbDao();
    }

    private class ProductSeriesRdDao extends BaseRdDao<ProductSeries> {}

    private class ProductSeriesDbDao extends BaseDbDao<ProductSeries> {}
}
