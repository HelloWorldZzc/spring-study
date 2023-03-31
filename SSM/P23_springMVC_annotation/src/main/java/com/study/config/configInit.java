package com.study.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class configInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //指定spring的配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{springConfig.class};
    }
    //指定springMVC的配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {springMVCConfig.class};
    }
    //指定DispatcherServlet的映射规则，即url-pattern
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //添加过滤器（当成固定格式，固定的方法）
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceRequestEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
