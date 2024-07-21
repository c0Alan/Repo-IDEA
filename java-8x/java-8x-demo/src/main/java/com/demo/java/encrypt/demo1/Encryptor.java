package com.demo.java.encrypt.demo1;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 加解密流程抽象，按顺序调用一个加解密流程的所有步骤，并输出结果
 *
 * @author liuxl
 * @date 2024/7/20
 */
public class Encryptor {

    private Optional<Transformation> transformation = Optional.empty();

    private OptionalInt secretKeyBitLength = OptionalInt.empty();

    private Optional<AlgorithmParameterSpecInfo> algorithmParameterSpecInfo = Optional.empty();

    private Optional<String> plainText = Optional.empty();

    private Optional<String> base64CipherText = Optional.empty();

    private Optional<String> secretKeyStr = Optional.empty();

    private Optional<String> randomSeedStr = Optional.empty();

    private Optional<NumberGenerationAlgorithm> ngAlgorithm = Optional.empty();

    private Optional<String> algorithmParameterStr = Optional.empty();

    private Optional<BiFunction<String, String, Key>> keyGeneratorByStr = Optional.empty();

    private Optional<BiFunction<String, NumberGenerationAlgorithm, Key>> keyGeneratorByRandomSeed = Optional.empty();

    private Optional<Function<String, Cipher>> cipherSupplier = Optional.empty();

    private Optional<BiFunction<String, Integer, byte[]>> padding = Optional.empty();

    private Optional<BiConsumer<Cipher, Key>> initCipher = Optional.empty();

    public Optional<String> encrypt() throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchMethodException, InvalidAlgorithmParameterException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // Step1: create a Cipher instance
        Cipher cipher = cipherSupplier.get().apply(this.transformation.get().toString());

        // Step2: padding plain text if no-padding
        byte[][] plainTextBytes = new byte[1][];
        if ("NoPadding".equals(transformation.get().getPadding().get())) {
            padding.ifPresent(paddingOperator -> plainTextBytes[0] = paddingOperator.apply(plainText.get(), cipher.getBlockSize()));
        } else {
            plainTextBytes[0] = plainText.get().getBytes();
        }

        // Step3: generate secret key
        Key[] secretKey = generateSecretKey();

        // Step4: init cipher
        initCipher.ifPresent(init -> init.accept(cipher, secretKey[0]));

        // Step5: encrypt plain text
        byte[] encrypted = cipher.doFinal(plainTextBytes[0]);
        String cipherText =  new BASE64Encoder().encode(encrypted);
        System.out.println(String.format("%s(%d) plain text: %s -> cipher text: %s", this.transformation.get().toString(), this.secretKeyBitLength.getAsInt(), plainText.get(), cipherText));

        return Optional.ofNullable(cipherText);
    }

    public Optional<String> decrypt() throws IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchMethodException, InvalidAlgorithmParameterException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // Step1: create a Cipher instance
        Cipher cipher = cipherSupplier.get().apply(this.transformation.get().toString());

        // Step2: generate secret key
        Key[] secretKey = generateSecretKey();

        // Step3: init cipher
        initCipher.ifPresent(init -> init.accept(cipher, secretKey[0]));

        // Step4: decrypt cipher text
        byte[] plainBytes = cipher.doFinal(new BASE64Decoder().decodeBuffer(base64CipherText.get()));
        String plainText =  new String(plainBytes).trim();
        System.out.println(String.format("%s(%d) cipher text: %s -> plain text: %s", this.transformation.get().toString(), this.secretKeyBitLength.getAsInt(), base64CipherText.get(), plainText));
        return Optional.of(plainText);
    }

    private Key[] generateSecretKey() {
        Key secretKey[] = new Key[1];
        keyGeneratorByStr.ifPresent(keyGenerator -> secretKey[0] = keyGenerator.apply(secretKeyStr.get(), transformation.get().getAlgorithm().get()));
        keyGeneratorByRandomSeed.ifPresent(keyGenerator -> secretKey[0] = keyGenerator.apply(randomSeedStr.get(), ngAlgorithm.get()));
        return secretKey;
    }

    public Encryptor setTransformation(Transformation transformation) {
        this.transformation = Optional.of(transformation);
        return this;
    }

    public Encryptor setSecretKeyBitLength(int secretKeyBitLength) {
        this.secretKeyBitLength = OptionalInt.of(secretKeyBitLength);
        return this;
    }

    public Encryptor setAlgorithmParameterSpecInfo(AlgorithmParameterSpecInfo algorithmParameterSpecInfo) {
        this.algorithmParameterSpecInfo = Optional.of(algorithmParameterSpecInfo);
        return this;
    }

    public Encryptor setPlainText(String plainText) {
        this.plainText = Optional.of(plainText);
        return this;
    }

    public Encryptor setBase64CipherText(String base64CipherText) {
        this.base64CipherText = Optional.of(base64CipherText);
        return this;
    }

    public Encryptor setSecretKeyStr(String secretKeyStr) {
        this.secretKeyStr = Optional.of(secretKeyStr);
        return this;
    }

    public Encryptor setRandomSeedStr(String randomSeedStr) {
        this.randomSeedStr = Optional.of(randomSeedStr);
        return this;
    }

    public Encryptor setNgAlgorithm(NumberGenerationAlgorithm ngAlgorithm) {
        this.ngAlgorithm = Optional.of(ngAlgorithm);
        return this;
    }

    public Encryptor setAlgorithmParameterStr(String algorithmParameterStr) {
        this.algorithmParameterStr = Optional.of(algorithmParameterStr);
        return this;
    }

    public void setKeyGeneratorByStr(BiFunction<String, String, Key> keyGeneratorByStr) {
        this.keyGeneratorByStr = Optional.of(keyGeneratorByStr);
    }

    public void setKeyGenerator(BiFunction<String, NumberGenerationAlgorithm, Key> keyGeneratorByRandomSeed) {
        this.keyGeneratorByRandomSeed = Optional.of(keyGeneratorByRandomSeed);
    }

    public void setCipherSupplier(Function<String, Cipher> cipherSupplier) {
        this.cipherSupplier = Optional.of(cipherSupplier);
    }

    public void setPadding(BiFunction<String, Integer, byte[]> padding) {
        this.padding = Optional.of(padding);
    }

    public void setInitCipher(BiConsumer<Cipher, Key> initCipher) {
        this.initCipher = Optional.of(initCipher);

    }
}
