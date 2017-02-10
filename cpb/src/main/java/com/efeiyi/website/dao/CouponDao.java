package com.efeiyi.website.dao;

import com.efeiyi.website.entity.Coupon;

/**
 * Created by Administrator on 2017/1/23.
 */
public class CouponDao extends BaseDao<Coupon> {
    @Override
    protected BaseRdDao getRdDao() {
        return new CouponRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new CouponDbDao();
    }

    private class CouponRdDao extends BaseRdDao<Coupon> {

    }

    private class CouponDbDao extends BaseDbDao<Coupon> {

    }
}
