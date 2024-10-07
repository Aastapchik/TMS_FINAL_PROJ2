package myProj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/profi-user-login").setViewName("loginForm");
//    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/*").addResourceLocations("/WEB-INF/images/");

    }

}