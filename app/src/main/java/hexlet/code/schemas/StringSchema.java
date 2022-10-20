package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class StringSchema {
    private final Map<String, String> currentConstraint = new HashMap<>();

    public boolean isValid(String value) {
        if ((currentConstraint.containsKey("required")) && (value == null || value.equals(""))) {
            return false;
        }
        if ((currentConstraint.containsKey("contains")) && !(value.contains(currentConstraint.get("contains")))) {
            return false;
        }
        if ((currentConstraint.containsKey("minLength")) &&
                (value.length() < Integer.parseInt(currentConstraint.get("minLength")))) {
            return false;
        }
        return true;
    }

    public void required() {
        currentConstraint.put("required", null);
    }

    public StringSchema contains(String s) {
        currentConstraint.put("contains", s);
        return this;
    }

    public StringSchema minLength(int i) {
        currentConstraint.put("minLength", String.valueOf(i));
        return this;
    }
}
