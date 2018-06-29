package com.guoguo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author: liuda
 * @CreateDate: 2018/6/29 12:54
 * @Description:
 * web容器中进行部署
 */
public class GuoGuoServletInitializer  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(GuoguoApplication.class);
    }
}
