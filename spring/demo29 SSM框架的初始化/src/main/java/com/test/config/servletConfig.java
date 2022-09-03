package com.test.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class servletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{springConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{springmvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
