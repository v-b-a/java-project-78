//package hexlet.code;
//
//import hexlet.code.schemas.BaseSchema;
//import hexlet.code.schemas.MapSchema;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class ValidatorNestedMapTest {
//    MapSchema schema;
//    Validator v;
//
//    @BeforeEach
//    public void beforeEach() {
//        v = new Validator();
//        schema = v.map();
//        Map<String, BaseSchema> schemas = new HashMap<>();
//        schemas.put("name", v.string().required());
//        schemas.put("age", v.number().positive());
//        schema.shape(schemas);
//    }
//
//    @Test
//    public void onlyEmptyValue() {
//        Map<String, Object> human1 = new HashMap<>();
//        human1.put("name", "Kolya");
//        human1.put("age", 100);
//        boolean actual = schema.isValid(human1);
//        assertTrue(actual);
//    }
//    @Test
//    public void emptyValueAfterRequired() {
//        schema.required();
//        boolean actual = schema.isValid(null);
//        assertFalse(actual);
//    }
//    @Test
//    public void mapValueAfterRequired() {
//        schema.required();
//        boolean actual = schema.isValid(new HashMap());
//        assertTrue(actual);
//        Map<String, String> map = new HashMap<>();
//        map.put("One", "Two");
//        boolean actual2 = schema.isValid(map);
//        assertTrue(actual2);
//    }
//    @Test
//    public void sizeOf() {
//        schema.sizeof(2);
//        Map<String, String> map = new HashMap<>();
//        map.put("One", "Two");
//        boolean actual = schema.isValid(map);
//        assertFalse(actual);
//        map.put("Dat", "Mar");
//        boolean actual2 = schema.isValid(map);
//        assertTrue(actual2);
//    }
//}
