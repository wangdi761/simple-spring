package com.isle.config.web;

import com.isle.config.data.DataConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by 61066 on 2017/12/27.
 */
@Configuration
@Import({DataConfig.class})
@ComponentScan(basePackages = "com.isle",
                excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
            })
public class RootConfig {

}
