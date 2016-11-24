package com.efeiyi.website.controller;

import com.efeiyi.website.entity.LabelBatch;
import com.efeiyi.website.service.LabelBatchService;
import com.efeiyi.website.util.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
@Controller
@RequestMapping("labelBatch")
public class LabelBatchController extends BaseController {

    @Autowired
    LabelBatchService labelBatchService;

    @RequestMapping("getLabelBatchList")
    public void getLabelBatchList(HttpServletRequest request, HttpServletResponse response) {
        List<LabelBatch> labelBatchList = new ArrayList<>();

        try {
            labelBatchService.getLabelBatchList(labelBatchList);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }
        responseContent(request, response, labelBatchList);
    }
}
