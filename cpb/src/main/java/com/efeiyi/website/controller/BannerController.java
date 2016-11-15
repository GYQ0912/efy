package com.efeiyi.website.controller;

import com.efeiyi.website.entity.Banner;
import com.efeiyi.website.service.BannerService;
import com.efeiyi.website.util.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
@Controller
@RequestMapping("banner")
public class BannerController extends BaseController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("getBannerList")
    public void getBannerList(HttpServletRequest request, HttpServletResponse response) {
        List<Banner> bannerList = new ArrayList<>();
        try {
            bannerService.getBannerList(bannerList);
        } catch (Exception e) {
            responseException(request, response, ApplicationException.INNER_ERROR);
            return;
        }
        responseContent(request, response, bannerList);
    }

}
