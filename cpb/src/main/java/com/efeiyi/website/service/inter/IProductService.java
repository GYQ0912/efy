package com.efeiyi.website.service.inter;

import com.efeiyi.website.entity.Product;

import java.sql.Connection;

/**
 * Created by Administrator on 2016/10/26.
 */
public interface IProductService {

    void getProductByPurchaseOrderLabelId(String polId, Product product, Connection conn) throws Exception;
}
