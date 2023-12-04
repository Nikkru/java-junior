package stream_API.reflection_API.lection.seminar.homework;

public class Cat extends Animal {

    private boolean isEating;

    public Cat(String name, int age, boolean isEating) {
        super(name, age);
        this.isEating = isEating;
    }

    public void whatSay () {
        System.out.println(isEating ? "Mur-r-r-r-r-r-r" : "Miau-Miau-Miau!");
    }


}
