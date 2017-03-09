package com.huangtianci.myframeprototype.mvc.security;

import com.huangtianci.myframeprototype.mvc.model.SecUser;
import com.huangtianci.myframeprototype.mvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Tianci
 * 自定义的UserDetailsService类
 * 该类主要为权限认证管理器提供用户信息
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SecUser secUser = userRepository.findOne(username);
        if(secUser == null){
            logger.info("User[ %s ] not found" , username);
            throw new UsernameNotFoundException("User["+username+"] not found");
        }
        return new org.springframework.security.core.userdetails.User(secUser.getUserName(), secUser.getPassWord(),
                true, true, true, true, getGrantedAuthorities(secUser));
    }

    private List<GrantedAuthority> getGrantedAuthorities(SecUser secUser){
        List<GrantedAuthority> authorities = new ArrayList<>();
        secUser.getRoleList();
        //TODO
        return authorities;
    }
}
