package com.lj.test.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)      //开启方法权限校验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private DataSource dataSource;

    /**
     * 定义安全策略
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()                                    //配置安全策略
                .antMatchers("/","/home","/hello","/druid/**","/learn/**","/css/**","/js/**").permitAll()       //定义'/','/home'及一些静态资源请求不需要验证
                .anyRequest().authenticated()                           //其余的所有请求都需要验证
                .and()
                .formLogin()                                            //使用form表单登录
                .loginPage("/login")                                    //登录页面
                //.defaultSuccessUrl("/xxx")                            //默认登录成功后跳转到的页面
                .permitAll()                                            //定义'/login'不需要验证
                //.and()
                //.rememberMe()                                           //开启cookie保存用户数据
                //.tokenValiditySeconds(60 * 60 * 24 * 7)                 //设置cookie有效期
                //.key("")                                                //设置cookie的私钥
                .and()
                .logout()
                //.logoutSuccessUrl("/home")                            //退出登录后的默认url
                .permitAll()                                            //定义logout不需要验证
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }
    /**
     * 定义认证用户信息获取来源，密码校验规则等
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication 从内存中获取
        /*auth.inMemoryAuthentication()
                .withUser("user")
                .password("123456")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("123456")
                .roles("ADMIN");*/

        //jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构
        //usersByUsernameQuery 指定查询用户SQL
        //authoritiesByUsernameQuery 指定查询权限SQL
        //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);

        //注入userDetailsService，需要实现userDetailsService接口
        //auth.userDetailsService(userDetailsService);
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select name, password, true from user where name = ?").authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
    }
}
