package com.isle.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

/**
 * Created by 61066 on 2017/12/27.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private static final String DEF_USERS_BY_USERNAME_QUERY =
            "SELECT " +
                "username, " +
                "password, " +
                "enabled " +
            "FROM t_user " +
            "where username = ?";

    private static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "SELECT " +
                "username, " +
                "rolename " +
            "FROM t_user u " +
            "JOIN t_user_role u_r ON u.id = u_r.user_id " +
            "JOIN t_role r ON r.id = u_r.role_id " +
            "WHERE username = ?";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
            .and()
                .httpBasic()
                    .realmName("simple-spring")
            .and()
                .logout()
            .and()
                .rememberMe()
                .tokenValiditySeconds(20171227)
                .key("simple-spring");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY);
    }
}
