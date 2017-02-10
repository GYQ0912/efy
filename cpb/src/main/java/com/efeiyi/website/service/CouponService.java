package com.efeiyi.website.service;

import com.efeiyi.website.dao.CouponDao;
import com.efeiyi.website.entity.Coupon;
import com.efeiyi.website.service.inter.ICouponService;
import org.springframework.stereotype.Service;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/1/23.
 */
@Service
public class CouponService implements ICouponService {

    @Override
    public void addCoupon(Coupon coupon, Connection conn) throws Exception {
        CouponDao dao = new CouponDao();
        dao.add(coupon, conn);
    }
}
