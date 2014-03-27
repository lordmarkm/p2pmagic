//package com.p2p.admin.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.support.ResourcePropertySource;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.EnumSet;
//
///**
// * @author mbmartinez
// */
//public class AdminWebApplicationInitializer implements WebApplicationInitializer {
//
//    private static final Logger LOG = LoggerFactory.getLogger(AdminWebApplicationInitializer.class);
//
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        LOG.debug("Starting up web container: container={}", container);
//
//        //security
//        FilterRegistration.Dynamic springSecFilter = container.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
//        springSecFilter.setAsyncSupported(true);
//        springSecFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC), true, "/*");
//
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//
//        ctx.scan("com.medcurial.erx.apidoc.config");
//        ctx.scan("com.medcurial.erx.commons.**.config");
//        ctx.scan("com.medcurial.erx.admin.*.config");
//
//        try {
//            ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:application.properties"));
//        } catch (IOException e) {
//            throw new ServletException(e);
//        }
//
//        container.addListener(new ContextLoaderListener(ctx));
//
//        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(ctx));
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//    }
//
//}
