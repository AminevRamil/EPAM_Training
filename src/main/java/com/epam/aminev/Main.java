package com.epam.aminev;

import com.epam.aminev.pojo.Human;
import com.epam.aminev.pojo.HumanAnnotated;
import lombok.extern.slf4j.Slf4j;

/**
 * Main class that demonstrate understanding of how reflection works
 *
 * @author Aminev Ramil
 */

@Slf4j
public class Main {
    /**
     * Main entry point to demo that was did during lesson 10
     *
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        Human human = new Human();
        HumanAnnotated annotatedHuman = new HumanAnnotated();

        Class<? extends HumanAnnotated> annotatedHumanClass = annotatedHuman.getClass();
        Class<? extends Human> humanClass = human.getClass();

        AnnotationChecker valueChecker = new AnnotationChecker();
        valueChecker.checkEntityAnnotation(annotatedHumanClass);
        valueChecker.checkEntityAnnotation(humanClass);

        valueChecker.fillFields(human.getClass());

        HumanAnnotated humanAnnotated = new HumanAnnotated();
        System.out.println(humanAnnotated.getName());
    }
}
