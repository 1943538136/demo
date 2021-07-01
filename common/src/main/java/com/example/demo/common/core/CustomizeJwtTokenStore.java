package com.example.demo.common.core;

import com.example.demo.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author :tanjm
 * Date:  2021/6/30
 * Desc:
 */
public class CustomizeJwtTokenStore extends JwtTokenStore {
    private static final Logger logger = LoggerFactory.getLogger(CustomizeJwtTokenStore.class);
    private static final boolean allow = false;
    private static final Map<String, OAuth2Authentication> ACCESS_TOKEN_STORE = new ConcurrentHashMap<>();
    private static final Map<String, String> ACCESS_TOKEN_REF_REFRESH_TOKEN_STORE = new ConcurrentHashMap<>();
    private static final Map<String, OAuth2Authentication> REFRESH_TOKEN_STORE = new ConcurrentHashMap<>();

    public CustomizeJwtTokenStore(JwtAccessTokenConverter jwtTokenEnhancer) {
        super(jwtTokenEnhancer);
    }

    //private RedisTokenStore

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        super.storeAccessToken(token, authentication);
        logger.info(JsonUtils.writeAsString(token));
        if (null == token) {
            return;
        }
        ACCESS_TOKEN_STORE.put(token.getValue(), authentication);
        OAuth2RefreshToken refreshToken = token.getRefreshToken();
        if (null == refreshToken) {
            return;
        }
        ACCESS_TOKEN_REF_REFRESH_TOKEN_STORE.put(refreshToken.getValue(), token.getValue());
    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        super.storeRefreshToken(refreshToken, authentication);
        if (null == refreshToken) {
            return;
        }
        REFRESH_TOKEN_STORE.put(refreshToken.getValue(), authentication);
    }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {
        super.removeRefreshToken(token);

        if (null == token) {
            return;
        }
        if (REFRESH_TOKEN_STORE.containsKey(token.getValue())) {
            REFRESH_TOKEN_STORE.remove(token.getValue());
        }
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        super.removeAccessTokenUsingRefreshToken(refreshToken);
        if (null == refreshToken) {
            return;
        }
        if (!ACCESS_TOKEN_REF_REFRESH_TOKEN_STORE.containsKey(refreshToken.getValue())) {
            return;
        }
        String tokenValue = ACCESS_TOKEN_REF_REFRESH_TOKEN_STORE.get(refreshToken.getValue());
        if (!ACCESS_TOKEN_STORE.containsKey(tokenValue)) {
            return;
        }
        ACCESS_TOKEN_STORE.remove(tokenValue);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        if (allow) {
            if (!ACCESS_TOKEN_STORE.containsKey(tokenValue)) {
                return null;
            }
        }
        return super.readAccessToken(tokenValue);
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        if (allow) {
            if (!REFRESH_TOKEN_STORE.containsKey(tokenValue)) {
                return null;
            }
        }
        return super.readRefreshToken(tokenValue);
    }
}
