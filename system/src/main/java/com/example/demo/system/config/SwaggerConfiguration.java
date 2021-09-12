package com.example.demo.system.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    //Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("cn.jn.retail.companyservice.controller");
    //Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("cn.jn.retail.shiro.controller");

    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRBdXRoSWQiOiJKVU5JVF9URVNUXzEyMyIsInRlbmFudElkIjoiSlVOSVRfVEVTVF8xMjMiLCJ1c2VyTmFtZSI6Imxpc2hhb3hpbmciLCJleHAiOjE3MjI5NDA2MjIsInVzZXJJZCI6MywidG9rZW5DcmVhdGVNaWxsaXMiOjE1OTY5NDA2MjI0MTR9.MT9YKcQ67DUpQd6E6LTjvLsVYOPYPc25Sw8TCeAde30";
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    //@Value(value = "${swagger.enabled}")
    private Boolean swaggerEnabled=true;
    //@Autowired
    //private TypeResolver typeResolver;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();

//        SysUserRequest sysUserRequest = new SysUserRequest();
//        sysUserRequest.setUserName("admin");
//        sysUserRequest.setPassword("admin");
//        SysUserResponse user = sysUserServiceApi.getSysUserByNameForLogin(sysUserRequest);
//        System.out.println("token========================================"+user.getToken());
//        if(StringUtils.isBlank(user.getToken())){
//            user.setToken(TOKEN);
//        }

        tokenPar.name("Authentication").description("令牌").defaultValue(TOKEN).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnabled)
                .select()
                //.apis(Predicates.or(selector1, selector2))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
               /* .alternateTypeRules(AlternateTypeRules.newRule(typeResolver.resolve(Map.class, String.class, typeResolver.resolve(List.class, EnumDictItem.class)), typeResolver.resolve(Map.class, String.class, WildcardType.class), Ordered.HIGHEST_PRECEDENCE),
                        AlternateTypeRules.newRule(typeResolver.resolve(Map.class, String.class, typeResolver.resolve(List.class, DictHelperResponse.class)), typeResolver.resolve(Map.class, String.class, WildcardType.class), Ordered.HIGHEST_PRECEDENCE)
                )*/
                ;
        return docket;
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("公司角色(company)API")
                //创建人
                .contact(new Contact("shangchaoshi", "http://jnyl.ott.pub/", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
