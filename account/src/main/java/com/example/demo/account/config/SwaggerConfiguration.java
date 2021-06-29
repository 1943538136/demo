package com.example.demo.account.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                //.enable(swaggerEnabled)
                .select()
                .build()
                //.globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
        return docket;
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                //.title("公司角色(company)API")
                //创建人
                //.contact(new Contact("shangchaoshi", "http://jnyl.ott.pub/", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
