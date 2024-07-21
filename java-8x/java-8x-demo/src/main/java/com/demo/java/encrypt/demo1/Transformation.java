package com.demo.java.encrypt.demo1;

import java.util.Optional;

/**
 * 算法转换式的封装
 *
 * @author liuxl
 * @date 2024/7/20
 */
public class Transformation {
    private Optional<String> algorithm = Optional.empty();
    private Optional<String> mode = Optional.empty();
    private Optional<String> padding = Optional.empty();

    public Transformation(String algorithm, String mode, String padding) {
        this.algorithm = Optional.of(algorithm);
        this.mode = Optional.of(mode);
        this.padding = Optional.of(padding);
    }

    public Optional<String> getAlgorithm() {
        return algorithm;
    }

    public Optional<String> getMode() {
        return mode;
    }

    public Optional<String> getPadding() {
        return padding;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s", this.algorithm.get(), this.mode.get(), this.padding.get());
    }
}
