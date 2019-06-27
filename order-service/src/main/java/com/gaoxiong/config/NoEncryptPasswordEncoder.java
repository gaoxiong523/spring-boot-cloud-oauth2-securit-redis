package com.gaoxiong.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author gaoxiong
 * @ClassName NoEncryptPasswordEncoder
 * @Description 不加密
 * @date 2019/6/27 17:04
 */
public class NoEncryptPasswordEncoder implements PasswordEncoder {
    public String encode ( CharSequence charSequence ) {
        return String.valueOf(charSequence);
    }

    public boolean matches ( CharSequence charSequence, String s ) {
        return s.equals(String.valueOf(charSequence));
    }
}
