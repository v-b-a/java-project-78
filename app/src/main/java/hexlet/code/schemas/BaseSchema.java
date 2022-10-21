package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    Map<String, String> currentConstraint;

    public boolean isValid(Object value) {
        return false;
    }
}
