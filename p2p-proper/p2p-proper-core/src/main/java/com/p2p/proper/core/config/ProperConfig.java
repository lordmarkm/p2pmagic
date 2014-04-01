package com.p2p.proper.core.config;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.p2p.proper.core.dto.MagicPlayerInfo;
import com.p2p.proper.core.models.MagicPlayer;

/**
 * @author mbmartinez
 */
@Configuration
public class ProperConfig {

    @Autowired
    private DozerBeanMapper mapper;
    
    @PostConstruct
    public void init() {
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(MagicPlayer.class, MagicPlayerInfo.class)
                    .fields("account.username", "username");
            }
        });
    }
}
