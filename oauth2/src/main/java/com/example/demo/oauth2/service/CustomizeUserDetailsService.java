package com.example.demo.oauth2.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.oauth2.entity.AccountAuthDef;
import com.example.demo.oauth2.entity.AccountLoginAccount;
import com.example.demo.oauth2.mapper.AccountLoginAccountMapper;
import com.example.demo.oauth2.mapper.AccountUserRoleMapper;
import com.example.demo.oauth2.model.CustomizeUserDetail;
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
    private AccountUserRoleMapper accountUserRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            logger.error("[username] cannot be empty,please check!!!");
            throw new UsernameNotFoundException("[username] cannot be empty,please check!!!");
        }
        AccountLoginAccount accountLoginAccount = null;
        List<AccountAuthDef> accountLoginAuthorities = null;
        LambdaQueryWrapper<AccountLoginAccount> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AccountLoginAccount::getUsername, username);
        accountLoginAccount = accountLoginAccountMapper.selectOne(queryWrapper);
        accountLoginAuthorities = accountUserRoleMapper.qryUserAuthority(username);
        return new CustomizeUserDetail(accountLoginAccount, accountLoginAuthorities);
    }
}
