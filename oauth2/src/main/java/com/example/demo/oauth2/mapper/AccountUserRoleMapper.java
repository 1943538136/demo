package com.example.demo.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.oauth2.entity.AccountAuthDef;
import com.example.demo.oauth2.entity.AccountUserRole;

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
    List<AccountAuthDef> qryUserAuthority(String username);
}
