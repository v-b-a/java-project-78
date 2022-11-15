package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorMapTest {
    private MapSchema schema;

    @BeforeEach
    public final void beforeEach() {
        Validator v = new Validator();
        schema = v.map();
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
    public void mapValueAfterRequired() {
        schema.required();
        boolean actual = schema.isValid(new HashMap<>());
        assertTrue(actual);
        Map<String, String> map = new HashMap<>();
        map.put("One", "Two");
        boolean actual2 = schema.isValid(map);
        assertTrue(actual2);
    }
    @Test
    public void sizeOf() {
        schema.required();
        schema.sizeof(2);
        Map<String, String> map = new HashMap<>();
        map.put("One", "Two");
        boolean actual = schema.isValid(map);
        assertFalse(actual);
        map.put("Dat", "Mar");
        boolean actual2 = schema.isValid(map);
        assertTrue(actual2);
    }
}
