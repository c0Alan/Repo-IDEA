# 配置文件

## ref

```xml
<bean id="zxjlDao" class="com.thunisoft.np.fy.dwjk.dao.ZxjlDao">
    <property name="sessionFactory">
        <ref bean="sessionFactory" />
    </property>
</bean>
```



## map

```xml
<bean id="incrementalWriteService" class="com.thunisoft.np.fy.dwjk.httpservice.writ.service.IncrementalWriteService">
	<constructor-arg index="0">
		<map>
			<entry key="stxt" value-ref="stxtSQLGeneratedStrategy"/>
			<entry key="dzfy" value-ref="dzfySQLGeneratedStrategy"/>
		</map>
	</constructor-arg>
</bean>
```

## list

```xml
<bean id="tsUrlHttpApi" class="com.thunisoft.np.fy.dwjk.httpservice.tsUrl.NpfytsUrlHttpApi">
    <property name="tsUrlList">
        <list>
            <ref bean="szftGetTsUrl"/>
            <ref bean="newHxkjftGetTsUrl"/>
            <ref bean="hxkjftGetTsUrl"/>
            <ref bean="tdwyGetTsUrl"/>
            <ref bean="xhtGetTsUrl"/>
        </list>
    </property>
</bean>
```

# 依赖注入
# Java 配置
# AOP
# Bean 的Scope
# Spring EL 和资源调用
# Bean 的初始化和销毁
# Profile
# 事件（Application Event）
# Spring Aware
# 多线程
# 计划任务
# 条件注解@Conditional
# 组合注解与元注解
# @Enable*注解的工作原理
 第一类：直接导入配置类
 第二类：依据条件选择配置类
 第三类：动态注册Bean

# Spring

## 1.3.1 依赖注入

## 1.3.2 Java 配置

## 1.3.3 AOP

## 2.1 Bean 的Scope

## 2.2 Spring EL 和资源调用.

## 2.3 Bean 的初始化和销毁

## 2.4 Profile

## 2.5 事件（Application Event）

## 3.1 Spring Aware

## 3.2 多线程

## 3.3 计划任务

## 3.4 条件注解@Conditional

## 3.5 组合注解与元注解

## 3.6 @Enable*注解的工作原理

### 3.6.1 第一类：直接导入配置类

### 3.6.2 第二类：依据条件选择配置类

### 3.6.3 第三类：动态注册Bean

## 3.7 测试

# 测试

# 常用注解