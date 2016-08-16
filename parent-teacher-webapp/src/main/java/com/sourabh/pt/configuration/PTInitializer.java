package com.sourabh.pt.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Sourabh on 7/20/2016.
 */
public class PTInitializer implements WebApplicationInitializer {

    private static final String API_WILDCARD = "/*";
    private final AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        dispatcherServlet.setDispatchOptionsRequest(true);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",dispatcherServlet);
        servlet.addMapping(API_WILDCARD);
        servlet.setLoadOnStartup(1);
        ctx.register(com.sourabh.pt.configuration.PTWebApiConfig.class,
                MongoConfiguration.class,HibernateConfiguration.class);
    }
}
