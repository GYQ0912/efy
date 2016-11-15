package com.efeiyi.website.dao;

import com.efeiyi.website.entity.OrganizationTenant;
import com.efeiyi.website.entity.TenantCertification;
import com.efeiyi.website.entity.TenantProductSeries;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class TenantDao extends BaseDao<OrganizationTenant> {
    @Override
    protected BaseRdDao getRdDao() {
        return new TenantRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new TenantDbDao();
    }

    private class TenantRdDao extends BaseRdDao<OrganizationTenant> {}

    private class TenantDbDao extends BaseDbDao<OrganizationTenant> {}

    public void getTenant(String tenantId, OrganizationTenant tenant, Connection conn) throws Exception {
        super.get(tenantId, conn, tenant);

        if(tenant.getId() != null) {
            TenantCertificationDao tenantCertificationDao = new TenantCertificationDao();
            List<TenantCertification> tenantCertificationList = new ArrayList<>();
            tenantCertificationDao.getCertificationListByTenantId(tenant.getId(), tenantCertificationList, conn);
            if(tenantCertificationList.size() > 0) {
                tenant.setTenantCertificationList(tenantCertificationList);
            }
        }

        if(tenant.getId() != null) {
            TenantProductSeriesDao tenantProductSeriesDao = new TenantProductSeriesDao();
            List<TenantProductSeries> tenantProductSeriesList = new ArrayList<>();
            tenantProductSeriesDao.getTenantProductSeriesByTenantId(tenant.getId(), tenantProductSeriesList, conn);
            if(tenantProductSeriesList.size() > 0) {
                tenant.setTenantProductSeriesList(tenantProductSeriesList);
            }
        }
    }
}
