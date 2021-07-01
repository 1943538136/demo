package com.example.demo.account.model;

import com.example.demo.account.entity.AccountAuthDef;
import com.example.demo.account.entity.AccountLoginAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 *
 * @author tanjm
 */
public class CustomizeUserDetail implements UserDetails, Serializable {
    private static final long serialVersionUID = 409369298938979170L;
    private static final Logger logger = LoggerFactory.getLogger(CustomizeUserDetail.class);

    private String username;
    private String password;
    private Boolean enabled;
    private List<CustomizeAuthority> authorities;

    public CustomizeUserDetail(AccountLoginAccount loginAccount, List<AccountAuthDef> accountAuthDefs) {
        if (null == loginAccount) {
            logger.error("[AccountLoginAccount] cannot be null,please check!!!");
            throw new UsernameNotFoundException("[AccountLoginAccount] data not found,please check!!!");
        }
        this.username = loginAccount.getUsername();
        this.password = loginAccount.getPassword();
        this.enabled = loginAccount.getEnabled();
        if (null == accountAuthDefs || accountAuthDefs.isEmpty()) {
            this.authorities = new ArrayList<>();
        } else {

            Set<String> set = accountAuthDefs.stream().map(accountLoginAuthoritie -> accountLoginAuthoritie.getCode()).collect(Collectors.toSet());
            this.authorities = set.stream().map(CustomizeAuthority::new).collect(Collectors.toList());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(List<CustomizeAuthority> authorities) {
        this.authorities = authorities;
    }
}
