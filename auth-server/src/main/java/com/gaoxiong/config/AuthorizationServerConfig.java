package com.gaoxiong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @author gaoxiong
 * @ClassName AuthorizationServerConfig
 * @Description 授权中心的配置类
 * @date 2019/6/24 16:13
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Override
    public void configure ( AuthorizationServerSecurityConfigurer security ) throws Exception {
        security.allowFormAuthenticationForClients() //允许客户端表单验证
                .tokenKeyAccess("permitAll()") //令牌秘钥访问
                .checkTokenAccess("isAuthenticated()"); //检查令牌访问

    }

    @Override
    public void configure ( ClientDetailsServiceConfigurer clients ) throws Exception {
        clients.inMemory()
                .withClient("android")
                .scopes("read")
                .secret("android")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .and()
                .withClient("webapp")
                .scopes("read")
                .authorizedGrantTypes("implicit")
                .and()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("read");

    }
    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator(){
        return new MssWebResponseExceptionTranslator();
    }


    @Bean
    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }
    @Override
    public void configure ( AuthorizationServerEndpointsConfigurer endpoints ) throws Exception {
        endpoints.tokenStore(tokenStore())
                .userDetailsService()
                .authenticationManager();
        endpoints.tokenServices();

    }
}
