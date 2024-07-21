package com.demo.java.encrypt.demo1;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * 算法规定参数的封装
 *
 * @author liuxl
 * @date 2024/7/20
 */
public class AlgorithmParameterSpecInfo {
    private Optional<Class<? extends AlgorithmParameterSpec>> algorithmParameterSpecClass;
    private OptionalInt algorithmParameterBitLength = OptionalInt.empty();

    public AlgorithmParameterSpecInfo(Class<? extends AlgorithmParameterSpec> algorithmParameterSpecClass, int algorithmParameterBitLength) {
        this.algorithmParameterSpecClass = Optional.of(algorithmParameterSpecClass);
        this.algorithmParameterBitLength = OptionalInt.of(algorithmParameterBitLength);
    }

    public Optional<Class<? extends AlgorithmParameterSpec>> getAlgorithmParameterSpecClass() {
        return algorithmParameterSpecClass;
    }

    public OptionalInt getAlgorithmParameterBitLength() {
        return algorithmParameterBitLength;
    }
}
