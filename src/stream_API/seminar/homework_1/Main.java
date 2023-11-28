package stream_API.seminar.homework_1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 * */

public class Main {
    public static void main(String[] args) {
        List<Double> listNumbers = Arrays.asList(1.0, 3.0, 45.0, 65.0, 2.0, 3.0, 11.0, 88.0, 10.0);
        OptionalDouble average = listNumbers.stream()
                .filter(i -> i % 2 == 0)
                .mapToDouble(e -> e)
                .average();
        if (average.isPresent()) {

            System.out.println("Среднее значение всех четных чисел списка "
                    + listNumbers.stream().collect(Collectors.toList())
                    + " будет - "
                    + average.getAsDouble());}
    }
}
