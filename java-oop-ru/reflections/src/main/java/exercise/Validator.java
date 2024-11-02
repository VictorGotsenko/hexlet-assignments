package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        String txt="";
        for (Field field : address.getClass().getDeclaredFields()) {
            List<String> errorMsg = new ArrayList<>();
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        errorMsg.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                try {
                    field.setAccessible(true);
                    txt = (String) field.get(address);
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
                if (txt.length() < field.getAnnotation(MinLength.class).minLength()) {
                    errorMsg.add("length less than "
                            + field.getAnnotation(MinLength.class).minLength());
                }
            }

            if (!errorMsg.isEmpty()) {
                result.put(field.getName(), errorMsg);
            } else {
                errorMsg.clear();
            }
        }
        return result;
    }
}
// END
