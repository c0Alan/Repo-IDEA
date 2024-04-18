# 动态生成 java 类

```bash
java -jar avro-tools-1.7.7.jar compile schema ..\avro\*.avsc .
java -jar avro-tools-1.7.7.jar idl2schemata ..\avro\*.avdl ..\avro

# schema -> java
java -jar avro-tools-1.7.7.jar compile schema ..\avro\*.avsc .

# idl -> schema -> java
java -jar avro-tools-1.7.7.jar idl2schemata *.avdl .
java -jar avro-tools-1.7.7.jar compile schema ..\avro\*.avsc .

# idl -> proto -> java
java -jar avro-tools-1.7.7.jar idl flume.avdl flume.avpr
java -jar avro-tools-1.7.7.jar compile protocol flume.avpr .
```

