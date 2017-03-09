package com.efeiyi.website.controller;

import com.efeiyi.website.dao.ConnectionPool;
import com.efeiyi.website.entity.Coupon;
import com.efeiyi.website.service.CouponService;
import com.efeiyi.website.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/22.
 */

@Controller
@RequestMapping("coupon")
public class CouponController extends BaseController {

    @Autowired
    CouponService couponService;

    @RequestMapping("getCoupon")
    public void getCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection conn = ConnectionPool.get().getConnection();
        int num = 398;

        conn.setAutoCommit(false);
        try {

            for(int i = 0; i < num; i ++) {
                String s = getRandomString(18);

                Coupon coupon = new Coupon();
                coupon.setCode(s);
                coupon.setStatus("0");
                couponService.addCoupon(coupon, conn);

                generateImage(s);
            }

            System.out.print("success");
        } catch (Exception e) {
            throw e;
        } finally {
            conn.setAutoCommit(true);
            ConnectionPool.get().free(conn);
        }

        responseSuccess(request, response);
    }


    public static void generateImage(String text) throws Exception{
        File file = new File("D:\\coupon.jpg");
        BufferedImage image = ImageIO.read(file);
        Graphics g11 = image.getGraphics();
        // 设置颜色
        g11.setColor(Color.BLACK);
        Font font11 = new Font("微软雅黑", Font.PLAIN, 20);
        g11.setFont(font11);
        // 输出文字
        g11.drawString(text, 217, 731 + font11.getSize());
        // 输出数据流

        File imageFile = new File("d:\\coupon\\" + text + ".jpg");
        ImageIO.write(image, "jpg", imageFile);
    }

    public static void generateCoupon(int num) throws Exception {
        for(int i = 0; i < num; i ++) {
            String s = UUIDGenerator.generateCouponCode().toUpperCase();
            s = s.replace("0", "A");
            s = s.replace("O", "B");
            generateImage(s);
        }
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "ABCDEFGHJKLNPQRSTUVXYZ23456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

    }

}
