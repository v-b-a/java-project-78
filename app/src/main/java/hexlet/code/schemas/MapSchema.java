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
            return true;
        });
    }
    public BaseSchema sizeof(int size) {
        mapSize = size;
        return this;
    }

    public BaseSchema shape(Map<String, BaseSchema> map) {
        this.schemas = map;
        required();
        return this;
    }
}
