package com.springboot.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * 自定义RepositoryFactoryBean ，继承JpaRepositoryFactoryBean
 * 
 * @author liuxilin
 * @date 2018/6/13 23:05
 */
public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<T, S, ID> {


    /**
     * 2)重写createRepositoryFactory 方法，用当前的CustomRepositoryFactory 创建实例。
     * @param entityManager
     * @return
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {// 2
        return new CustomRepositoryFactory(entityManager);
    }

    /**
     * 创建CustomRepositoryFactory ，并继承JpaRepositoryFactory
     */
    private static class CustomRepositoryFactory extends JpaRepositoryFactory {// 3


        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        /**
         * 重写getTargetRepository 方法，获得当前自定义的Repository 实现。
         * @param information
         * @param entityManager
         * @param <T>
         * @param <ID>
         * @return
         */
        @Override
        @SuppressWarnings({"unchecked"})
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
                RepositoryInformation information, EntityManager entityManager) {// 4
            return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);

        }

        /**
         * 重写getRepositoryBaseClass ，获得当前自定义的Repository 实现的类型。
         * @param metadata
         * @return
         */
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {// 5
            return CustomRepositoryImpl.class;
        }
    }
}