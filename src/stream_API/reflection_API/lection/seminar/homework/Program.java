package stream_API.reflection_API.lection.seminar.homework;

import java.lang.reflect.InvocationTargetException;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        AnimalBuilder animalBuilder = new AnimalBuilder();

        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Mike", 3, true);
        animals[1] = new Cat("Nike", 2, false);
        animals[2] = new Dog("Bike", 5, true);
        animals[3] = new Dog("Zike", 7, false);

        for (Animal animal : animals) {
            animalBuilder.buildAnimal(animal);
        }
    }
}
