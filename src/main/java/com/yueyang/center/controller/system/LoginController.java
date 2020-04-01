package com.yueyang.center.controller.system;

import com.yueyang.center.enums.Anonymous;
import com.yueyang.center.utils.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.RandomString;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @program: center
 * @description: 登录
 * @author: qinxiangyang
 * @create: 2020-04-01 13:19
 **/
@Api(tags = "登录")
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {


    private static final String VERIFY_CODE_SESSION_NAME = "VERIFY_CODE";
    private static final int VERIFY_CODE_LENGTH = 4;

    /**
     * 生成验证码
     */
    @ApiOperation(value = "获取图片验证码", notes = "获取图片验证码")
    @GetMapping(value = "/verifycode")
    @Anonymous
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {

        String verifyCode = RandomString.get().randomNumeric(VERIFY_CODE_LENGTH);
        HttpSession session = request.getSession();
        session.setAttribute(VERIFY_CODE_SESSION_NAME, verifyCode);

        BufferedImage image = ImageUtil.generateVerifyCodeImage(verifyCode);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        try {
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            log.error("图片验证码返" +
                    "回失败", e);
        }
    }

}