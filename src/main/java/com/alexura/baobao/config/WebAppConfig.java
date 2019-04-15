package com.alexura.baobao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 6:39 PM
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        //registry.addInterceptor(authInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/loginSys").excludePathPatterns("/static/**");
    }


}
