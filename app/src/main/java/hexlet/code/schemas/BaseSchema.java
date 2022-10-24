package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class BaseSchema {
    Map<String, Object> currentConstraint = new HashMap<>();

    public boolean isValid(Object value) {
        return false;
    }

    public BaseSchema required() {
        currentConstraint.put("required", null);
        return this;
    }
}
