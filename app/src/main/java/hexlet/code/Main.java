package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Main {
    public static void main(String[] args) {

        Validator v = new Validator();

        NumberSchema schema = v.number();
//
//        System.out.println(schema.isValid(null)); // true
//
//        schema.required();
//        System.out.println("________");
//        System.out.println(schema.isValid(null)); // false
//        System.out.println(schema.isValid(10)); // true
//        System.out.println(schema.isValid("5")); // false
//        System.out.println("________");
//
//        System.out.println(schema.positive().isValid(10)); // true
//        System.out.println(schema.isValid(-10)); // false
////
//        System.out.println("________");
        schema.range(5, 10);

        System.out.println(schema.isValid(5)); // true
        System.out.println(schema.isValid(10)); // true
        System.out.println(schema.isValid(4)); // false
        System.out.println(schema.isValid(11)); // false
    }
}
