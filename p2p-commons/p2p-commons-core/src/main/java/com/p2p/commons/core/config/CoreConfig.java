package com.p2p.commons.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author mbmartinez
 */
@Configuration
@ComponentScan(basePackages = {
        "com.p2p.commons.data"
})
@EnableJpaRepositories(basePackages = {
        "com.baldy.commons.security.services",
        "com.p2p.commons.*.repo"
})
public class CoreConfig {

}
