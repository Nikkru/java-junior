package stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Привет", ",", "Мир", "смелый");
        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
        for (String i : list) {
            System.out.println(i);
        }
        list.add("родился");
        list.stream().filter(str -> str.length() > 4).forEach(System.out::println);
        list.stream().filter(str -> str.contains("о")).forEach(System.out::println);
        list.stream()
                .filter(str -> str.length() > 4)
                .filter(str -> str.contains("е"))
                .forEach(System.out::println);

        Arrays.asList(1,2,3,4,5).stream().map(number -> "число: " + number * number).forEach(System.out::println);
        Arrays.asList(1,2,6,2,5,2,4,6,3,4,5).stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);

        List<User> users = Arrays.asList(
                new User("Иван", 36),
                new User("John", 45),
                new User("Ann", 23));
        users.stream()
                .map(user -> new User(user.name, user.age-5))
                .filter(user -> user.age <= 25)
                .forEach(System.out::println);
    }
}
