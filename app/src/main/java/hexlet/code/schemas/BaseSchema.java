package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    Map<String, Object> currentConstraint = new HashMap<>();
    public abstract boolean isValid(Object value);

    public BaseSchema required() {
        currentConstraint.put("required", null);
        return this;
    }
}
