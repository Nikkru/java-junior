package stream_API.reflection_API.lection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws
            ClassNotFoundException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<?> car = Class.forName("stream_API.reflection_API.lection.Car");
        Constructor<?>[] constructors = car.getConstructors();

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);
    }
}
