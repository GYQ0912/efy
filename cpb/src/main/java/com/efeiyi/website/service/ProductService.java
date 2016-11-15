package com.efeiyi.website.service;

import com.efeiyi.website.dao.ProductDao;
import com.efeiyi.website.dao.ProductImgDao;
import com.efeiyi.website.dao.ProductSeriesDao;
import com.efeiyi.website.dao.TenantDao;
import com.efeiyi.website.entity.Product;
import com.efeiyi.website.entity.ProductImg;
import com.efeiyi.website.entity.ProductSeries;
import com.efeiyi.website.entity.OrganizationTenant;
import com.efeiyi.website.service.inter.IProductService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */

@Service
public class ProductService extends BaseService<Product> implements IProductService{

    @Override
    public void getProductByPurchaseOrderLabelId(String polId, Product product, Connection conn) throws Exception {
        ProductDao productDao = new ProductDao();
        productDao.getProductByPurchaseOrderLabelId(polId, product, conn);

        if(product.getProductSeriesId() != null) {
            ProductSeriesDao productSeriesDao = new ProductSeriesDao();
            ProductSeries productSeries = new ProductSeries();
            productSeriesDao.get(product.getProductSeriesId(), conn, productSeries);
            if(productSeries.getId() != null) {
                product.setProductSeries(productSeries);
            }
        }

        if(product.getId() != null) {
            ProductImgDao productImgDao = new ProductImgDao();
            List<ProductImg> productImgList = new ArrayList<>();
            productImgDao.getProductImgListByProductId(product.getId(), productImgList, conn);
            if(productImgList.size() > 0) {
                product.setImgList(productImgList);
            }
        }

        if(product.getTenantId() != null) {
            TenantDao tenantDao = new TenantDao();
            OrganizationTenant tenant = new OrganizationTenant();
            tenantDao.getTenant(product.getTenantId(), tenant, conn);
            if(tenant.getId() != null) {
                product.setTenant(tenant);
            }
        }

    }
}
