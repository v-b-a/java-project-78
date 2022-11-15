package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addConstraint("required", value -> value instanceof Integer);
    }

    public final NumberSchema range(int number1, int number2) {
        addConstraint("range", value ->
                !((Integer) value < number1 || (Integer) value > number2));
        return this;
    }

    public final NumberSchema required() {
        callRequired();
        return this;
    }

    public final NumberSchema positive() {
        addConstraint("positive", value -> {
            if (value == null) {
                return true;
            }
            if (!(value instanceof Integer)) {
                return false;
            }
            return ((Integer) value) > 0;
        });
        return this;
    }

}
