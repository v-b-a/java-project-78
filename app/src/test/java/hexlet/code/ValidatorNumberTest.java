package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorNumberTest {
    NumberSchema schema;
    Validator v;
    private final int TEST_NUMBER_4 = 4;
    private final int TEST_NUMBER_5 = 5;
    private final int TEST_NUMBER_6 = 6;
    private final int TEST_NUMBER_10 = 10;
    private final int TEST_NUMBER_15 = 15;


    @BeforeEach
    public final void beforeEach() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    public void onlyEmptyValue() {
        boolean actual = schema.isValid(null);
        assertTrue(actual);
    }
    @Test
    public void emptyValueAfterRequired() {
        schema.required();
        boolean actual = schema.isValid(null);
        assertFalse(actual);
    }
    @Test
    public void onlyStringValueAfterRequired() {
        schema.required();
        boolean actual = schema.isValid("5");
        assertFalse(actual);
    }
    @Test
    public void rangeValue() {
        schema.required();
        schema.range(TEST_NUMBER_5, TEST_NUMBER_10);
        boolean actual = schema.isValid(TEST_NUMBER_4);
        assertFalse(actual);
        boolean actual2 = schema.isValid(TEST_NUMBER_6);
        assertTrue(actual2);
        boolean actual3 = schema.isValid(TEST_NUMBER_10);
        assertTrue(actual3);
        boolean actual4 = schema.isValid(TEST_NUMBER_15);
        assertFalse(actual4);
    }
    @Test
    public void negativeValueWithoutRequiredWithPositive() {
        schema.positive();
        boolean actual1 = schema.isValid(-5);
        assertFalse(actual1);
        boolean actual2 = schema.isValid("5");
        assertFalse(actual2);
    }
    @Test
    public void nullValueWithoutRequiredWithPositive() {
        schema.positive();
        boolean actual1 = schema.isValid(null);
        assertTrue(actual1);
    }
}
