package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Validator v = new Validator();

        MapSchema schema = v.map();

// shape - позволяет описывать валидацию для значений объекта Map по ключам.
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        boolean result = schema.isValid(human1); // true
        System.out.println(result);

        System.out.println("-------------");
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        boolean result2 = schema.isValid(human2); // true
        System.out.println(result2);

        System.out.println("-------------");
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        System.out.println(schema.isValid(human3)); // false

        System.out.println("-------------");

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        System.out.println(schema.isValid(human4)); // false

    }
}
