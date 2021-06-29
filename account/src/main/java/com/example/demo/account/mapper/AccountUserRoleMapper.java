package com.example.demo.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.account.entity.AccountAuthDefinition;
import com.example.demo.account.entity.AccountUserRole;

import java.util.List;

/**
 * @author tanjm
 */
public interface AccountUserRoleMapper extends BaseMapper<AccountUserRole> {
    /**
     * 查询账户相关有效权限
     * @param username
     * @return
     */
    List<AccountAuthDefinition> qryUserAuthority(String username);
}
