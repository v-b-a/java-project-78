package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema range(int number1, int number2) {
        addConstraint("range", value -> {
            return !((Integer) value < number1 || (Integer) value > number2);
        });
        return this;
    }

    public final NumberSchema required() {
        addConstraint("required", value -> value instanceof Integer);
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
