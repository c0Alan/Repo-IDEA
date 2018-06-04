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

