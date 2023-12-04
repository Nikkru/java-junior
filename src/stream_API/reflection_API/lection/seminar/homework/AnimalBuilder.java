package stream_API.reflection_API.lection.seminar.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnimalBuilder {
    public <T> void buildAnimal(T obj) throws IllegalAccessException, InvocationTargetException {
        Class<?> class_ = obj.getClass();
        Class<?> superClass = class_.getSuperclass();

        Field[] fields_super = superClass.getDeclaredFields();
        Field[] fields = class_.getDeclaredFields();
        Method[] methods = class_.getDeclaredMethods();
        Method[] methods_super = superClass.getDeclaredMethods();

        System.out.printf("Type '%s' - ", class_.getSimpleName());

        for (Field field : fields_super) {
            field.setAccessible(true);
            System.out.printf(" %s: %s,", field.getName(), field.get(obj));
        }

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.printf(" %s: %s,", field.getName(), field.get(obj));
        }

        for (Method method : methods_super) {
            method.setAccessible(true);
            System.out.printf(" SUPER_METHOD: '%s': - ", method.getName());
            method.invoke(obj);
        }

        for (Method method : methods) {
            method.setAccessible(true);
            System.out.printf(" METHOD: '%s': - ", method.getName());
            method.invoke(obj);
        }
    }
}
