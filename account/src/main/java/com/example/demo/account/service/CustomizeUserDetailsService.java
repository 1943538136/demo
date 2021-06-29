package com.example.demo.account.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.account.entity.AccountAuthDefinition;
import com.example.demo.account.entity.AccountLoginAccount;
import com.example.demo.account.entity.AccountLoginAuthoritie;
import com.example.demo.account.mapper.AccountLoginAccountMapper;
import com.example.demo.account.mapper.AccountLoginAuthoritieMapper;
import com.example.demo.account.model.CustomizeUserDetail;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author :tanjm
 * Date:  2021/6/28
 * Desc:
 */
@Service
public class CustomizeUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomizeUserDetailsService.class);

    @Resource
    private AccountLoginAccountMapper accountLoginAccountMapper;
    @Resource
    private AccountLoginAuthoritieMapper accountLoginAuthoritieMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logger.info(username);
        if (StringUtils.isBlank(username)) {
            logger.error("[username] cannot be empty,please check!!!");
            throw new UsernameNotFoundException("[username] cannot be empty,please check!!!");
        }
        AccountLoginAccount accountLoginAccount = null;
        List<AccountAuthDefinition> accountLoginAuthorities = null;
        {
            LambdaQueryWrapper<AccountLoginAccount> queryWrapper = Wrappers.lambdaQuery();
            queryWrapper.eq(AccountLoginAccount::getUsername, username);
            accountLoginAccount = accountLoginAccountMapper.selectOne(queryWrapper);
        }

        if (null != accountLoginAccount) {
            LambdaQueryWrapper<AccountLoginAuthoritie> queryWrapper = Wrappers.lambdaQuery();
            queryWrapper.eq(AccountLoginAuthoritie::getUserId, accountLoginAccount.getUserId());
            accountLoginAuthorities = accountLoginAuthoritieMapper.selectList(queryWrapper);
        } else {
            logger.error("[AccountLoginAccount] data not found,please check!!!");
            throw new UsernameNotFoundException("[AccountLoginAccount] data not found,please check!!!");
        }
        return new CustomizeUserDetail(accountLoginAccount, accountLoginAuthorities);
    }
}
