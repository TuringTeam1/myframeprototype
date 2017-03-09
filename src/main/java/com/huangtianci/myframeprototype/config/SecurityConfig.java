package com.huangtianci.myframeprototype.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Huang Tianci
 * spring security 配置类
 * 继承自WebSecurityConfigurerAdapter
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");
    }

    /**
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //每个macher按照他们的声明顺序执行
                //我们指定任何用户都可以访问的多个URL模式。任何用户都可以访问URL以 "/resources/",开头的URL ,以及"/signup", "/about".
                .antMatchers("/resources/**", "/signup", "/about").permitAll()
                //以"/admin/" 开头的URL只能由拥有 "ROLEADMIN"角色的用户访问. 请注意我们使用HasRole方法，没有使用ROLE前缀。
                .antMatchers("/admin/**").hasRole("ADMIN")
                //任何以/db/开头的URL需要用户同时具有"ROLEADMIN" 和 "ROLE_DBA". 和上面一样我们的hasRole方法也没有使用ROLE前缀。
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                //确保我们应用中的所有请求都需要用户被认证
                .anyRequest().authenticated()
            .and()
            //允许用户进行基于表单的认证,指定登陆页的路径并必须允许所有用户访问我们的登录页
            .formLogin().loginPage("/login").permitAll()
            .and()
            //允许用户使用HTTP基本验证进行认证
            .httpBasic();
    }
}
