package com.demo.springcloud.utils;


import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
 
/**
 * Minio工具类
 */
@Log4j2
//@Component
@RequiredArgsConstructor
public class MinioUtils {
    /**
     * 定义一个私有的、不可变的 MinioClient 实例变量 minioClient
     */
    private final MinioClient minioClient;
 
    /**
     * 启动SpringBoot容器的时候初始化Bucket(桶)
     * 如果没有Bucket(桶)则创建
     *
     * @param bucketName Bucket(桶)名称
     */
    @SneakyThrows(Exception.class)
    private void createBucket(String bucketName) {
        if (!bucketExists(bucketName)) {
            //使用 minioClient 的 makeBucket 方法创建一个新的桶。
            //MakeBucketArgs.builder().bucket(bucketName).build() 创建了一个请求参数对象，指定了要创建的桶的名称。
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }
 
    /**
     * 判断Bucket(桶)是否存在
     *
     * @param bucketName Bucket(桶)名称
     * @return true:存在  false:不存在
     */
    @SneakyThrows(Exception.class)
    public boolean bucketExists(String bucketName) {
        //调用 minioClient 对象的 bucketExists 方法，检查指定的桶是否存在。
        //BucketExistsArgs.builder().bucket(bucketName).build() 创建了一个请求参数对象，用于传递桶名称。
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }
 
    /**
     * 获得Bucket(桶)的策略
     *
     * @param bucketName Bucket(桶)名称
     * @return 指定桶的访问策略
     */
    @SneakyThrows(Exception.class)
    public String getBucketPolicy(String bucketName) {
        //通过 MinIO 客户端 API 获取指定桶的访问策略。
        return minioClient.getBucketPolicy(
                //使用构建者模式创建一个 GetBucketPolicyArgs 对象，以便设置请求参数。
                GetBucketPolicyArgs
                        .builder()
                        //设置要获取策略的桶的名称。
                        .bucket(bucketName)
                        //构建并返回 GetBucketPolicyArgs 对象，该对象将作为参数传递给 getBucketPolicy 方法。
                        .build()
        );
    }
 
    /**
     * 获得所有Bucket(桶)列表
     *
     * @return 所有桶的列表
     */
    @SneakyThrows(Exception.class)
    public List<Bucket> getAllBuckets() {
        //调用 MinIO 客户端的 listBuckets 方法，返回当前用户拥有的所有桶的列表。
        return minioClient.listBuckets();
    }
 
    /**
     * 根据bucketName获取其相关信息
     *
     * @param bucketName Bucket(桶)名称
     * @return Optional<Bucket>
     */
    @SneakyThrows(Exception.class)
    public Optional<Bucket> getBucket(String bucketName) {
        //查找并返回指定名称的桶，如果不存在，则返回 Optional.empty()。
        //调用 getAllBuckets() 方法获取所有桶，然后使用 Java 8 的 Stream API 进行处理。
        //filter 方法用于筛选出名称与 bucketName 匹配的桶。
        //findFirst 方法用于返回第一个匹配的桶，返回值是一个 Optional<Bucket>，表示可能存在的桶。
        return getAllBuckets().stream().filter(bucket -> bucket.name().equals(bucketName)).findFirst();
    }
 
    /**
     * 根据bucketName删除Bucket(桶)  true:删除成功  false:删除失败
     *
     * @param bucketName Bucket(桶)名称
     */
    @SneakyThrows(Exception.class)
    public void removeBucket(String bucketName) {
        //调用 MinIO 客户端的 removeBucket 方法，通过构建 RemoveBucketArgs 对象来指定要删除的桶名。
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }
 
   
    /**
     * 判断文件是否存在
     *
     * @param bucketName Bucket(桶)名称
     * @param objectName 文件名称
     * @return true:存在  false:不存在
     */
    public boolean isObjectExist(String bucketName, String objectName) {
        boolean exist = true;
        try {
            //调用 MinIO 客户端的 statObject 方法，构建 StatObjectArgs 对象以检查对象的状态。如果对象存在，该方法不会抛出异常。
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            log.error("【Minio工具类】>>>> 判断文件是否存在, 异常：", e);
            exist = false;
        }
        return exist;
    }
 
    /**
     * 判断文件夹是否存在
     *
     * @param bucketName Bucket(桶)名称
     * @param objectName 文件夹名称
     * @return true:存在  false:不存在
     */
    public boolean isFolderExit(String bucketName, String objectName) {
        boolean exist = true;
        try {
            //使用 listObjects 方法列出指定桶中以 objectName 为前缀的对象。recursive(false) 表示不进行递归查找。
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs
                            .builder()
                            .bucket(bucketName)
                            .prefix(objectName)
                            .recursive(false)
                            .build()
            );
            //遍历结果，检查每个 Item 是否为目录且名称与 objectName 匹配。如果找到匹配的目录，将 exist 设为 true。
            for (Result<Item> result : results) {
                Item item = result.get();
                if (item.isDir() && objectName.equals(item.objectName())) {
                    exist = true;
                }
            }
        } catch (Exception e) {
            log.error("【Minio工具类】>>>> 判断文件夹是否存在, 异常：", e);
            exist = false;
        }
        return exist;
    }
 
    /**
     * 根据文件前置查询文件
     *
     * @param bucketName 存储桶
     * @param prefix     前缀
     * @param recursive  是否使用递归查询
     * @return MinioItem 列表
     */
    @SneakyThrows(Exception.class)
    public List<Item> getAllObjectsByPrefix(String bucketName,
                                            String prefix,
                                            boolean recursive) {
        List<Item> list = new ArrayList<>();// 创建一个空的 Item 列表，用于存储结果
        Iterable<Result<Item>> objectsIterator = minioClient.listObjects(// 获取指定桶中以 prefix 开头的对象列表
                ListObjectsArgs.builder()// 构建 ListObjectsArgs 对象
                        .bucket(bucketName)// 设置桶名
                        .prefix(prefix)// 设置对象前缀
                        .recursive(recursive)// 设置是否递归查找
                        .build());// 构建参数
        if (objectsIterator != null) { // 检查对象迭代器是否不为 null
            for (Result<Item> o : objectsIterator) { // 遍历迭代器中的每个结果
                Item item = o.get();// 获取当前结果中的 Item 对象
                list.add(item);// 将 Item 添加到列表中
            }
        }
        return list;// 返回包含所有找到的 Item 的列表
    }
 
    /**
     * 获取文件流
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @return 二进制流
     */
    @SneakyThrows(Exception.class)
    public InputStream getObject(String bucketName, String objectName) {
        return minioClient.getObject(// 调用 MinIO 客户端的 getObject 方法，获取指定对象的输入流
                GetObjectArgs.builder()// 构建 GetObjectArgs 对象
                        .bucket(bucketName)// 设置桶名
                        .object(objectName)// 设置对象名
                        .build()); // 构建参数并调用 getObject
    }
 
    /**
     * 断点下载
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     * @param offset     起始字节的位置
     * @param length     要读取的长度
     * @return 二进制流
     */
    @SneakyThrows(Exception.class)
    public InputStream getObject(String bucketName, String objectName, long offset, long length) {
        return minioClient.getObject(// 调用 MinIO 客户端的 getObject 方法，获取指定对象的输入流
                GetObjectArgs.builder()// 构建 GetObjectArgs 对象
                        .bucket(bucketName) // 设置桶名
                        .object(objectName)// 设置对象名
                        .offset(offset)// 设置读取的起始偏移量
                        .length(length) // 设置要读取的字节长度
                        .build());// 构建参数并调用 getObject
    }
 
    /**
     * 获取路径下文件列表
     *
     * @param bucketName 存储桶
     * @param prefix     文件名称
     * @param recursive  是否递归查找，false：模拟文件夹结构查找
     * @return 二进制流
     */
    public Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive) {
        return minioClient.listObjects(// 调用 MinIO 客户端的 listObjects 方法，返回对象列表
                ListObjectsArgs.builder() // 构建 ListObjectsArgs 对象
                        .bucket(bucketName) // 设置桶名
                        .prefix(prefix)// 设置对象前缀
                        .recursive(recursive)// 设置是否递归查找
                        .build());// 构建参数并调用 listObjects
    }
 
    /**
     * 使用MultipartFile进行文件上传
     *
     * @param bucketName  存储桶
     * @param file        文件名
     * @param objectName  对象名
     * @param contentType 类型
     * @return
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, MultipartFile file, String objectName, String contentType) {
        InputStream inputStream = file.getInputStream(); // 获取文件的输入流，以便上传
        return minioClient.putObject(// 调用 MinIO 客户端的 putObject 方法，上传文件
                PutObjectArgs.builder()// 构建 PutObjectArgs 对象
                        .bucket(bucketName)// 设置桶名
                        .object(objectName)// 设置对象名
                        .contentType(contentType)// 设置文件的内容类型
                        .stream(inputStream, inputStream.available(), -1) // 设置输入流及其可用字节数，-1 表示不限制
                        .build());// 构建参数并调用 putObject
    }
 
    /**
     * 图片上传
     *
     * @param bucketName  存储桶
     * @param imageBase64 图像的 Base64 编码字符串
     * @param imageName   接收图像的原始名称
     * @return
     */
    public ObjectWriteResponse uploadImage(String bucketName, String imageBase64, String imageName) {
        if (!StringUtils.isEmpty(imageBase64)) {// 检查 Base64 字符串是否非空
            InputStream in = base64ToInputStream(imageBase64);// 将 Base64 字符串转换为输入流
            String newName = System.currentTimeMillis() + "_" + imageName + ".jpg";// 生成新文件名，包含当前时间戳和原始名称
            String year = String.valueOf(new Date().getYear());// 获取当前年份
            String month = String.valueOf(new Date().getMonth());// 获取当前月份
            return uploadFile(bucketName, year + "/" + month + "/" + newName, in); // 调用 uploadFile 方法上传文件，路径为 年/月/新文件名
 
        }
        return null;// 如果 Base64 字符串为空，返回 null
    }
 
    // BASE64Decoder在jdk8以上的版本移除了，报错最简单解决换成jdk8就行了
    public static InputStream base64ToInputStream(String base64) {
        ByteArrayInputStream stream = null;// 声明 ByteArrayInputStream 变量，用于保存字节流
        try {
            // 使用 BASE64Decoder 解码 Base64 字符串并去除首尾空格，得到字节数组
            byte[] bytes = new BASE64Decoder().decodeBuffer(base64.trim());
            // 将字节数组转换为 ByteArrayInputStream，以便返回
            stream = new ByteArrayInputStream(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;// 返回字节输入流，如果出错则返回 null
    }
 
 
    /**
     * 上传本地文件
     *
     * @param bucketName 存储桶
     * @param objectName 对象名称
     * @param fileName   本地文件路径
     * @return
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, String fileName) {
        return minioClient.uploadObject(// 调用 MinIO 客户端的 uploadObject 方法进行文件上传
                UploadObjectArgs.builder()// 使用 UploadObjectArgs 构建上传参数
                        .bucket(bucketName)// 设置存储桶名称
                        .object(objectName)// 设置对象名称（在存储桶中的文件名）
                        .filename(fileName)// 设置要上传的本地文件名
                        .build()); // 构建并返回 UploadObjectArgs 对象，然后执行上传
    }
 
    /**
     * 通过流上传文件
     *
     * @param bucketName  存储桶
     * @param objectName  文件对象
     * @param inputStream 文件流
     * @return
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, InputStream inputStream) {
        return minioClient.putObject( // 调用 MinIO 客户端的 putObject 方法进行文件上传
                PutObjectArgs.builder()// 使用 PutObjectArgs 构建上传参数
                        .bucket(bucketName)// 设置存储桶名称
                        .object(objectName)// 设置对象名称（在存储桶中的文件名）
                        .stream(inputStream, inputStream.available(), -1)// 设置输入流及其大小，-1 表示使用默认值
                        .build()); // 构建并返回 PutObjectArgs 对象，然后执行上传
    }
 
    /**
     * 创建文件夹或目录
     *
     * @param bucketName 存储桶
     * @param objectName 目录路径
     * @return
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse createDir(String bucketName, String objectName) {
        return minioClient.putObject(// 调用 MinIO 客户端的 putObject 方法进行上传
                PutObjectArgs.builder()// 使用 PutObjectArgs 构建上传参数
                        .bucket(bucketName)// 设置存储桶名称
                        .object(objectName) // 设置对象名称（在存储桶中的“目录”名称）
                        .stream(new ByteArrayInputStream(new byte[]{}), 0, -1)// 使用空的字节数组流，表示创建一个空对象，0 表示长度，-1 表示使用默认值
                        .build());// 构建并返回 PutObjectArgs 对象，然后执行上传
    }
 
    /**
     * 获取文件信息, 如果抛出异常则说明文件不存在
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     * @return
     */
    @SneakyThrows(Exception.class)
    public String getFileStatusInfo(String bucketName, String objectName) {
        return minioClient.statObject( // 调用 MinIO 客户端的 statObject 方法获取对象状态信息
                StatObjectArgs.builder() // 使用 StatObjectArgs 构建请求参数
                        .bucket(bucketName) // 设置存储桶名称
                        .object(objectName)// 设置对象名称
                        .build() // 构建并返回 StatObjectArgs 对象
        ).toString();// 调用 toString 方法，将获取的状态信息转换为字符串并返回
    }
 
    /**
     * 拷贝文件
     *
     * @param bucketName    存储桶
     * @param objectName    文件名
     * @param srcBucketName 目标存储桶
     * @param srcObjectName 目标文件名
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse copyFile(String bucketName, String objectName, String srcBucketName, String srcObjectName) {
        return minioClient.copyObject(// 调用 MinIO 客户端的 copyObject 方法进行对象复制
                CopyObjectArgs.builder()// 使用 CopyObjectArgs 构建复制参数
                        .source(CopySource.builder()// 设置复制源
                                .bucket(bucketName) // 源存储桶名称
                                .object(objectName)// 源对象名称
                                .build())// 构建并返回 CopySource 对象
                        .bucket(srcBucketName)// 设置目标存储桶名称
                        .object(srcObjectName) // 设置目标对象名称
                        .build() // 构建并返回 CopyObjectArgs 对象
        );// 执行对象复制并返回 ObjectWriteResponse
    }
 
    /**
     * 删除文件
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     */
    @SneakyThrows(Exception.class)
    public void removeFile(String bucketName, String objectName) {
        minioClient.removeObject(// 调用 MinIO 客户端的 removeObject 方法以删除指定对象
                RemoveObjectArgs.builder()// 使用 RemoveObjectArgs 构建删除参数
                        .bucket(bucketName) // 设置要删除对象的存储桶名称
                        .object(objectName)// 设置要删除的对象名称
                        .build());// 构建并返回 RemoveObjectArgs 对象，并执行删除操作
    }
 
    /**
     * 批量删除文件
     *
     * @param bucketName 存储桶
     * @param keys       需要删除的文件列表
     * @return
     */
    public void removeFiles(String bucketName, List<String> keys) {
        List<DeleteObject> objects = new LinkedList<>();// 创建一个 LinkedList 用于存储待删除对象
        keys.forEach(s -> {// 遍历对象键列表
            objects.add(new DeleteObject(s)); // 将每个键封装成 DeleteObject 并添加到列表中
            try {
                // 尝试执行删除操作
                removeFile(bucketName, s);// 调用 removeFile 方法删除指定对象
            } catch (Exception e) {
                log.error("【Minio工具类】>>>> 批量删除文件，异常：", e);
            }
        });
    }
 
    /**
     * 获取文件外链
     * 使用了 .expiry(expires) 方法，指定了预签名 URL 的过期时间。
     * 适用于需要限制 URL 有效期的场景。
     * 适用于需要设定过期时间的情况
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @param expires    过期时间 <=7 秒 （外链有效时间（单位：秒））
     * @return url
     */
    @SneakyThrows(Exception.class)
    public String getPresignedObjectUrl(String bucketName, String objectName, Integer expires) {
        // 构建获取预签名对象 URL 的参数
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()// 使用 GetPresignedObjectUrlArgs 的构建器
                .expiry(expires)// 设置 URL 的过期时间（以秒为单位）
                .bucket(bucketName) // 设置存储桶名称
                .object(objectName)// 设置对象名称
                .build();// 构建并返回 GetPresignedObjectUrlArgs 对象
        return minioClient.getPresignedObjectUrl(args);// 调用 MinIO 客户端获取预签名 URL 并返回
    }
 
    /**
     * 获得文件外链
     * 使用了 .method(Method.GET) 方法，指定了 HTTP 请求方法为 GET。
     * 适用于需要明确请求类型的场景，但没有设置过期时间。
     * 适用于无需设定过期时间的访问
     *
     * @param bucketName
     * @param objectName
     * @return url
     */
    @SneakyThrows(Exception.class)
    public String getPresignedObjectUrl(String bucketName, String objectName) {
        // 构建获取预签名对象 URL 的参数
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()// 使用 GetPresignedObjectUrlArgs 的构建器
                .bucket(bucketName) // 设置存储桶名称
                .object(objectName)// 设置对象名称
                .method(Method.GET)// 设置对象名称
                .build();// 构建并返回 GetPresignedObjectUrlArgs 对象
        return minioClient.getPresignedObjectUrl(args);// 调用 MinIO 客户端获取预签名 URL 并返回
    }
 
    /**
     * 将URLDecoder编码转成UTF8
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getUtf8ByURLDecoder(String str) throws UnsupportedEncodingException {
        // 将字符串中的不合法 URL 编码转换为合法编码
        String url = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");// 使用正则表达式，将不符合 URL 编码规范的百分号（%）替换为 %25
        return URLDecoder.decode(url, "UTF-8");// 使用 URLDecoder 解码字符串，返回 UTF-8 编码的结果
    }
 
    
}