package com.p2p.commons.core.config;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.p2p.commons.core.dto.CardInfo;
import com.p2p.commons.core.models.Card;

import static org.dozer.loader.api.FieldsMappingOptions.*;

/**
 * Initialize the Dozer mapper for application-wide use.
 * @author mbmartinez
 */
@Configuration
public class MapperConfig {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

    @PostConstruct
    public void init() {
        mapper().addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Card.class, CardInfo.class)
                    .fields("expansion.code", "expansion", oneWay());
            }
        });
    }
}
