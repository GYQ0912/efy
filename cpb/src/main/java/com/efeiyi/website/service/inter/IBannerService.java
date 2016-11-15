package com.efeiyi.website.service.inter;

import com.efeiyi.website.entity.Banner;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public interface IBannerService {
     void getBannerList(List<Banner> bannerList) throws Exception;
}
