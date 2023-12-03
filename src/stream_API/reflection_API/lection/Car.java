package stream_API.reflection_API.lection;

public class Car {
    public String name;
    private String price;
    public String engType;
    public String engPower;
    public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.price = "1000000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
