package com.shangguigu.bstest.config;

import com.shangguigu.bstest.component.LoginHandlerInterceptor;
import com.shangguigu.bstest.component.MyLocaleResolver;
import com.shangguigu.bstest.component.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * @author shkstart
 * @create 2020-01-07 16:21
 *
 * Configuration 自动配置类  要继承 WebMvcConfigurerAdapter
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry （映射） 浏览器发送 /atguigu 跳到login
        registry.addViewController("/jiang").setViewName("login");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                //防止表单重复提交用重定向
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                /**拦截所有时，避免静态资源被拦截"/static/**" 要在application.properties中加个路径
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/login.html","/user/login","/static/**");
            }
        };

        return webMvcConfigurerAdapter;
    }

    @Bean //用Bean加入自动配置
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //用于前段传来的Date绑定Bean时转换
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void initEditableValidation(){
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService()!=null){
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new StringToDateConverter());
        }
    }
}
