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
            Map<String, BaseSchema> map2 = (Map<String, BaseSchema>) currentConstraint.get("shape");
            Map<String, Object> map3 = (Map<String, Object>) value;
            int countTrue = 0;
            if(map2.get("name").isValid(map3.get("name"))) {
                countTrue++;
            }
            if(map2.get("age").isValid(map3.get("age"))) {
                countTrue++;
            }
            if (countTrue != 2) {
                return false;
            }
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
