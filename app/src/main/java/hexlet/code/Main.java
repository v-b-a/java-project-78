package hexlet.code;

import hexlet.code.schemas.NumberSchema;

public class Main {
    public static void main(String[] args) {

        Validator v = new Validator();

        NumberSchema schema = v.number();

    }
}
