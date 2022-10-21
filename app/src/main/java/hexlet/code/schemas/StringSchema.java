package hexlet.code.schemas;


public class StringSchema extends BaseSchema {

    @Override
    public boolean isValid(Object value) {
        if ((currentConstraint.containsKey("required")) && (value == null || value.equals(""))) {
            return false;
        }
        if ((currentConstraint.containsKey("contains")) &&
                !((String.valueOf(value)).contains((CharSequence) currentConstraint.get("contains")))) {
            return false;
        }
        if ((currentConstraint.containsKey("minLength")) &&
                ((String.valueOf(value)).length() < Integer.parseInt((String) currentConstraint.get("minLength")))) {
            return false;
        }
        return true;
    }

    public BaseSchema contains(String s) {
        currentConstraint.put("contains", s);
        return this;
    }

    public BaseSchema minLength(int i) {
        currentConstraint.put("minLength", String.valueOf(i));
        return this;
    }

}
