package com.efeiyi.website.dao;

import com.efeiyi.website.entity.TenantProductSeriesImg;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class TenantProductSeriesImgDao extends BaseDao<TenantProductSeriesImg> {
    @Override
    protected BaseRdDao getRdDao() {
        return new TenantProductSeriesImgRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new TenantProductSeriesImgDbDao();
    }

    private class TenantProductSeriesImgRdDao extends BaseRdDao<TenantProductSeriesImg> {}

    private class TenantProductSeriesImgDbDao extends BaseDbDao<TenantProductSeriesImg> {}

    public void getTenantProductSeriesImgBySeriesId(String seriesId, List<TenantProductSeriesImg> imgList, Connection conn)
            throws Exception {
        super.get("get_tenant_product_series_img_by_series_id", new Object[]{ seriesId }, imgList, conn);
    }
}
