package exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(address) == null;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .map(Field::getName)
                .collect(Collectors.toList());


        // First version

//        List<String> nonValidList = new ArrayList<>();
//        for (Field field : address.getClass().getDeclaredFields()) {
//            if (field.isAnnotationPresent(NotNull.class)) {
//                try {
//                    field.setAccessible(true);
//                    if (field.get(address) == null) {
//                        nonValidList.add(field.getName());
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return nonValidList;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> map = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MinLength.class)) {
                int minLength = field.getAnnotation(MinLength.class).minLength();
                field.setAccessible(true);
                try {
                    String fieldValue = (String) field.get(address);
                    if (fieldValue != null && fieldValue.length() < minLength) {
                        map.put(field.getName(), List.of("length less than " + minLength));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        List<String> nullErrorFields = validate(address);
        for (String fieldName : nullErrorFields) {
            map.put(fieldName, List.of("can not be null"));
        }

        return map;
    }
}
// END
