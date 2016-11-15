package com.efeiyi.website.dao;

import com.efeiyi.website.entity.Product;

import java.sql.Connection;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ProductDao extends BaseDao<Product> {
    @Override
    protected BaseRdDao getRdDao() {
        return new ProductRdDao();
    }

    @Override
    protected BaseDbDao getDbDao() {
        return new ProductDbDao();
    }

    private class ProductRdDao extends BaseRdDao<Product> {}

    private class ProductDbDao extends BaseDbDao<Product> {}

    public void getProductByPurchaseOrderLabelId(String polId, Product product, Connection conn) throws Exception {
        super.get("get_product_by_purchase_order_label_id", new Object[]{ polId }, product, conn);
    }
}
