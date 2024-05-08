package com.demo.java.encrypt;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

/**
 *
 * @author liuxl
 * @date 2024/5/8
 */
public class JwtDemo {

    /**
     * "%JAVA_HOME%"\bin\keytool -genkeypair -alias jwt -keyalg RSA -keypass mySecretKey -keystore jwt.jks -storepass mySecretKey
     * "%JAVA_HOME%"\bin\keytool -list -keystore jwt.jks
     * @throws Exception
     */
    @Test
    public void testCreateJwt() throws Exception {
        // 1、创建秘钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                // 秘钥位置
                new ClassPathResource("jwt.jks"),
                // 秘钥库密码
                "mySecretKey".toCharArray()
        );
        // 2、基于工厂拿到私钥
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "mySecretKey".toCharArray());

        // 转化为rsa私钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        // 3、生成jwt
        Map<String, String> map = Maps.newHashMap();
        map.put("username", "zq");
        map.put("password", "123456");
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(map), new RsaSigner(rsaPrivateKey));
        String jwtEncoded = jwt.getEncoded();
        System.out.println("jwtEncoded:" + jwtEncoded);
        String claims = jwt.getClaims();
        System.out.println("claims:" + claims);
    }

    /**
     * "%JAVA_HOME%"\bin\keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey
     * @throws Exception
     */
    @Test
    public void testParseJwt() throws Exception {
        // testCreateJwt方法中生成的值, 基于公钥去解析jwt
        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoienEifQ.mgyQxTfBKmsUZXkk5wBna1x2ZlMzobWOTo0JQxLJsQOtqXI8vPTn8PJF6_vFi4TTI4ani5YeC61onUciRlT2JJ9Z-e1-DNW0vz130WHSXd5dUR-ua6FSJuPeZz9D162GqHGBctbkT130wnHYaXVnrpvd_TWldAsDZB5hCZkVltgvazFVYibVU7wi5Dvn31lj-dKLflh6hDv_xmmIE1CxWETyLTvj2hLlqR0qNxZBoGiB8d6sdr388A5wWgew2KFIfZZtEzdZGRFNLN_PeDK3Fw8riuYG3Wuf7MWWFEQ_R0cezabJm7wHKCWyV4wqGEw-evyx_4uvlF-S3nKolBssww";
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAykQojp/KMCzaew5xRv2W\n" +
                "qVnp2CTMpp6Piqs7crjbkd+VXHBH2qmeP9yFJSYXmesAwMPuaPXG6YKsvl5M//Ji\n" +
                "nAg4TKsRHZcPTeV9SUXo8ywU+ba3enBfKo17EAqJowU6SbmIheN8kFamrgI0BRXF\n" +
                "fJkPpwx3cZJFoBvpZJsjKoo+F8GbyvYeqbbdcCGkGK3QMvywRXNBC+iqEbgHewNk\n" +
                "0fH+rtFvk5ut+8pNlin1gbwd9iS0yD2Jgr08Ps6qYPj3hUGg/gzMFPCjBKOtirT9\n" +
                "p2i+QNY/pIkmqpNYI07fVH+XZ+iJ7qflO59j5gR7+PhrqdQ8P/tWlvcuefmNbGs5\n" +
                "lQIDAQAB\n" +
                "-----END PUBLIC KEY-----";
        // 解析令牌
        Jwt token = JwtHelper.decodeAndVerify(jwt, new RsaVerifier(publicKey));
        // 获取负载
        String claims = token.getClaims();
        System.out.println(claims);
    }
}
