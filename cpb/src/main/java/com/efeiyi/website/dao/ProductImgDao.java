package com.efeiyi.website.dao;

import com.efeiyi.website.entity.ProductImg;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ProductImgDao extends BaseDao<ProductImg>{
    @Override
    protected BaseRdDao getRdDao() {
        return new ProductImgRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new ProductImgDbDao();
    }

    private class ProductImgRdDao extends BaseRdDao<ProductImg> {}

    private class ProductImgDbDao extends BaseDbDao<ProductImg> {}

    public void getProductImgListByProductId(String productId, List<ProductImg> productImgList, Connection conn)
            throws Exception {
        super.get("get_product_img_by_product_id", new Object[]{ productId }, productImgList, conn);
    }
}
