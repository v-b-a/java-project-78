package hexlet.code.schemas;


import java.util.Map;

public class MapSchema extends BaseSchema {
    private Integer mapSize;
    private Map<String, BaseSchema> schemas;

    public MapSchema() {
        addConstraint("required", value -> value instanceof Map<?, ?>);

        addConstraint("sizeof", value -> {
            if (mapSize == null) {
                return true;
            }
            return ((Map<?, ?>) value).size() == mapSize;
        });
        addConstraint("shape", value -> {
            if (schemas == null) {
                return true;
            }
            Map<String, BaseSchema> userValue = (Map<String, BaseSchema>) value;
            for (Map.Entry<String, BaseSchema> element : userValue.entrySet()) {
                if (!(schemas.get(element.getKey()).isValid(element.getValue()))) {
                    return false;
                }
            }
//            for (Map.Entry<String, BaseSchema> elementSchemas : schemas.entrySet()) {
//                if (!(userValue.get(elementSchemas.getKey()).isValid(elementSchemas.getValue()))) {
//                    return false;
//                }
//            }
            return true;
        });
    }

    //
//    @Override
//    public boolean isValid(Object value) {
//        if (constraints.containsKey("required") && (value == null)) {
//            return false;
//        }
//        if (constraints.containsKey("sizeof")) {
//            Map map = new HashMap<>((Map) value);
//            return map.size() == Integer.parseInt(String.valueOf(constraints.get("sizeof")));
//        }
//        if (constraints.containsKey("shape")) {
//            Map<String, BaseSchema> map2 = (Map<String, BaseSchema>) constraints.get("shape");
//            Map<String, Object> map3 = (Map<String, Object>) value;
//            int countTrue = 0;
//            if (map2.get("name").isValid(map3.get("name"))) {
//                countTrue++;
//            }
//            if (map2.get("age").isValid(map3.get("age"))) {
//                countTrue++;
//            }
//            if (countTrue != 2) {
//                return false;
//            }
//        }
//        return true;
//    }
//
    public BaseSchema sizeof(int size) {
        mapSize = size;
        return this;
    }

    public BaseSchema shape(Map<String, BaseSchema> map) {
        this.schemas = map;
        required();
        return this;
    }


//


}
