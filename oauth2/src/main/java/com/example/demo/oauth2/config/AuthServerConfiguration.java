package com.example.demo.oauth2.config;

//import com.example.demo.common.core.RedisJwtTokenStore;

import com.example.demo.common.core.RedisJwtTokenStore;
import com.example.demo.oauth2.service.CustomizeClientDetailsService;
import com.example.demo.oauth2.service.CustomizeUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AuthServerConfiguration.class);
    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomizeClientDetailsService clientDetailsService;
    @Autowired
    private CustomizeUserDetailsService userDetailsService;
    @Value("classpath:rsa_private_key.pem")
    private RSAPrivateKey rsaPrivateKey;

    @Value("classpath:rsa_public_key.pem")
    private RSAPublicKey rsaPublicKey;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("permitAll()");
        //.accessDeniedHandler()
        //.and()
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStoreBean());
        endpoints.accessTokenConverter(jwtAccessTokenConverterBean());
        endpoints.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userDetailsService);
        endpoints.reuseRefreshTokens(false);
        //endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.POST);
        endpoints.approvalStoreDisabled();
        //endpoints.
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.withClientDetails(clientDetailsService);
    }


    @Bean
    public KeyPair keyPairBean() {
        try {
            //OpenSSL生成密钥
            // 生成私钥 genrsa -out rsa_private_key.pem 1024
            // 生成公钥 rsa -in rsa_private_key.pem -pubout -out rsa_public_key.pem
            // 转换私钥 pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -nocrypt
            return new KeyPair(rsaPublicKey, rsaPrivateKey);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverterBean() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPairBean());
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(new DefaultUserAuthenticationConverter() {
            @Override
            public Map<String, ?> convertUserAuthentication(Authentication authentication) {
                Map<String, Object> response = new LinkedHashMap();
                //response.put("user_name", authentication.getName());
                response.put("sub", authentication.getName());
                if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
                    response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
                }
                return response;
            }
        });
        jwtAccessTokenConverter.setAccessTokenConverter(accessTokenConverter);
        return jwtAccessTokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStoreBean() {
        return new RedisJwtTokenStore(jwtAccessTokenConverterBean());
    }
}
