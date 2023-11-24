package stream_API;

public class Main {
    public static void main(String[] args) {
        PlainInterface plainInterface = new PlainInterface() {
            @Override
            public String action(int x, int y) {
                return String.valueOf(x + y);
            }
        };
    }
}
