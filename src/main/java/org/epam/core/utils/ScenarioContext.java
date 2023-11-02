package org.epam.core.utils;

import static java.util.Optional.ofNullable;

import java.util.EnumMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ScenarioContext {

    private final Map<Context, Object> context = new EnumMap<>(Context.class);

    public <T> void set(Context key, T value) {
        context.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Context key) {
        return (T) ofNullable(context.get(key)).orElse(null);
    }

    public enum Context {
        CREATE_WIDGET_REQUEST,
        CREATE_WIDGET_RESPONSE,
        UPDATE_WIDGET_RESPONSE
    }
}
