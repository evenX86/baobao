package com.alexura.baobao.config;

import com.alexura.baobao.core.Result;
import com.alexura.baobao.enums.ResultCode;
import com.alexura.baobao.utils.JsonUtil;
import com.alexura.baobao.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with baobao
 * 权限拦截器
 *
 * @author xuyifei
 * @date 2019-04-14 6:53 PM
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证签名
        //boolean pass = validateSign(request);
        boolean pass = true;
        if (pass) {
            return true;
        } else {
            log.error("签名认证失败");
            /*log.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}",
                    request.getRequestURI(), getIpAddress(request), JsonUtil.write2JsonStr(request.getParameterMap()));

            Result result = ResultUtil.buildFailResult(ResultCode.UNAUTHORIZED);
            responseResult(response, result);
            */return false;
        }
    }
    /**
     * 一个简单的签名认证，规则：
     * 1. 将请求参数按ascii码排序
     * 2. 拼接为a=value&b=value...这样的字符串（不包含sign）
     * 3. 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
     */
    private boolean validateSign(HttpServletRequest request) {
        //获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
        String requestSign = request.getParameter("sign");
        if (StringUtils.isEmpty(requestSign)) {
            return false;
        }
        List<String> keys = new ArrayList<String>(request.getParameterMap().keySet());
        //排除sign参数
        keys.remove("sign");
        //排序
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            //拼接字符串
            sb.append(key).append("=").append(request.getParameter(key)).append("&");
        }
        String linkString = sb.toString();
        //去除最后一个'&'
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);
        // 加盐
        String secret = "Potato";
        //String sign = DigestUtils.md5Hex(linkString + secret);//混合密钥md5
        String sign = "";
        //return StringUtils.equals(sign, requestSign);//比较

        return true;
    }
}
