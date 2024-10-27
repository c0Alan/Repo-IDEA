package com.demo.springcloud.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.demo.springcloud.entity.Payload;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.UUID;

/**
 * JWT工具类
 *
 * @author liuxl
 * @date 2024/10/5
 */
@Slf4j
public class JwtHS256Util {
    /**
     * 有效期：60 * 60 *1000 一个小时
     */
    public static final int JWT_TTL_MINUTE = 60;

    private static final String JWT_PAYLOAD_USER_KEY = "user";

    /**
     * 设置秘钥明文
     */
    public static final String JWT_KEY = "12sfaafafa3awerwrgfavsvafwewrrrrrrrrreeeeeeedddddddxvxvsdfsfwerwrr3";

    private static String createJTI() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }

    /**
     * 创建token
     */
    public static String createJwt(Object userInfo) {
        SecretKey secretKey = generalKey();
        log.info("secretKey:{}", secretKey);

        JwtBuilder builder = Jwts.builder()
                .setId(createJTI()) //唯一的ID
                .claim(JWT_PAYLOAD_USER_KEY, JSONUtil.toJsonStr(userInfo))
                .signWith(secretKey, SignatureAlgorithm.HS256) //使用HS256对称加密算法签 名, 第二个参数为秘钥
                .setExpiration(DateUtil.offsetMinute(new DateTime(), JWT_TTL_MINUTE));// 设置过期时间

        return builder.compact();
    }

    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtHS256Util.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA256");
        return key;
    }

    /**
     * 公钥解析token
     *
     * @param token     用户请求中的token
     * @return Jws<Claims>
     */
    private static Jws<Claims> parserToken(String token) {
        SecretKey secretKey = generalKey();
        log.info("secretKey:{}", secretKey);

        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }

    /**
     * 获取token中的用户信息
     *
     * @param token     用户请求中的令牌
     * @return 用户信息
     */
    public static <T> Payload<T> getInfoFromToken(String token, Class<T> userType) {
        Jws<Claims> claimsJws = parserToken(token);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setUserInfo(JSONUtil.toBean(body.get(JWT_PAYLOAD_USER_KEY).toString(), userType));
        claims.setExpiration(body.getExpiration());
        return claims;
    }
}