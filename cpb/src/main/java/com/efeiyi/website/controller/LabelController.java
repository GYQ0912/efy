package com.efeiyi.website.controller;

import com.efeiyi.website.dao.ConnectionPool;
import com.efeiyi.website.entity.Label;
import com.efeiyi.website.entity.Product;
import com.efeiyi.website.service.inter.ILabelService;
import com.efeiyi.website.service.inter.IProductService;
import com.efeiyi.website.util.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
@Controller
@RequestMapping("label")
public class LabelController extends BaseController {

    @Autowired
    ILabelService labelService;

    @Autowired
    IProductService productService;

    @RequestMapping("getLabel")
    public void getLabel(HttpServletRequest request, HttpServletResponse response) {
        Label label = new Label();
        try {
            labelService.getLabel(request.getParameter("id"), label);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }
        responseContent(request, response, label);
    }

    @RequestMapping("getLabels")
    public void getLabels(HttpServletRequest request, HttpServletResponse response) {
        List<Label> list = new ArrayList<>();
        try {
            labelService.getLabels(list);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }
    }

    @RequestMapping("checkLabel")
    public void checkLabel(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = null;
        Label label = new Label();

        String code = request.getParameter("code");

        try {
            conn = ConnectionPool.get().getConnection();

            labelService.getLabelByCode(code, label, conn);

            if(label.getId() == null) {
                responseEmpty(request, response);
                return;
            }

            String polId = label.getPurchaseOrderLabelId();

            if(polId == null) {
                responseEmpty(request, response);
                return;
            }

            Product product = new Product();
            productService.getProductByPurchaseOrderLabelId(polId, product, conn);

            if(product.getId() == null) {
                responseEmpty(request, response);
                return;
            }

            responseSuccess(request, response, product);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        } finally {
            ConnectionPool.get().free(conn);
        }

    }

    public static void main(String[] args) {
        System.out.print("main");
    }
}
