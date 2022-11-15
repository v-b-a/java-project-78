package hexlet.code.schemas;


public class StringSchema extends BaseSchema {
    public StringSchema() {
        addConstraint("required", value -> value instanceof String && !((String) value).isEmpty());
    }

    public final StringSchema required() {
        callRequired();
        return this;
    }

    public final StringSchema contains(String containsString) {
        addConstraint("contains", value -> ((String) value).contains(containsString));
        return this;
    }

    public final StringSchema minLength(int minLength) {
        addConstraint("minLength", value -> ((String) value).length() >= minLength);
        return this;
    }

}
