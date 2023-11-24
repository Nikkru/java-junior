package stream_API;

public class Main {
    public static void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };
//        PlainInterface plainInterface = (x, y) -> String.valueOf(x+y);
        PlainInterface plainInterface = (x, y) -> (x+y);
//        PlainInterface plainInterface1 = (x, y) -> String.valueOf(Integer.compare(x, y));
//        PlainInterface plainInterface1 = (x, y) -> Integer.compare(x, y);
        PlainInterface plainInterface1 = Integer::compare;
        System.out.println(plainInterface.action(5, 3));
        System.out.println(plainInterface1.action(3, 1));
    }
}
