package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class StringSchema extends BaseSchema {
    private final Map<String, String> currentConstraint = new HashMap<>();

    @Override
    public boolean isValid(Object value) {
        if ((currentConstraint.containsKey("required")) && (value == null || value.equals(""))) {
            return false;
        }
        if ((currentConstraint.containsKey("contains")) && !((String.valueOf(value)).contains(currentConstraint.get("contains")))) {
            return false;
        }
        if ((currentConstraint.containsKey("minLength")) &&
                ((String.valueOf(value)).length() < Integer.parseInt(currentConstraint.get("minLength")))) {
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
