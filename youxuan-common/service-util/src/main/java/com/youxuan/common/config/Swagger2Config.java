package com.youxuan.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 *
 * swagger2 配置类
 */
@Configuration
@EnableSwagger2WebMvc // 开启swagger2 api接口规范框架
public class Swagger2Config {

    //1 管理 用户api接口
    @Bean
    public Docket webApiConfig(){
        List<Parameter> pars = new ArrayList();
        ParameterBuilder tokenPar = new ParameterBuilder();
        // 接口 请求的公共信息
        tokenPar.name("userId")
                .description("用户token")
                //.defaultValue(JwtHelper.createToken(1L, "admin"))
                .defaultValue("1")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        // webApi 用户接口
        Docket webApi = new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //只显示api路径下的页面
                .apis(RequestHandlerSelectors.basePackage("com.youxuan"))
                //过滤 只显示 /api/ 的url接口
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .globalOperationParameters(pars);
        return webApi;
    }


    //2 管理 管理员api接口
    @Bean
    public Docket adminApiConfig(){
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("adminId")
                .description("管理员token")
                .defaultValue("1")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        // adminApi 管理员接口
        Docket adminApi = new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                //过滤 只显示 /admin/ 的url接口
                .apis(RequestHandlerSelectors.basePackage("com.youxuan"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build()
                .globalOperationParameters(pars);
        return adminApi;
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了youxuan网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("youxuan", "http://youxuan.com", "youxuan"))
                .build();
    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了youxuan后台系统服务接口定义")
                .version("1.0")
                .contact(new Contact("youxuan", "http://youxuan.com", "youxuan"))
                .build();
    }
}
