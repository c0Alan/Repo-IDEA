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
 * JWT生成密钥证书jwt.jks
 * 参考：https://blog.csdn.net/qq_38225558/article/details/125262117
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
        map.put("username", "abc");
        map.put("password", "12345678");
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
//        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoienEifQ.mgyQxTfBKmsUZXkk5wBna1x2ZlMzobWOTo0JQxLJsQOtqXI8vPTn8PJF6_vFi4TTI4ani5YeC61onUciRlT2JJ9Z-e1-DNW0vz130WHSXd5dUR-ua6FSJuPeZz9D162GqHGBctbkT130wnHYaXVnrpvd_TWldAsDZB5hCZkVltgvazFVYibVU7wi5Dvn31lj-dKLflh6hDv_xmmIE1CxWETyLTvj2hLlqR0qNxZBoGiB8d6sdr388A5wWgew2KFIfZZtEzdZGRFNLN_PeDK3Fw8riuYG3Wuf7MWWFEQ_R0cezabJm7wHKCWyV4wqGEw-evyx_4uvlF-S3nKolBssww";
        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1Njc4IiwidXNlcm5hbWUiOiJhYmMifQ.akJI7Etxnbr8IMZ3LW5uIoh9i561CzpH0Or7NNRwdAc-c6cU0o6Zonb5NDsvFVCPo-4SV-xqzNDFm0JcEMFCAOAc9n7JZyf8Fp3YQY38Rjo-H5te0OcwtO9MJjaYz2Gf42dn51oEteD6RO_9c6CVV3LXOs57OzAJgWZ3sfeqW22BPraxNR2VT0couUoY_wpOSKjXj98ZKK-EIqYhRaNySRQv9IxsGTyIPHzcw1ez7YULukHea4DD5xKbQ4YydKVDqptDktRsdOe_4XX0LV5g0RCKDEpUuheg4XEK3ay4g1_4Z88N943t-UqzbPsjgAdmUxQQSlBa1cRJiG3ciWqpZA";
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAos+3SLBPEeTtIEiifh9c\n" +
                "1sKYwq7EnHQE4jeqDAMDIbRXAAxKegQ3a3O78tXsN1vrnPcR/7rA7dVpl1qkkTPn\n" +
                "sZa2HFN1K10pE+oRdr2ziUmVfX/S8RaCpc5VnHj5Ryh1XmS48wiinQZh6JjD5L8q\n" +
                "/iwhgWSDhdz4TAS7oduM5g9DlmrtOTaQ2xNXx9hw4jU+018yX2ITvRRpIYMO7gLg\n" +
                "IRIQ0hTsfkmy85wkwQq+Ihdk6Usj4VYFyph0uqpcD08wxdY5sH2gz2ABkIL/EK2p\n" +
                "29phcjXbUdvx0hGKIjk+ZSvJI+yDC6bW3Ct2mSIduHRfoi1WbX6b5nvGKrYvLKlG\n" +
                "4QIDAQAB" +
                "-----END PUBLIC KEY-----";
        // 解析令牌
        Jwt token = JwtHelper.decodeAndVerify(jwt, new RsaVerifier(publicKey));
        // 获取负载
        String claims = token.getClaims();
        System.out.println(claims);
    }
}
