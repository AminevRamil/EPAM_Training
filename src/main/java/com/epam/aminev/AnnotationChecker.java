package com.epam.aminev;

import com.epam.aminev.annotations.Entity;
import com.epam.aminev.annotations.Value;
import com.epam.aminev.exceptions.NoValueAnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * The {@code AnnotationChecker} class checking if specified class
 * has Entity and Value annotations. If it need, it fills fields
 * with default values that specified in annotation declaration in classes
 *
 * @author Aminev Ramil
 */
public class AnnotationChecker {
    private Logger log = LoggerFactory.getLogger(AnnotationChecker.class);

    /**
     * Method that checks if specified class have Entity annotation
     * After checking Entity annotation, it count Value annotation.
     *
     * @param clazz specified class to check
     */
    public void checkEntityAnnotation(Class<?> clazz) {
        assert (clazz != null);
        if (clazz.isAnnotationPresent(Entity.class)) {
            log.info("Class {} have @Entity annotation", clazz.getSimpleName());
            if (countValueAnnotations(clazz) == 0) {
                try {
                    String message = String.format("Class %s has no @Value annotations", clazz.getSimpleName());
                    throw new NoValueAnnotationException(message);
                } catch (NoValueAnnotationException e) {
                    log.warn(e.getMessage());
                }
            }

        } else {
            if (countValueAnnotations(clazz) == 0) {
                try {
                    String message = String.format("Class %s have no @Entity annotation, " +
                            "nor @Value annotations", clazz.getSimpleName());
                    throw new IllegalStateException(message);
                } catch (IllegalStateException e) {
                    log.warn(e.getMessage());
                }
            } else {
                try {
                    String message = String.format("Class %s have no @Entity annotation, " +
                            "but have @Value annotation", clazz.getSimpleName());
                    throw new IllegalStateException(message);
                } catch (IllegalStateException e) {
                    log.warn(e.getMessage());
                }
            }
        }
    }

    /**
     * Method that count fields that annotated with Value
     *
     * @param clazz in which need count fields
     * @return counter's value
     */
    private int countValueAnnotations(Class<?> clazz) {
        int annotationCounter = 0;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Value.class)) {
                annotationCounter++;
            }
        }
        return annotationCounter;
    }

    /**
     * Method that should fill the fields with default values from annotation
     * Not completed.
     *
     * @param clazz class to fill the fields
     */
    public void fillFields(Class<?> clazz) {

        Field annotatedField = null;
        Value annotation = null;
        try {
            annotatedField = clazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            log.warn(e.getMessage());
        }
        try {
            assert (annotatedField != null);
            annotation = annotatedField.getAnnotation(Value.class);
        } catch (NullPointerException e) {
            log.warn(e.getMessage());
        }
        if (annotation != null) {
            log.info("Human name: {} ", annotation.strValue());
        }
    }
}
