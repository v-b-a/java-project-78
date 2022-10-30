package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorStringTest {
    StringSchema schema;
    Validator v;

    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.string();
    }

    @Test
    public void onlyEmptyValue() {
        boolean actual = schema.isValid("");
        assertTrue(actual);
        boolean actual2 = schema.isValid(null);
        assertTrue(actual2);
    }
    @Test
    public void emptyValueAfterRequired() {
        schema.required();
        boolean actual = schema.isValid("");
        assertFalse(actual);
        boolean actual2 = schema.isValid(null);
        assertFalse(actual2);
    }
    @Test
    public void onlyStringValue() {
        boolean actual = schema.isValid("What does the fox say");
        assertTrue(actual);
        schema.required();
        boolean actual2 = schema.isValid("hexlet");
        assertTrue(actual2);
    }
    @Test
    public void containsValue() {
        boolean actual = schema.contains("wh").isValid("what does the fox say");
        assertTrue(actual);
        schema.required();
        assertTrue(actual);
        boolean actual2 = schema.contains("whatthe").isValid("what does the fox say");
        assertFalse(actual2);
    }
}
