package com.example.demo.oauth2.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 * @author tanjm
 */
public class CustomizeClientDetail implements ClientDetails, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CustomizeClientDetail.class);
    private static final long serialVersionUID = -3131590966365989546L;
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoapprove;

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        if (null == this.resourceIds) {
            return null;
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, this.resourceIds.split(","));
        return set;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        if (null == this.scope) {
            return new HashSet<>();
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, this.scope.split(","));
        return set;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        if (null == this.authorizedGrantTypes) {
            return new HashSet<>();
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, this.authorizedGrantTypes.split(","));
        return set;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (null == this.webServerRedirectUri) {
            return new HashSet<>();
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, this.webServerRedirectUri.split(","));
        return set;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (null == this.authorities) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, this.authorities.split(","));
        return set.stream().map(a -> new CustomizeAuthority(a)).collect(Collectors.toList());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>(16);
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
