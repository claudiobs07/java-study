package br.blog.cbs.reflection;


import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComparatorService {

    public static <E> List<Difference> compare(E param1, E param2) throws Exception {
        List<Difference> differences = new ArrayList<>();
        Class<?> clazz = param1.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (isComparableMethod(field)) {
                field.setAccessible(true);
                Object object1 = field.get(param1);
                Object object2 = field.get(param2);
                if (IsNotEquals(object1, object2)) {
                    Difference d = new Difference(field.getName(), object1, object2);
                    differences.add(d);
                }
            }
        }
        return differences;
    }

    private static boolean IsNotEquals(Object valorObjeto1, Object valorObjeto2) {
        return !valorObjeto1.equals(valorObjeto2);
    }

    private static boolean isComparableMethod(Field field) {
        return !field.isAnnotationPresent(Incomparable.class);
    }

}
