package com.demo.java.encrypt.demo1;

/**
 * 数字生成算法枚举，此算法用于随机数生成
 *
 * @author liuxl
 * @date 2024/7/20
 */
public enum NumberGenerationAlgorithm {
    NATIVE_PRNG("NativePRNG"),
    NATIVE_PRNG_BLOCKING("NativePRNGBlocking"),
    NATIVE_PRNG_NON_BLOCKING("NativePRNGNonBlocking"),
    PKCS11("PKCS11"),
    SHA1_PRNG("SHA1PRNG"),
    WINDOWS_PRNG("Windows-PRNG");

    private String algorithmName = "";

    NumberGenerationAlgorithm(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmName() {
        return this.algorithmName;
    }
}
