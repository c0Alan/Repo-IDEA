package com.demo.java.encrypt;

import com.demo.java.encrypt.demo1.NumberGenerationAlgorithm;
import com.demo.java.encrypt.demo1.SymmetricEncryptionAlgorithm;
import org.junit.Assert;
import org.junit.Test;

/**
 * 对称加密算法示例
 * 参考：https://blog.csdn.net/yunyun1886358/article/details/128594361
 * 
 * @author liuxl
 * @date 2024/7/18
 */
public class SymmetricDemo {

    /**
     * AES 算法加解密
     */
    @Test
    public void encryptAES() throws Exception {
        String cipherText = SymmetricEncryptionAlgorithm.AES_CBC_NO_PADDING_128.encrypt("a", "1234567890123456", "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_CBC_NO_PADDING_128.decrypt(cipherText, "1234567890123456", "1234567890123456"));

        cipherText = SymmetricEncryptionAlgorithm.AES_CBC_NO_PADDING_128.encrypt("a", "12345", NumberGenerationAlgorithm.SHA1_PRNG, "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_CBC_NO_PADDING_128.decrypt(cipherText, "12345", NumberGenerationAlgorithm.SHA1_PRNG, "1234567890123456"));

        cipherText = SymmetricEncryptionAlgorithm.AES_CBC_PKCS5_PADDING_128.encrypt("a", "1234567890123456", "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_CBC_PKCS5_PADDING_128.decrypt(cipherText, "1234567890123456", "1234567890123456"));

        cipherText = SymmetricEncryptionAlgorithm.AES_ECB_NO_PADDING_128.encrypt("a", "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_ECB_NO_PADDING_128.decrypt(cipherText, "1234567890123456"));

        cipherText = SymmetricEncryptionAlgorithm.AES_ECB_PKCS5_PADDING_128.encrypt("a", "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_ECB_PKCS5_PADDING_128.decrypt(cipherText, "1234567890123456"));

        // AES 192 bits secret
        cipherText = SymmetricEncryptionAlgorithm.AES_CBC_PKCS5_PADDING_192.encrypt("a", "123456789012345678901234", "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_CBC_PKCS5_PADDING_192.decrypt(cipherText, "123456789012345678901234", "1234567890123456"));

        // AES 256 bits secret
        cipherText = SymmetricEncryptionAlgorithm.AES_CBC_PKCS5_PADDING_256.encrypt("a", "12345678901234567890123456789012", "1234567890123456");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.AES_CBC_PKCS5_PADDING_256.decrypt(cipherText, "12345678901234567890123456789012", "1234567890123456"));
    }

    @Test
    public void encryptDES() throws Exception {
        // DES 56 bits secret
        String cipherText = SymmetricEncryptionAlgorithm.DES_CBC_NO_PADDING_56.encrypt("a", "12345678", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DES_CBC_NO_PADDING_56.decrypt(cipherText, "12345678", "12345678"));

        cipherText = SymmetricEncryptionAlgorithm.DES_CBC_PKCS5_PADDING_56.encrypt("a", "12345678", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DES_CBC_PKCS5_PADDING_56.decrypt(cipherText, "12345678", "12345678"));

        cipherText = SymmetricEncryptionAlgorithm.DES_ECB_NO_PADDING_56.encrypt("a", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DES_ECB_NO_PADDING_56.decrypt(cipherText, "12345678"));

        cipherText = SymmetricEncryptionAlgorithm.DES_ECB_PKCS5_PADDING_56.encrypt("a", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DES_ECB_PKCS5_PADDING_56.decrypt(cipherText, "12345678"));
    }

    @Test
    public void encrypt3DES() throws Exception {
        // 3 DES 168 bits secret
        String cipherText = SymmetricEncryptionAlgorithm.DESEDE_CBC_NO_PADDING_168.encrypt("a", "123456789012345678901234", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DESEDE_CBC_NO_PADDING_168.decrypt(cipherText, "123456789012345678901234", "12345678"));

        cipherText = SymmetricEncryptionAlgorithm.DESEDE_CBC_PKCS5_PADDING_168.encrypt("a", "123456789012345678901234", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DESEDE_CBC_NO_PADDING_168.decrypt(cipherText, "123456789012345678901234", "12345678"));

        cipherText = SymmetricEncryptionAlgorithm.DESEDE_ECB_NO_PADDING_168.encrypt("a", "123456789012345678901234");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DESEDE_ECB_NO_PADDING_168.decrypt(cipherText, "123456789012345678901234"));

        cipherText = SymmetricEncryptionAlgorithm.DESEDE_ECB_PKCS5_PADDING_168.encrypt("a", "123456789012345678901234");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.DESEDE_ECB_PKCS5_PADDING_168.decrypt(cipherText, "123456789012345678901234"));
    }

    @Test
    public void encryptBlowfish() throws Exception {
        // Blowfish
        String cipherText = SymmetricEncryptionAlgorithm.BLOWFISH_CBC_NO_PADDING_128.encrypt("a", "1234567890123456", "12345678");
        Assert.assertEquals("a", SymmetricEncryptionAlgorithm.BLOWFISH_CBC_NO_PADDING_128.decrypt(cipherText, "1234567890123456", "12345678"));
    }
}
