package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorNumberTest {
    private NumberSchema schema;
    private Validator v;
    private final int NUMBERMINUS5 = -5;
    private final int NUMBER4 = 4;
    private final int NUMBER5 = 5;
    private final int NUMBER6 = 6;
    private final int NUMBER10 = 10;
    private final int NUMBER15 = 15;


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
        schema.range(NUMBER5, NUMBER10);
        boolean actual = schema.isValid(NUMBER4);
        assertFalse(actual);
        boolean actual2 = schema.isValid(NUMBER6);
        assertTrue(actual2);
        boolean actual3 = schema.isValid(NUMBER10);
        assertTrue(actual3);
        boolean actual4 = schema.isValid(NUMBER15);
        assertFalse(actual4);
    }
    @Test
    public void negativeValueWithoutRequiredWithPositive() {
        schema.positive();
        boolean actual1 = schema.isValid(NUMBERMINUS5);
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
