package hexlet.code.schemas;


import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema() {
        addConstraint("required", value -> value instanceof Map<?, ?>);
    }
    public final MapSchema sizeof(int size) {
        addConstraint("sizeof", value -> ((Map<?, ?>) value).size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> map) {
        addConstraint("shape", value -> {
            if (!(value instanceof Map<?, ?>)) {
                return false;
            }
            Map<String, BaseSchema> userValue = (Map<String, BaseSchema>) value;
            for (Map.Entry<String, BaseSchema> element : userValue.entrySet()) {
                if (!(map.get(element.getKey()).isValid(element.getValue()))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
    public final MapSchema required() {
        callRequired();
        return this;
    }
}
