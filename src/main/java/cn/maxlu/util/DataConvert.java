package cn.maxlu.util;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class DataConvert {

    public static <T, S> T convert(final T target, final S source) {
        AccessController.doPrivileged((PrivilegedAction) () -> doConvert(target, source));
        return target;
    }

    private static <T, S> T doConvert(final T target, final S source) {
        Class targetClass = target.getClass();
        Class sourceClass = source.getClass();
        for (Field targetField : targetClass.getDeclaredFields()) {
            targetField.setAccessible(true);
            for (Field sourceField : sourceClass.getDeclaredFields()) {
                sourceField.setAccessible(true);
                if (sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType())) {
                    try {
                        targetField.set(target, sourceField.get(source));
                    } catch (IllegalAccessException e) {
                        continue;
                    }
                }
            }
        }
        return target;
    }
}
