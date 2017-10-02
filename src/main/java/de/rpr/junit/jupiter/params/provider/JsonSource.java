package de.rpr.junit.jupiter.params.provider;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(JsonArgumentsProvider.class)
public @interface JsonSource {

  String[] value();

  Class<?> type();
}
