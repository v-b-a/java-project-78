package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema contains(String containsString) {
        addConstraint("contains", value -> ((String) value).contains(containsString));
        return this;
    }

    public final StringSchema required() {
        addConstraint("required", value -> value instanceof String && !((String) value).isEmpty());
        return this;
    }
    public final StringSchema minLength(int minLength) {
        addConstraint("minLength", value -> ((String) value).length() >= minLength);
        return this;
    }

}
