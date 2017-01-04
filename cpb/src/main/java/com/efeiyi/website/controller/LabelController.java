package com.efeiyi.website.controller;

import com.efeiyi.website.dao.ConnectionPool;
import com.efeiyi.website.entity.Label;
import com.efeiyi.website.entity.Product;
import com.efeiyi.website.service.Session;
import com.efeiyi.website.service.inter.ILabelService;
import com.efeiyi.website.service.inter.IProductService;
import com.efeiyi.website.util.ApplicationException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        try {
            labelService.getLabelByCode(code, label, conn);
        } catch (Exception e) {
            ConnectionPool.get().free(conn);
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

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
        try {
            productService.getProductByPurchaseOrderLabelId(polId, product, conn);
        } catch (Exception e) {
            ConnectionPool.get().free(conn);
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        if(product.getId() == null) {
            responseEmpty(request, response);
            return;
        }

        ConnectionPool.get().free(conn);
        responseSuccess(request, response, product);
    }

    @RequestMapping("getUsableLabelList")
    public void getUsableLabelList(HttpServletRequest request, HttpServletResponse response) {
        List<Label> labelList = new ArrayList<>();
        JSONObject jsonObject = null;

        try {
            jsonObject = receiveJson(request);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        String labelBatchId = jsonObject.getString("labelBatchId");

        try {
            labelService.getLabelList(labelList, labelBatchId);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        if(labelList.size() == 0) {
            responseEmpty(request, response);
        } else {
            responseContent(request, response, labelList.get(0));
        }
    }

    @RequestMapping("writeCode")
    public void writeCode(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = null;
        JSONObject jsonObject = null;

        try {
            jsonObject = receiveJson(request);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        try {
            conn = ConnectionPool.get().getConnection();
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        String labelId = jsonObject.getString("labelId");
        String code = jsonObject.getString("code");

        Label label = null;
        try {
            label = labelService.getLabelByIdAndCode(labelId, code, conn);
        } catch (Exception e) {
            ConnectionPool.get().free(conn);
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        if(label != null && label.getId() != null) {
            ConnectionPool.get().free(conn);
            responseException(request, response, ApplicationException.WROTE_CODE_ERROR);
            return;
        }

        try {
            labelService.updateLabel(labelId, code, conn);
        } catch (MySQLIntegrityConstraintViolationException e) {
            ConnectionPool.get().free(conn);
            responseException(request, response, ApplicationException.WROTE_CODE_ERROR);
            return;
        } catch (Exception e) {
            ConnectionPool.get().free(conn);
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }

        ConnectionPool.get().free(conn);
        responseSuccess(request, response);
    }
}
