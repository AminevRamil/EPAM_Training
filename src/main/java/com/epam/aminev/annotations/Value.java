package com.epam.aminev.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Value annotation is used to define default values
 * to fields of POJO classes.
 * You should use this annotations without {@link Entity} annotation
 *
 * @author Aminev Ramil
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
    String strValue() default "default value";

    int intValue() default -1;
}
