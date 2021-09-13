package com.example.demo.account.config;

import com.example.demo.account.service.CustomizeClientDetailsService;
import com.example.demo.account.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@Configuration
//@EnableWebSecurity
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtTokenStore jwtTokenStore;
    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private CustomizeClientDetailsService clientDetailsService;
    @Autowired
    private CustomizeUserDetailsService userDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        //security.tokenKeyAccess("isAuthenticated()");
        security.tokenKeyAccess("permitAll()");


    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore);
        endpoints.accessTokenConverter(jwtAccessTokenConverter);
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
}
