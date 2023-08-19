# 修改SDK注册表

指定vs使用的SDK

计算机\HKEY_LOCAL_MACHINE\SOFTWARE\WOW6432Node\Microsoft\Microsoft SDKs\Windows

CurrentInstallFolder : C:\Program Files (x86)\Microsoft SDKs\Windows\v7.1A\

这样vs在编译的时候就会找到相应SDK的目录, 引用下面的依赖文件(如Windows.h 头文件)

