package com.leeseast2Z.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.leeseast2Z.validation.exception.ParamException;
import org.apache.commons.collections.MapUtils;

/**
 * @Author: limf
 * @Date: 2021/5/21 16:50
 * @Description: 验证器Util
 */
public class BeanValidator {
    //校验工厂
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    /*
     * java使用省略号代替多参数（参数类型... 参数名称）
     * */
    public static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.isEmpty()) {
            return Collections.emptyMap();
        } else {
            LinkedHashMap errors = Maps.newLinkedHashMap();
            Iterator<ConstraintViolation<T>> iterator = validate.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation) iterator.next();
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }

    public static Map<String, String> validatelist(Collection<?> collection) {
        //google工具类
        Preconditions.checkNotNull(collection);
        Iterator<?> iterator = collection.iterator();
        Map errors;
        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();
            }
            Object next = iterator.next();
            errors = validate(next, new Class[0]);
        } while (errors.isEmpty());
        return errors;
    }

    public static Map<String, String> validateobject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validatelist(Lists.asList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }

    public static void check(Object param) throws ParamException {
        Map<String, String> map = BeanValidator.validateobject(param);
        if (MapUtils.isNotEmpty(map)) {
            // throw new ParamException(map.toString());
            StringBuilder sb = new StringBuilder();
            for (String path : map.keySet()) {
                String message = map.get(path);
                sb.append(path + message + ",");
            }
            System.out.println("参数校验失败，结果如下："+sb.toString());
        }
    }
}
