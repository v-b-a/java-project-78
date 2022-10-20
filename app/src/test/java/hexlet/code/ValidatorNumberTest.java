package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorNumberTest {
    NumberSchema schema;
    Validator v;

    @BeforeEach
    public void beforeEach() {
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
        schema.range(5, 10);
        boolean actual = schema.isValid(4);
        assertFalse(actual);
        boolean actual2 = schema.isValid(6);
        assertTrue(actual2);
        boolean actual3 = schema.isValid(10);
        assertTrue(actual3);
        boolean actual4 = schema.isValid(15);
        assertFalse(actual4);
    }
}
