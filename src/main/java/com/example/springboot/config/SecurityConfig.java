package com.example.springboot.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests()
            //.antMatchers(HttpMethod.GET, "/outbound/nfe/danfe/**").permitAll()
            .anyRequest().permitAll()
            ;
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            //permite o mule acessar o danfe sem precisar de autenticacao
            .antMatchers(HttpMethod.GET, "/outbound/nfe/danfe/**")
            //Imagem do Danfe na tela de empresa
            .antMatchers(HttpMethod.GET, "/companies/image-danfe/**")
            //allow access to html pages
            .antMatchers("/")
            .antMatchers("/**/**")
            .antMatchers("/index.html")
            .antMatchers("/assets/**/*.*")
            .antMatchers("/**/*.js")
            .antMatchers("/**/*.css")
            //Swagger
            .antMatchers(
                    "/v2/api-docs",
                    "/configuration/ui/**",
                    "/swagger-resources/**",
                    "/configuration/security/**",
                    "/swagger-ui.html",
                    "/webjars/**")
            
            ;

    }


//    @Bean
//    public SecurityConfiguration scurity(){
//        return new springfox.documentation.swagger.web.SecurityConfiguration(
//                null, null, null,
//                "myapp-api",
//                "access_token",
//                ApiKeyVehicle.QUERY_PARAM,
//                "access_token",
//                null);
//    }
}
