package ua.repka;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_test {
    public static void main(String[] args) {
        List<Integer> squareTwo = Stream.iterate(2, x -> x * 2)
                .limit(20)
                .collect(Collectors.toList());
        squareTwo.forEach(System.out::println);
        Stream.builder()
                .add(10)
                .add(4)
                .build()
                .forEach(System.out::println);
        OptionalDouble avr = IntStream.range(0, 100)
                .average();
        if (avr.isPresent()) System.out.println(avr.getAsDouble());

        // Generating some sequence
        List<Integer> arrayList = IntStream.range(0, 55)
                .boxed()
                .filter(el -> (el %5 == 0))
                .collect(Collectors.toList());
        arrayList.forEach(System.out::print);

    }
}
