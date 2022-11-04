package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    @Getter
    @Setter
    private Boolean required;

    private final Map<String, Predicate<Object>> constraints = new HashMap<>();

    public final boolean isValid(Object value) {
        boolean result = true;
        for (Map.Entry<String, Predicate<Object>> element : constraints.entrySet()) {
            if (!element.getValue().test(value)) {
                return false;
            }
            result = element.getValue().test(value);
        }
        return result;
    }

    public final void addConstraint(String constraintName, Predicate<Object> predicate) {
        constraints.put(constraintName, predicate);
    }

}
