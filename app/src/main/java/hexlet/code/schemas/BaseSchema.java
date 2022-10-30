package hexlet.code.schemas;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    @Getter
    private boolean required = false;

    private final Map<String, Predicate<Object>> constraints = new LinkedHashMap<>();

    public final boolean isValid(Object value) {
        if (!required) {
            return true;
        }
        boolean result = false;
        for (Map.Entry<String, Predicate<Object>> element : constraints.entrySet()) {
            if (!element.getValue().test(value)) {
                return false;
            }
            result = element.getValue().test(value);
        }
        return result;
    }

    public final BaseSchema required() {
        required = true;
        return this;
    }

    public final void addConstraint(String constraintName, Predicate<Object> predicate) {
        constraints.put(constraintName, predicate);
    }

}
