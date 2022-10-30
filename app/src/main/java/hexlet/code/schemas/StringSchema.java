package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private Integer minLength;
    private String containsString;

    public StringSchema() {
        addConstraint("required", value -> value instanceof String && !((String) value).isEmpty());
        addConstraint("minLength", value -> {
            if (minLength == null) {
                return true;
            }
            return ((String) value).length() >= minLength;
        });
        addConstraint("contains", value -> {
            if (containsString == null) {
                return true;
            }
            return ((String) value).contains(containsString);
        });

    }

    public BaseSchema contains(String s) {
        containsString = s;
        return this;
    }

    public BaseSchema minLength(int i) {
        minLength = i;
        return this;
    }

}
