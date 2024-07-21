package com.demo.java.encrypt.demo1;


import javax.crypto.Cipher;
import java.security.Key;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 加解密流程的定义，描述了加解密流程需要的所有Lambda表达式
 *
 * @author liuxl
 * @date 2024/7/20
 */
public abstract class EncryptorDefinition<E extends EncryptorDefinition<E>> {
    protected Encryptor encryptor = new Encryptor();

    public E getCipher(Function<String, Cipher> cipherSupplier) {
        encryptor.setCipherSupplier(cipherSupplier);
        return (E)this;
    }

    public E getSecretKeyByStr(BiFunction<String, String, Key> keyGenerator) {
        encryptor.setKeyGeneratorByStr(keyGenerator);
        return (E)this;
    }

    public E getSecretKeyByRandomSeed(BiFunction<String, NumberGenerationAlgorithm, Key> keyGenerator) {
        encryptor.setKeyGenerator(keyGenerator);
        return (E)this;
    }

    public E padding(BiFunction<String, Integer, byte[]> padding) {
        encryptor.setPadding(padding);
        return (E)this;
    }

    public E initCipher(BiConsumer<Cipher, Key> initCipher) {
        encryptor.setInitCipher(initCipher);
        return (E)this;
    }

    public Encryptor get() {
        return this.encryptor;
    }
}
