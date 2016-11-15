package com.efeiyi.website.service;

import com.efeiyi.website.entity.Banner;
import com.efeiyi.website.service.inter.IBannerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
@Service
public class BannerService implements IBannerService {
    String[] strArr = {"关山香炉 http://pro.efeiyi.com/banner/20160608171718_关山香炉banner.jpg",
                       "筷子 http://pro.efeiyi.com/banner/20160608171947_筷子banner.jpg",
                       "谭广辉 http://pro.efeiyi.com/banner/20161009194117_首页banner.jpg"};

    @Override
    public void getBannerList(List<Banner> bannerList) throws Exception {
        for(int i = 0; i < strArr.length; i ++) {
            String[] parts = strArr[i].split(" ");
            Banner banner = new Banner();
            banner.setTitle(parts[0]);
            banner.setImgUrl(parts[1]);
            bannerList.add(banner);
        }
    }

}
