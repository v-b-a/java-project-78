package hexlet.code.schemas;


import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private final Map<String, Integer> currentConstraint = new HashMap<>();

    @Override
    public boolean isValid(Object value) {
        if (currentConstraint.containsKey("required") && (value == null)) {
            return false;
        }
        if (currentConstraint.containsKey("sizeof")) {
            Map map = new HashMap<>((Map) value);
            return map.size() == currentConstraint.get("sizeof");
        }
        return true;
    }

    public void required() {
        currentConstraint.put("required", null);
    }

    public void sizeof(int size) {
        currentConstraint.put("sizeof", size);
    }
}
