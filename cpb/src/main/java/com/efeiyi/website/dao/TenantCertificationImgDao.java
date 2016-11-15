package com.efeiyi.website.dao;

import com.efeiyi.website.entity.TenantCertificationImg;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class TenantCertificationImgDao extends BaseDao<TenantCertificationImg> {
    @Override
    protected BaseRdDao getRdDao() {
        return new TenantCertificationImgRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new TenantCertificationImgDbDao();
    }

    private class TenantCertificationImgRdDao extends BaseRdDao<TenantCertificationImg> {}

    private class TenantCertificationImgDbDao extends BaseDbDao<TenantCertificationImg> {}

    public void getCertifiImgListByCertifiId(String certificationId, List<TenantCertificationImg> imgList, Connection conn)
            throws Exception {
        super.get("get_certification_img_by_certification_id", new Object[]{ certificationId }, imgList, conn);
    }
}
