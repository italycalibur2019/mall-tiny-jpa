package com.italycalibur.mall.tiny.jpa.security.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.crypto.SecureUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义MD5加密解密器
 * @author italycalibur
 * @since 2023/12/11
 */
public class MD5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return SecureUtil.md5(Convert.toStr(rawPassword));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(SecureUtil.md5(Convert.toStr(rawPassword)));
    }
}
