package com.efeiyi.website.service.inter;

import com.efeiyi.website.entity.Coupon;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/1/23.
 */
public interface ICouponService {
    void addCoupon(Coupon coupon, Connection conn) throws Exception;
}
