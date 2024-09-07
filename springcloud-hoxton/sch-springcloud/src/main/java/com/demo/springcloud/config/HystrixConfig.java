package com.demo.springcloud.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.PostConstruct;
import java.util.concurrent.Callable;

/**
 * Hystrix 配置
 * @author liuxl
 * @date 2024/9/1
 */
@Configuration
public class HystrixConfig {

    @PostConstruct
    public void init() {
        // Hystrix 配置
        HystrixPlugins.reset();
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new RequestContextHystrixConcurrencyStrategy());
    }
}

/**
 * 实现 RequestAttributes 对象传递
 * 参考：https://cloud.tencent.com/developer/article/1600674
 */
class RequestContextHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    // 这个时候还在主线程了，所以通过RequestContextHolder.getRequestAttributes()是能拿到上下文的
    // 拿到后hold住，等到run执行的时候再绑定即可
    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new RequestAttributeAwareCallable<>(callable, RequestContextHolder.getRequestAttributes());
    }

    static class RequestAttributeAwareCallable<T> implements Callable<T> {

        private final Callable<T> delegate;
        private final RequestAttributes requestAttributes;

        public RequestAttributeAwareCallable(Callable<T> callable, RequestAttributes requestAttributes) {
            this.delegate = callable;
            this.requestAttributes = requestAttributes;
        }

        // 执行之前绑定上下文，执行完成后释放
        @Override
        public T call() throws Exception {
            try {
                RequestContextHolder.setRequestAttributes(requestAttributes);
                return delegate.call();
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        }
    }
}
