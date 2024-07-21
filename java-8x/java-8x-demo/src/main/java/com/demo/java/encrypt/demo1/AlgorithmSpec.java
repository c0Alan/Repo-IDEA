package com.demo.java.encrypt.demo1;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * 算法规格，用来封装一个算法所需要的定义信息
 *
 * @author liuxl
 * @date 2024/7/20
 */
public class AlgorithmSpec {
    private Optional<String> algorithm = Optional.empty();
    private Optional<String> mode = Optional.empty();
    private Optional<String> padding = Optional.empty();
    private OptionalInt secretKeyBitLength = OptionalInt.empty();
    private Optional<Class<? extends AlgorithmParameterSpec>> algorithmParameterSpecClass = Optional.empty();
    private OptionalInt algorithmParameterBitLength = OptionalInt.empty();

    public static AlgorithmSpec of() {
        return new AlgorithmSpec();
    }

    public AlgorithmSpec setTransformation(String algotirhm, String mode, String padding) {
        this.algorithm = Optional.of(algotirhm);
        this.mode = Optional.of(mode);
        this.padding = Optional.of(padding);
        return this;
    }

    public Transformation getTransformation() {
        return new Transformation(this.algorithm.get(), this.mode.get(), this.padding.get());
    }

    public OptionalInt getSecretKeyBitLength() {
        return secretKeyBitLength;
    }

    public AlgorithmSpec setSecretKeyBitLength(int secretKeyBitLength) {
        this.secretKeyBitLength = OptionalInt.of(secretKeyBitLength);
        return this;
    }

    public AlgorithmSpec setAlgorithmParameterSpecClass(Class<? extends AlgorithmParameterSpec> algorithmParameterSpecClass) {
        this.algorithmParameterSpecClass = Optional.of(algorithmParameterSpecClass);
        return this;
    }

    public AlgorithmSpec setAlgorithmParameterBitLength(int algorithmParameterBitLength) {
        this.algorithmParameterBitLength = OptionalInt.of(algorithmParameterBitLength);
        return this;
    }

    public Optional<Class<? extends AlgorithmParameterSpec>> getAlgorithmParameterSpecClass() {
        return algorithmParameterSpecClass;
    }

    public OptionalInt getAlgorithmParameterBitLength() {
        return algorithmParameterBitLength;
    }

    public AlgorithmParameterSpecInfo getAlgorithmParameterSpecInfo() {
        return new AlgorithmParameterSpecInfo(this.algorithmParameterSpecClass.get() , this.algorithmParameterBitLength.getAsInt());
    }
}
