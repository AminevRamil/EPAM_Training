package com.epam.aminev.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code Entity} annotation declares POJO entities.
 * Fields of annotated class should be annotated with
 * {@link Value} annotation
 *
 * @author Aminev Ramil
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

}
