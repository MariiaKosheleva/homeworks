package ua.kosheleva.hw21.service;


import org.reflections.Reflections;
import ua.kosheleva.hw21.annotations.AutoCreate;
import ua.kosheleva.hw21.annotations.Init;
import ua.kosheleva.hw21.annotations.Multiplier;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Service {
    public static void init() {
        final Reflections reflection = new Reflections("ua.kosheleva.hw21");
        final Set<Class<?>> annotatedWith = reflection.getTypesAnnotatedWith(AutoCreate.class);
        final Map<String, Object> objFromAnnotatedClasses = new HashMap<>();
        System.out.println("Classes with annotation AutoCreate:");
        for (Class<?> aClass : annotatedWith) {
            try {
                System.out.println(aClass.getSimpleName());
                final Constructor<?> constructor = aClass.getConstructor();
                final Object object = constructor.newInstance();
                final Field[] fieldsFromAnnotatedClass = aClass.getDeclaredFields();
                System.out.println("Before:");
                System.out.println(object);
                changesOnAnnotatedFields(fieldsFromAnnotatedClass, object);
                System.out.println("After:");
                System.out.println(object);
                objFromAnnotatedClasses.put(aClass.getSimpleName(), object);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nInvoke methods in classes:");
        invokeInitMethods(objFromAnnotatedClasses);
        System.out.println();
    }

    public static void invokeInitMethods(Map<String, Object> objectMap) {
        objectMap.forEach((element, object) -> {
            final Method[] annotatedMethods = object.getClass().getMethods();
            for (Method method : annotatedMethods) {
                if (method.isAnnotationPresent(Init.class)) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void changesOnAnnotatedFields(Field[] fieldsFromAnnotatedClass, Object object) {
        try {
            for (Field fieldFromAnnotatedClass : fieldsFromAnnotatedClass) {
                if (fieldFromAnnotatedClass.isAnnotationPresent(Multiplier.class)) {
                    final Class<?> fieldType = fieldFromAnnotatedClass.getType();
                    final String operation = fieldFromAnnotatedClass.getAnnotation(Multiplier.class).mathematicalSign();
                    fieldFromAnnotatedClass.setAccessible(true);
                    if (fieldType.equals(Integer.class)) {
                        final Integer fieldValue = (Integer) fieldFromAnnotatedClass.get(object);
                        Integer newFieldValue = doChangesOnAnnotatedIntegerFields(fieldValue, operation);
                        fieldFromAnnotatedClass.setInt(object, newFieldValue);
                    } else if (fieldType.equals(Double.class)) {
                        final Double fieldValue = (Double) fieldFromAnnotatedClass.get(object);
                        Double newFieldValue = doChangesOnAnnotatedDoubleFields(fieldValue, operation);
                        fieldFromAnnotatedClass.set(object, newFieldValue);
                    } else {
                        System.out.println("Type of this field cannot accept arithmetic operation: " + fieldFromAnnotatedClass.getName());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer doChangesOnAnnotatedIntegerFields(Integer fieldValue, String operation) {
        if (operation.equals("*")) {
            return fieldValue * 3;
        }
        if (operation.equals("+")) {
            return fieldValue + fieldValue;
        }
        return 0;
    }

    public static Double doChangesOnAnnotatedDoubleFields(Double fieldValue, String operation) {
        if (operation.equals("*")) {
            return fieldValue * 3;
        }
        if (operation.equals("+")) {
            return fieldValue + fieldValue;
        }
        return 0.0;
    }
}


