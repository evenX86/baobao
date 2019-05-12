package com.alexura.baobao.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 6:39 PM
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(WebAppConfig.class);
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Autowired
    private AuthInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/doLogin")
                .excludePathPatterns("/doRegister")
                .excludePathPatterns("/register")
                .excludePathPatterns("/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.error("statuc : " + staticAccessPath);
        log.error("uploadFolder : " + uploadFolder);
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFolder);
    }
}
