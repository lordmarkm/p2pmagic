package com.p2p.admin.cm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.p2p.admin.cm.parser.GathererParser;

/**
 * @author mbmartinez
 */
@Configuration
@ComponentScan(basePackages = {"com.p2p.admin.cm"})
public class CardManagementConfig {

    @Bean
    public GathererParser websiteParser() {
        return new GathererParser();
    }

}
