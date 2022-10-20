package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class BaseSchema {
    private final Map<String, String> currentConstraint = new HashMap<>();
    public boolean isValid(Object value) {
        return false;
    }
}
