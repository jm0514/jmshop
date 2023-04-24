package com.shop.jmshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //Spring MVC에서 정적 파일의 경로를 설정하는 코드
    @Value("${uploadPath}")
    String uploadPath;

    //URL이 "/images/" 패턴으로 요청이 들어올 경우 uploadPath의 경로를 기준으로 정적 파일을 찾아서 응답
    //ItemImgService에서 imgUrl을 "/images/item" + 이미지 이름으로 지정했기 때문에 "D:/study/shop/item" 경로에서 파일을 찾음
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);
    }
}
