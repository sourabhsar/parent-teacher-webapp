package com.sourabh.pt.configuration;

import com.sourabh.pt.coremodel.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sourabh on 7/20/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.sourabh.pt.controller"})
public class PTWebApiConfig extends WebMvcConfigurerAdapter {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TestBean testBean() {
        return new TestBean("sourabh");
    }
}
