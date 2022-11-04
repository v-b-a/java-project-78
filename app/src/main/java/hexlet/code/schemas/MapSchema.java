package hexlet.code.schemas;


import java.util.Map;

public class MapSchema extends BaseSchema {
    public final MapSchema sizeof(int size) {
        addConstraint("sizeof", value -> ((Map<?, ?>) value).size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> map) {
        addConstraint("shape", value -> {
            Map<String, BaseSchema> userValue = (Map<String, BaseSchema>) value;
            for (Map.Entry<String, BaseSchema> element : userValue.entrySet()) {
                if (!(map.get(element.getKey()).isValid(element.getValue()))) {
                    return false;
                }
            }
            return true;
        });
        required();
        return this;
    }
    public final MapSchema required() {
        addConstraint("required", value -> value instanceof Map<?, ?>);
        return this;
    }
}
