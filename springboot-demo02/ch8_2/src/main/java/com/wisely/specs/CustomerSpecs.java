package com.springboot.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.toArray;

// 自定义Repository 实现
public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) { //1

        final Class<T> type = (Class<T>) example.getClass(); // 获得当前实体类对象类的类型。

        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); // 新建 Predicate 列表存储构造的查询条件。

                EntityType<T> entity = entityManager.getMetamodel().entity(type);// 获得实体类的EntityType ，我们可以从EntityType 获得实体类的属性

                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {//5
                    Object attrValue = getValue(example, attr); // 获得实体类对象某一个属性的值。
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) { //7
                            if (!StringUtils.isEmpty(attrValue)) { //8
                                predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)),
                                        pattern((String) attrValue))); // 构造当前属性like (前后%)属性值查询条件，并添加到条件列表中。
                            }
                        } else {
                            predicates.add(cb.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())),
                                    attrValue)); // 其余情况下，构造属性和属性值 equal 查询条件，并添加到条件列表中.
                        }
                    }

                }
                return predicates.isEmpty() ? cb.conjunction() : cb.and(toArray(predicates, Predicate.class));//11
            }

            /**
             * 12
             */
            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            /**
             * 13
             */
            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName,
                                                             Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }

        };

    }

    /**
     * 14
     */
    static private String pattern(String str) {
        return "%" + str + "%";
    }

}
