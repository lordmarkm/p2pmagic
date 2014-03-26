package com.p2p.apidoc.config;

import com.fasterxml.classmate.TypeResolver;
import com.mangofactory.swagger.configuration.DocumentationConfig;
import com.mangofactory.swagger.configuration.ExtensibilityModule;
import com.mangofactory.swagger.models.AlternateTypeProcessingRule;
import com.mangofactory.swagger.models.TypeProcessingRule;
import com.mangofactory.swagger.models.WildcardType;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Properties;

/**
 * @author mbmartinez
 */
@Configuration
@Import(DocumentationConfig.class)
public class CustomDocumentConfig implements ServletContextAware {

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * Configure swagger properties.
     *
     * @return the {@link PropertyPlaceholderConfigurer}
     */
    @Bean
    public PropertyPlaceholderConfigurer swaggerProperties() {
        Properties properties = new Properties();
        properties.setProperty("documentation.services.basePath", servletContext.getContextPath());
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setProperties(properties);
        configurer.setLocation(new ClassPathResource("swagger.properties"));
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

    /**
     * Convert {@link ResponseEntity} documentation to its generic type.
     *
     * @return the {@link ExtensibilityModule}
     */
    @Bean
    public ExtensibilityModule extensibilityModule() {
        return new ExtensibilityModule() {
            @Override
            protected void customizeTypeProcessingRules(List<TypeProcessingRule> rules) {
                rules.add(responseEntity());
            }
        };
    }

    private static AlternateTypeProcessingRule responseEntity() {
        final TypeResolver resolver = new TypeResolver();
        return AlternateTypeProcessingRule.alternate(resolver.resolve(ResponseEntity.class, WildcardType.class),
                resolver.resolve(WildcardType.class));
    }

}
