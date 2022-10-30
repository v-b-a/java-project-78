package hexlet.code.schemas;


public class NumberSchema extends BaseSchema {
    private final Integer[] rangeNumbers = new Integer[2];
    private boolean checkPositive = false;

    public NumberSchema() {
        addConstraint("required", value -> value instanceof Integer);
        addConstraint("positive", value -> {
            if (!checkPositive) {
                return true;
            }
            return ((Integer) value) > 0;
        });
        addConstraint("range", value -> {
            if (rangeNumbers[0] == null) {
                return true;
            }
            return !((Integer) value < rangeNumbers[0] || (Integer) value > rangeNumbers[1]);
        });
    }

    public final NumberSchema range(int number1, int number2) {
        rangeNumbers[0] = number1;
        rangeNumbers[1] = number2;
        return this;
    }

    public final BaseSchema positive() {
        checkPositive = true;
        return this;
    }

}
