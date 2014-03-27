package com.p2p.admin.http.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.baldy.commons.web.config", "com.p2p.admin.http"})
@PropertySource({"classpath:app.properties"})
@EnableAspectJAutoProxy
public class AdminHttpConfig extends WebMvcConfigurerAdapter {

}
