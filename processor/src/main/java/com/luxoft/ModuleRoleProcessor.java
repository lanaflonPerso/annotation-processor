package com.luxoft;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;

/**
 * http://hannesdorfmann.com/annotation-processing/annotationprocessing101
 */
@SupportedAnnotationTypes("com.luxoft.ModuleRole")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ModuleRoleProcessor extends AbstractProcessor
{

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
    {
        System.out.println("HERE!!!");

        roundEnv.getElementsAnnotatedWith(ModuleRole.class)
                .stream().collect(groupingBy(e -> e.getAnnotation(ModuleRole.class).value()))
                .entrySet().stream()
                .forEach(e ->
                {
                    out.println("\nFor Role: " + e.getKey());
                    out.println("We have: ");
                    e.getValue().stream().forEach(out::println);
                });
        return true;
    }
}
