package com.example.demo.account.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.account.entity.AccountOauthClientDetail;
import com.example.demo.account.mapper.AccountOauthClientDetailMapper;
import com.example.demo.account.model.CustomizeClientDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 */
@Service
public class CustomizeClientDetailsService implements ClientDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomizeClientDetailsService.class);
    @Resource
    private AccountOauthClientDetailMapper accountOauthClientDetailMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        AccountOauthClientDetail accountOauthClientDetail = null;
        LambdaQueryWrapper<AccountOauthClientDetail> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AccountOauthClientDetail::getClientId, clientId);
        accountOauthClientDetail = accountOauthClientDetailMapper.selectOne(queryWrapper);
        if (null == accountOauthClientDetail) {
            logger.error("[AccountOauthClientDetail] data not found,please check!!!");
            return null;
        }
        CustomizeClientDetail customizeClientDetail = new CustomizeClientDetail();
        BeanUtils.copyProperties(accountOauthClientDetail, customizeClientDetail);
        return customizeClientDetail;
    }
}
