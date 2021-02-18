package org.hino.sbb.config;

import org.apache.log4j.Logger;
import org.hino.sbb.controller.BusinessController;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final Logger logger = Logger.getLogger(AppInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("SBB start");
        return new Class[]{WebSecurityConfig.class, JPAConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //TODO HiddenHttpMethodFilter
        HiddenHttpMethodFilter hiddenHttpMethodFilter= new HiddenHttpMethodFilter();
        return new Filter[] {hiddenHttpMethodFilter, characterEncodingFilter};
    }

    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        DispatcherServlet dispatcher = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
        dispatcher.setThrowExceptionIfNoHandlerFound(true);
        return dispatcher;
    }

}