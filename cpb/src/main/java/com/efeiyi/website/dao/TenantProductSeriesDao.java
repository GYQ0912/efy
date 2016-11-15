package com.efeiyi.website.dao;

import com.efeiyi.website.entity.TenantProductSeries;
import com.efeiyi.website.entity.TenantProductSeriesImg;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class TenantProductSeriesDao extends BaseDao<TenantProductSeries> {
    @Override
    protected BaseRdDao getRdDao() {
        return new TenantProductSeriesRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new TenantProductSeriesDbDao();
    }

    private class TenantProductSeriesRdDao extends BaseRdDao<TenantProductSeries> {}

    private class TenantProductSeriesDbDao extends BaseDbDao<TenantProductSeries> {}

    public void getTenantProductSeriesByTenantId(String tenantId, List<TenantProductSeries> tenantProductSeriesList, Connection conn)
            throws Exception {
        super.get("get_tenant_product_series_by_tenant_id", new Object[]{ tenantId }, tenantProductSeriesList, conn);

        for(TenantProductSeries tenantProductSeries : tenantProductSeriesList) {
            TenantProductSeriesImgDao imgDao = new TenantProductSeriesImgDao();
            List<TenantProductSeriesImg> imgList = new ArrayList<>();
            imgDao.getTenantProductSeriesImgBySeriesId(tenantProductSeries.getId(), imgList, conn);
            if(imgList.size() > 0) {
                tenantProductSeries.setImgList(imgList);
            }
        }
    }
}
