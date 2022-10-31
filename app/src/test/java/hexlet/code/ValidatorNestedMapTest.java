package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorNestedMapTest {
    private final Validator v = new Validator();
    private final MapSchema schema = v.map();
    private final int TEST_NUMBER_100 = 100;
    private final int TEST_NUMBER_MINUS5 = -5;

    @BeforeEach
    public final void beforeEach() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);
    }

    @Test
    public void bothTrue() {
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", TEST_NUMBER_100);
        boolean actual = schema.isValid(human1);
        assertTrue(actual);
    }
    @Test
    public void oneValueNull() {
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        boolean actual = schema.isValid(human2);
        assertTrue(actual);
    }
    @Test
    public void oneFalse() {
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        boolean actual = schema.isValid(human3); // false
        assertFalse(actual);
    }
    @Test
    public void numberIsNegative() {
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", TEST_NUMBER_MINUS5);
        boolean actual = schema.isValid(human4); // false
        assertFalse(actual);
    }
}
