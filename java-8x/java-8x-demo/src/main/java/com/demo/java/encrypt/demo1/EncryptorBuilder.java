package com.demo.java.encrypt.demo1;

import java.util.function.BiConsumer;

/**
 * 加解密流程构造器，用于构造一个加解密流程
 *
 * @author liuxl
 * @date 2024/7/20
 */
public class EncryptorBuilder extends EncryptorDefinition<EncryptorBuilder> {
    public static EncryptorBuilder from(AlgorithmSpec algorithmSpec, AlgorithmParam algorithmParam, BiConsumer<AlgorithmSpec, AlgorithmParam> paramValidator) {
        EncryptorBuilder encryptorBuilder = new EncryptorBuilder();
        paramValidator.accept(algorithmSpec, algorithmParam);
        Encryptor encryptor = encryptorBuilder.get();
        encryptor.setTransformation(algorithmSpec.getTransformation())
                .setSecretKeyBitLength(algorithmSpec.getSecretKeyBitLength().getAsInt());
        algorithmSpec.getAlgorithmParameterSpecClass().ifPresent(clazz -> encryptor.setAlgorithmParameterSpecInfo(algorithmSpec.getAlgorithmParameterSpecInfo()));
        algorithmParam.getPlainText().ifPresent(plainText -> encryptor.setPlainText(plainText));
        algorithmParam.getBase64CipherText().ifPresent(cipherText -> encryptor.setBase64CipherText(cipherText));
        algorithmParam.getSecretKeyStr().ifPresent(secretKeyStr -> encryptor.setSecretKeyStr(secretKeyStr));
        algorithmParam.getRandomSeedStr().ifPresent(randomSeedStr -> encryptor.setRandomSeedStr(randomSeedStr));
        algorithmParam.getNgAlgorithm().ifPresent(ngAlgorithm -> encryptor.setNgAlgorithm(ngAlgorithm));
        algorithmParam.getAlgorithmParameterStr().ifPresent(algorithmParameterStr -> encryptor.setAlgorithmParameterStr(algorithmParameterStr));
        return encryptorBuilder;
    }
}
