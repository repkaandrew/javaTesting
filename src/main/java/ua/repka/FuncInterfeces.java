package ua.repka;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncInterfeces {
    public static void main(String[] args) {
        // Predicate testing
        Predicate<Integer> isNegative = (numb) -> numb >= 0;
        System.out.println(isNegative.test(-5));
        System.out.println(isNegative.test(5));

        // Consumer
        Consumer<String> errPrinter = System.err::println;
        errPrinter.accept("Hello");

        // Supplier
        Supplier<String> getCurDate = () -> (new Date().toString());
        System.out.println(getCurDate.get());

        // Function
        Function<String, Optional<Integer>> strToIntSum = (str) -> {
            Integer numb = null;
            try {
                numb = Integer.valueOf(str);
            } catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            return Optional.of(numb);
        };
        Optional<Integer> res = strToIntSum.apply("sadv");
        res.ifPresent(System.out::println);
    }
}
