package stream_API.reflection_API.lection.seminar.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Задача 1: Основы Reflection API
 * ===============================
 * <p>
 * Получите информацию о классе "Person" с использованием Reflection API:
 * выведите на экран все поля и методы класса.
 * Создайте экземпляр класса "Person" с использованием Reflection API,
 * установите значения полей и вызовите методы.
 * Реализуйте обработку исключений для обеспечения корректного взаимодействия
 * с Reflection API.
 */

public class Program {
    public static void main(String[] args) throws
            ClassNotFoundException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException,
            NoSuchMethodException {
        Class<?> personClass = Class
                .forName("stream_API.reflection_API.lection.seminar.task1.Person");
        Field[] fields = personClass.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName());
        }
        Constructor[] constructors = personClass.getConstructors();
        Object personInstance = constructors[0].newInstance(null);

        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personInstance, 32);

        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personInstance, "Mark");

        Method displayInforMethod = personClass.getDeclaredMethod("displayInfo");
        displayInforMethod.invoke(personInstance);
    }
}
