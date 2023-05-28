package com.kobuks.kiosk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.File;
import java.io.IOException;

@Configuration
    public class WebMvcConfig implements WebMvcConfigurer {

    // MultipartResolver 빈 등록
    @Bean
    public CommonsMultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8"); // 인코딩 설정
        File uploadDir = new File("C:/WorkDrive/workspace/upload/");
    /*
    해당 경로에 디렉토리가 없을 때는 새로 디렉토리를 생성해주고, 이미 디렉토리가 있을 때는
    그대로 메소드 실행
     */
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        else {
            multipartResolver.setUploadTempDir(new FileSystemResource("C:/WorkDrive/workspace/upload")); // 파일 업로드 임시 경로 설정
        }

        return multipartResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/login", "/logout");
    }

}
