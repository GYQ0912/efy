package com.efeiyi.website.dao;

import com.efeiyi.website.entity.TenantCertification;
import com.efeiyi.website.entity.TenantCertificationImg;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class TenantCertificationDao extends BaseDao<TenantCertification> {
    @Override
    protected BaseRdDao getRdDao() {
        return new TenantCertificationRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new TenantCertificationDbDao();
    }

    private class TenantCertificationRdDao extends BaseRdDao<TenantCertification> {}

    private class TenantCertificationDbDao extends BaseDbDao<TenantCertification> {}

    public void getCertificationListByTenantId(String tenantId, List<TenantCertification> certificationList, Connection conn)
            throws Exception {
        super.get("get_tenant_certification_by_tenant_id", new Object[]{ tenantId }, certificationList, conn);

        for(TenantCertification certification : certificationList) {
            TenantCertificationImgDao certificationImgDao = new TenantCertificationImgDao();
            List<TenantCertificationImg> certificationImgList = new ArrayList<>();
            certificationImgDao.getCertifiImgListByCertifiId(certification.getId(), certificationImgList, conn);
            certification.setImgList(certificationImgList);
        }
    }
}
