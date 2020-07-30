package br.com.ijminfo.ms.webapp.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@ComponentScan()
        //basePackages = "br.com.ijminfo.ms")
    // includeFilters = @Filter(type = FilterType.REGEX, pattern="br.com.ijminfo.test.*,br.com.ijminfo.ms.webapp.*"/*"com.concretepage.*.*Util"*/),
//     ,excludeFilters = @Filter(type = FilterType.REGEX, pattern= {"br.com.ijminfo.ms.webapp.config.*WebSecurityConfig*"
//     		+ ",br.com.ijminfo.ms.*.config.*"
//    		 })

public class WebappConfig {

}
