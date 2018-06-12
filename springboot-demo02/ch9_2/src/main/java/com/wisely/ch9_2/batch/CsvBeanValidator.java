package com.springboot.ch9_2.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 校验器定义
 * @param <T>
 */
public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {
    private javax.validation.Validator validator;

    /**
     * 使用JSR-303 的Validator 来校验我们的数据，在此处进行JSR-303 的Validator 的初始化，。
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception { //1
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    /**
     * 使用Validator 的 validate 方法校验数据。
     * @param value
     * @throws ValidationException
     */
    @Override
    public void validate(T value) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(value); //2
        if (constraintViolations.size() > 0) {

            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                message.append(constraintViolation.getMessage() + "\n");
            }
            throw new ValidationException(message.toString());
        }
    }

}
