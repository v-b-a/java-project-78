package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class NumberSchema extends BaseSchema {
//    private final Map<String, String> currentConstraint = new HashMap<>();
    @Override
    public boolean isValid(Object value) {
        if(currentConstraint.containsKey("required") && (value == null)) {
            return false;
        }
        if(currentConstraint.containsKey("positive") && (Integer) value <= 0) {
            return false;
        }
        if(currentConstraint.containsKey("range")) {
            String[] array = String.valueOf(currentConstraint.get("range")).split(",");
            int i1 = Integer.parseInt(array[0]);
            int i2 = Integer.parseInt(array[1]);
            if ((Integer) value < i1 || (Integer) value > i2) {
                return false;
            }
        }
        if (value instanceof String) {
            return false;
        }
        return true;
    }

    public NumberSchema positive() {
        currentConstraint.put("positive", null);
        return this;
    }
    public NumberSchema range(int number1, int number2) {
        currentConstraint.put("range" , String.format("%s,%s", number1, number2));
        return this;
    }

}
