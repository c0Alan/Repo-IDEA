package com.demo.java.encrypt.demo1;


import java.util.Optional;

/**
 * 算法参数，用来封装一个算法所需要的所有参数
 *
 * @author liuxl
 * @date 2024/7/20
 */
public class AlgorithmParam {
    private Optional<String> plainText = Optional.empty();

    private Optional<String> base64CipherText = Optional.empty();

    private Optional<String> secretKeyStr = Optional.empty();

    private Optional<String> randomSeedStr = Optional.empty();

    private Optional<NumberGenerationAlgorithm> ngAlgorithm = Optional.empty();

    private Optional<String> algorithmParameterStr = Optional.empty();

    public static AlgorithmParam of() {
        return new AlgorithmParam();
    }

    public AlgorithmParam setPlainText(String plainText) {
        this.plainText = Optional.of(plainText);
        return this;
    }

    public AlgorithmParam setBase64CipherText(String base64CipherText) {
        this.base64CipherText = Optional.of(base64CipherText);
        return this;
    }

    public AlgorithmParam setSecretKeyStr(String secretKeyStr) {
        this.secretKeyStr = Optional.of(secretKeyStr);
        return this;
    }

    public AlgorithmParam setRandomSeedStr(String randomSeedStr) {
        this.randomSeedStr = Optional.of(randomSeedStr);
        return this;
    }

    public AlgorithmParam setNgAlgorithm(NumberGenerationAlgorithm ngAlgorithm) {
        this.ngAlgorithm = Optional.of(ngAlgorithm);
        return this;
    }

    public AlgorithmParam setAlgorithmParameterStr(String algorithmParameterStr) {
        this.algorithmParameterStr = Optional.of(algorithmParameterStr);
        return this;
    }

    public Optional<String> getPlainText() {
        return plainText;
    }

    public Optional<String> getBase64CipherText() {
        return base64CipherText;
    }

    public Optional<String> getSecretKeyStr() {
        return secretKeyStr;
    }

    public Optional<String> getRandomSeedStr() {
        return randomSeedStr;
    }

    public Optional<NumberGenerationAlgorithm> getNgAlgorithm() {
        return ngAlgorithm;
    }

    public Optional<String> getAlgorithmParameterStr() {
        return algorithmParameterStr;
    }
}
