package com.demo.java.encrypt.demo1;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

/**
 * 算法枚举类，用来构建不同算法的加解密流程
 *
 * @author liuxl
 * @date 2024/7/20
 */
public enum SymmetricEncryptionAlgorithm {
    AES_CBC_NO_PADDING_128("AES", "CBC", "NoPadding", 128, 16, IvParameterSpec.class, 128),
    AES_CBC_NO_PADDING_192("AES", "CBC", "NoPadding", 192, 24, IvParameterSpec.class, 128),
    AES_CBC_NO_PADDING_56("AES", "CBC", "NoPadding", 256, 32, IvParameterSpec.class, 128),
    AES_CBC_PKCS5_PADDING_128("AES", "CBC", "PKCS5Padding", 128, 16, IvParameterSpec.class, 128),
    AES_CBC_PKCS5_PADDING_192("AES", "CBC", "PKCS5Padding", 192, 24, IvParameterSpec.class, 128),
    AES_CBC_PKCS5_PADDING_256("AES", "CBC", "PKCS5Padding", 256, 32, IvParameterSpec.class, 128),
    AES_ECB_NO_PADDING_128("AES", "ECB", "NoPadding", 128, 16, null, -1),
    AES_ECB_NO_PADDING_192("AES", "ECB", "NoPadding", 192, 24, null, -1),
    AES_ECB_NO_PADDING_256("AES", "ECB", "NoPadding", 256, 32, null, -1),
    AES_ECB_PKCS5_PADDING_128("AES", "ECB", "PKCS5Padding", 128, 16, null, -1),
    AES_ECB_PKCS5_PADDING_192("AES", "ECB", "PKCS5Padding", 192, 24, null, -1),
    AES_ECB_PKCS5_PADDING_256("AES", "ECB", "PKCS5Padding", 256, 32, null, -1),
    DES_CBC_NO_PADDING_56("DES", "CBC", "NoPadding", 56, 8, IvParameterSpec.class, 64),
    DES_CBC_PKCS5_PADDING_56("DES", "CBC", "PKCS5Padding", 56, 8, IvParameterSpec.class, 64),
    DES_ECB_NO_PADDING_56("DES", "ECB", "NoPadding", 56, 8, null, -1),
    DES_ECB_PKCS5_PADDING_56("DES", "ECB", "PKCS5Padding", 56, 8, null, -1),
    DESEDE_CBC_NO_PADDING_168("DESede", "CBC", "NoPadding", 168, 24, IvParameterSpec.class, 64),
    DESEDE_CBC_PKCS5_PADDING_168("DESede", "CBC", "PKCS5Padding", 168, 24, IvParameterSpec.class, 64),
    DESEDE_ECB_NO_PADDING_168("DESede", "ECB", "NoPadding", 168, 24, null, -1),
    DESEDE_ECB_PKCS5_PADDING_168("DESede", "ECB", "PKCS5Padding", 168, 24, null, -1),
    BLOWFISH_CBC_NO_PADDING_128("Blowfish", "CBC", "NoPadding", 128, 16, IvParameterSpec.class, 64);

    private String transformation = "";
    private String algorithm = "";
    private String mode = "";
    private String padding = "";
    private int secretKeyStrLength = -1;
    private int secretKeyBitLength = -1;
    private Class<? extends AlgorithmParameterSpec> algorithmParameterSpecClass;
    private int algorithmParameterBitLength = -1;

    SymmetricEncryptionAlgorithm(String algorithm, String mode, String padding, int secretKeyBitLength, int secretKeyStrLength,
                                 Class<? extends AlgorithmParameterSpec> algorithmParameterSpecClass, int algorithmParameterBitLength) {
        this.algorithm = algorithm;
        this.mode = mode;
        this.padding = padding;
        this.transformation = String.format("%s/%s/%s", algorithm, mode, padding);
        this.secretKeyStrLength = secretKeyStrLength;
        this.secretKeyBitLength = secretKeyBitLength;
        this.algorithmParameterSpecClass = algorithmParameterSpecClass;
        this.algorithmParameterBitLength = algorithmParameterBitLength;
    }

    // 1 使用秘钥字符串加密，附加向量参数
    public String encrypt(String plainText, String secretKeyStr, String algorithmParameterStr) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvocationTargetException, NoSuchMethodException, InvalidAlgorithmParameterException, InstantiationException, IllegalAccessException {
        Encryptor encryptor = EncryptorBuilder.from(
                        AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding)
                                .setSecretKeyBitLength(this.secretKeyBitLength)
                                .setAlgorithmParameterSpecClass(this.algorithmParameterSpecClass)
                                .setAlgorithmParameterBitLength(this.algorithmParameterBitLength),
                        AlgorithmParam.of().setPlainText(plainText).setSecretKeyStr(secretKeyStr).setAlgorithmParameterStr(algorithmParameterStr),
                        (algorithmSpec, algorithmParam) -> {
                            validateSecretKeyStr(algorithmSpec, algorithmParam);
                            validateParamSpec(algorithmSpec, algorithmParam);
                        })
                .getCipher(this::getCipher)
                .getSecretKeyByStr((secretKeyStrTmp, algorithmTmp) -> new SecretKeySpec(secretKeyStrTmp.getBytes(), algorithmTmp))
                .padding(this::setPadding)
                .initCipher((cipher, key) -> initCipher(cipher, Cipher.ENCRYPT_MODE, key, algorithmParameterStr))
                .get();
        return encryptor.encrypt().get();
    }

    // 1 使用秘钥字符串解密，附加向量参数
    public String decrypt(String base64Content, String secretKeyStr, String algorithmParameterStr) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException, InvocationTargetException, NoSuchMethodException, InvalidAlgorithmParameterException, InstantiationException, IllegalAccessException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength)
                                .setAlgorithmParameterSpecClass(this.algorithmParameterSpecClass).setAlgorithmParameterBitLength(this.algorithmParameterBitLength),
                        AlgorithmParam.of().setBase64CipherText(base64Content).setSecretKeyStr(secretKeyStr).setAlgorithmParameterStr(algorithmParameterStr),
                        (algorithmSpec, algorithmParam) -> {
                            validateSecretKeyStr(algorithmSpec, algorithmParam);
                            validateParamSpec(algorithmSpec, algorithmParam);
                        })
                .getCipher(this::getCipher)
                .getSecretKeyByStr((secretKeyStrTmp, algorithmTmp) -> new SecretKeySpec(secretKeyStrTmp.getBytes(), algorithmTmp))
                .initCipher((cipher, key) -> initCipher(cipher, Cipher.DECRYPT_MODE, key, algorithmParameterStr))
                .get();
        return encryptor.decrypt().get();
    }

    // 2 使用秘钥字符串加密
    public String encrypt(String plainText, String secretKeyStr)
            throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength),
                        AlgorithmParam.of().setPlainText(plainText).setSecretKeyStr(secretKeyStr),
                        (algorithmSpec, algorithmParam) -> {
                            validateSecretKeyStr(algorithmSpec, algorithmParam);
                        })
                .getCipher(this::getCipher)
                .getSecretKeyByStr((secretKeyStrTmp, algorithmTmp) -> new SecretKeySpec(secretKeyStrTmp.getBytes(), algorithmTmp))
                .initCipher((cipher, key) -> initCipher(cipher, Cipher.ENCRYPT_MODE, key))
                .padding(this::setPadding).get();
        return encryptor.encrypt().get();
    }

    // 2 使用秘钥字符串解密
    public String decrypt(String base64Content, String secretKeyStr)
            throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength),
                        AlgorithmParam.of().setBase64CipherText(base64Content).setSecretKeyStr(secretKeyStr),
                        (algorithmSpec, algorithmParam) -> {
                            validateSecretKeyStr(algorithmSpec, algorithmParam);
                        })
                .getCipher(this::getCipher)
                .getSecretKeyByStr((secretKeyStrTmp, algorithmTmp) -> new SecretKeySpec(secretKeyStrTmp.getBytes(), algorithmTmp))
                .initCipher((cipher, key) -> initCipher(cipher, Cipher.DECRYPT_MODE, key))
                .get();
        return encryptor.decrypt().get();
    }

    // 3 使用随机数种子加密，指定随机数算法，附加向量参数
    public String encrypt(String plainText, String randomSeedStr, NumberGenerationAlgorithm ngAlgorithm, String algorithmParameterStr)
            throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength)
                                .setAlgorithmParameterSpecClass(this.algorithmParameterSpecClass).setAlgorithmParameterBitLength(this.algorithmParameterBitLength),
                        AlgorithmParam.of()
                                .setPlainText(plainText)
                                .setRandomSeedStr(randomSeedStr)
                                .setNgAlgorithm(ngAlgorithm)
                                .setAlgorithmParameterStr(algorithmParameterStr),
                        (algorithmSpec, algorithmParam) -> {
                            validateRandomSeed(algorithmSpec, algorithmParam);
                            validateParamSpec(algorithmSpec, algorithmParam);
                        })
                .getCipher(this::getCipher)
                .getSecretKeyByRandomSeed(this::getSecretKeyByRandomSeed)
                .initCipher((cipher, key) -> initCipher(cipher, Cipher.ENCRYPT_MODE, key, algorithmParameterStr))
                .padding(this::setPadding).get();
        return encryptor.encrypt().get();
    }

    // 3 使用随机数种子解密，指定随机数算法，附加向量参数
    public String decrypt(String base64Content, String randomSeedStr, NumberGenerationAlgorithm ngAlgorithm, String algorithmParameterStr)
            throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength)
                                .setAlgorithmParameterSpecClass(this.algorithmParameterSpecClass).setAlgorithmParameterBitLength(this.algorithmParameterBitLength),
                        AlgorithmParam.of().setBase64CipherText(base64Content).setRandomSeedStr(randomSeedStr).setNgAlgorithm(ngAlgorithm).setAlgorithmParameterStr(algorithmParameterStr),
                        (algorithmSpec, algorithmParam) -> {
                            validateRandomSeed(algorithmSpec, algorithmParam);
                            validateParamSpec(algorithmSpec, algorithmParam);
                        })
                .getCipher(this::getCipher)
                .getSecretKeyByRandomSeed(this::getSecretKeyByRandomSeed)
                .initCipher((cipher, key) -> initCipher(cipher, Cipher.DECRYPT_MODE, key, algorithmParameterStr))
                .get();
        return encryptor.decrypt().get();
    }

    // 4 使用随机数种子加密，指定随机数算法
    public String encrypt(String plainText, String randomSeedStr, NumberGenerationAlgorithm ngAlgorithm)
            throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength)
                                .setAlgorithmParameterSpecClass(this.algorithmParameterSpecClass).setAlgorithmParameterBitLength(this.algorithmParameterBitLength),
                        AlgorithmParam.of().setPlainText(plainText).setRandomSeedStr(randomSeedStr).setNgAlgorithm(ngAlgorithm), this::validateSecretKeyStr)
                .getCipher(this::getCipher)
                .getSecretKeyByRandomSeed(this::getSecretKeyByRandomSeed)
                .padding(this::setPadding).get();
        return encryptor.encrypt().get();
    }

    // 4 使用随机数种子解密，指定随机数算法
    public String decrypt(String base64Content, String randomSeedStr, NumberGenerationAlgorithm ngAlgorithm)
            throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
        Encryptor encryptor = EncryptorBuilder.from(AlgorithmSpec.of().setTransformation(this.algorithm, this.mode, this.padding).setSecretKeyBitLength(this.secretKeyBitLength)
                                .setAlgorithmParameterSpecClass(this.algorithmParameterSpecClass).setAlgorithmParameterBitLength(this.algorithmParameterBitLength),
                        AlgorithmParam.of().setBase64CipherText(base64Content).setRandomSeedStr(randomSeedStr).setNgAlgorithm(ngAlgorithm), this::validateSecretKeyStr)
                .getCipher(this::getCipher)
                .getSecretKeyByStr((secretKeyStrTmp, algorithmTmp) -> new SecretKeySpec(secretKeyStrTmp.getBytes(), algorithmTmp))
                .get();
        return encryptor.decrypt().get();
    }

    private boolean validateSecretKeyStr(AlgorithmSpec algorithmSpec, AlgorithmParam algorithmParam) {
        if (this.secretKeyStrLength != algorithmParam.getSecretKeyStr().get().length()) {
            throw new RuntimeException("Secret key must be " + algorithmSpec.getSecretKeyBitLength().getAsInt() + " bits.");
        }

        return true;
    }

    private boolean validateParamSpec(AlgorithmSpec algorithmSpec, AlgorithmParam algorithmParam) {
        if (algorithmSpec.getAlgorithmParameterBitLength().getAsInt() != algorithmParam.getAlgorithmParameterStr().get().length() * 8) {
            throw new RuntimeException("Vector key must be " + algorithmSpec.getAlgorithmParameterBitLength().getAsInt() + " bits.");
        }

        return true;
    }

    private boolean validateRandomSeed(AlgorithmSpec algorithmSpec, AlgorithmParam algorithmParam) {
        if (!algorithmParam.getRandomSeedStr().isPresent()) {
            throw new RuntimeException("Secret key must be " + algorithmSpec.getSecretKeyBitLength().getAsInt() + " bits.");
        }

        return true;
    }

    private Cipher getCipher(String transformation) {
        try {
            return Cipher.getInstance(transformation);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Key getSecretKeyByRandomSeed(String seedStr, NumberGenerationAlgorithm ngAlgorithm) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(this.algorithm);
            SecureRandom random = SecureRandom.getInstance(ngAlgorithm.getAlgorithmName());
            random.setSeed(seedStr.getBytes());
            keyGenerator.init(this.secretKeyBitLength, random);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] setPadding(String plainText, int blockSize) {
        byte[] plainTextBytes = plainText.getBytes();
        byte[] plainTextBytesNoPadding = plainTextBytes;
        int length = plainTextBytes.length;

        //计算需填充长度
        length = length + (blockSize - (length % blockSize));
        plainTextBytes = new byte[length];

        //填充
        System.arraycopy(plainTextBytesNoPadding, 0, plainTextBytes, 0, plainTextBytesNoPadding.length);
        return plainTextBytes;
    }

    private void initCipher(Cipher cipher, int mode, Key key, String algorithmParameterStr) {
        try {
            AlgorithmParameterSpec algorithmParameterSpec = this.algorithmParameterSpecClass.getConstructor(new Class[]{byte[].class}).newInstance(algorithmParameterStr.getBytes());
            cipher.init(mode, key, algorithmParameterSpec);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private void initCipher(Cipher cipher, int mode, Key key) {
        try {
            cipher.init(mode, key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
