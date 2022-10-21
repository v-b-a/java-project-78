package hexlet.code.schemas;


import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {

    @Override
    public boolean isValid(Object value) {
        if (currentConstraint.containsKey("required") && (value == null)) {
            return false;
        }
        if (currentConstraint.containsKey("sizeof")) {
            Map map = new HashMap<>((Map) value);
            return map.size() == Integer.parseInt(String.valueOf( currentConstraint.get("sizeof")));
        }
        if (currentConstraint.containsKey("shape") ) {
            return (boolean) currentConstraint.get("shape");
        }
        return true;
    }

    public void sizeof(int size) {
        currentConstraint.put("sizeof", size);
    }
    public void shape(Map<String, BaseSchema> map) {
        currentConstraint.put("shape", map);
    }
}
