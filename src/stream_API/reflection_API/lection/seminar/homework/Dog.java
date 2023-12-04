package stream_API.reflection_API.lection.seminar.homework;

public class Dog extends Animal {
    private boolean isWalking;

    public Dog(String name, int age, boolean isWalking) {
        super(name, age);
        this.isWalking = isWalking;
    }

    public void whatDoes() {
        System.out.println(isWalking ? "Just twirls its tail..." : "Gav! Gav! Gav!");
    }


}
