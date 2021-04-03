# 请求流程

## DispatcherServlet

```java
// 入口方法
void doDispatch(HttpServletRequest request, HttpServletResponse response);
mv = ha.handle(processedRequest, response, mappedHandler.getHandler()); // 处理请求


```

## RequestMappingHandlerAdapter

```java
// 处理请求方法
ModelAndView handleInternal(HttpServletRequest request,
			HttpServletResponse response, HandlerMethod handlerMethod);
// 调用请求方法
ModelAndView invokeHandlerMethod(HttpServletRequest request,
			HttpServletResponse response, HandlerMethod handlerMethod);
invocableMethod.invokeAndHandle(webRequest, mavContainer);

```

## InvocableHandlerMethod

```java
// 获取方法参数值
Object[] getMethodArgumentValues(NativeWebRequest request, ModelAndViewContainer mavContainer,
			Object... providedArgs);
args[i] = this.argumentResolvers.resolveArgument(
							parameter, mavContainer, request, this.dataBinderFactory);
```



## HandlerMethodArgumentResolver

## ServletInvocableHandlerMethod

```java
// 请求方法处理
void invokeAndHandle(ServletWebRequest webRequest, ModelAndViewContainer mavContainer,
			Object... providedArgs);
Object returnValue = invokeForRequest(webRequest, mavContainer, providedArgs);
```

## InvocableHandlerMethod

```java
// 请求方法处理
Object invokeForRequest(NativeWebRequest request, ModelAndViewContainer mavContainer,
			Object... providedArgs);
Object[] args = getMethodArgumentValues(request, mavContainer, providedArgs);

// 请求方法参数处理
Object[] getMethodArgumentValues(NativeWebRequest request, ModelAndViewContainer mavContainer,
			Object... providedArgs);
args[i] = this.argumentResolvers.resolveArgument(
							parameter, mavContainer, request, this.dataBinderFactory); // argumentResolvers: HandlerMethodArgumentResolverComposite
```

## HandlerMethodArgumentResolverComposite

这是一个组合器

```java
// 请求方法参数处理
Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory);
HandlerMethodArgumentResolver resolver = getArgumentResolver(parameter);

```

## RequestResponseBodyMethodProcessor

```java
// 解析参数
Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory);
Object arg = readWithMessageConverters(webRequest, parameter, parameter.getNestedGenericParameterType()); // 通过转换器获取方法参数
```

## AbstractMessageConverterMethodArgumentResolver

```java
// 通过转换器读取方法参数内容
// inputMessage, 可以通过这个实体获取 request body
protected <T> Object readWithMessageConverters(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType);
```



# 数据转换流程



