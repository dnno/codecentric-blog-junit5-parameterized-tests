package de.rpr.junit.jupiter.params.provider;

import com.google.gson.Gson;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

  private String[] value;
  private Type type;

  @Override
  public void accept(final JsonSource annotation) {
    value = annotation.value();
    type = annotation.type();
  }

  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
    return Arrays.stream(value)
        .map(this::map)
        .map(Arguments::of);
  }

  private Object map(final String value) {
    return new Gson().fromJson(value, type);
  }
}
