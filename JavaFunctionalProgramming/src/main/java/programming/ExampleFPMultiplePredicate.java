package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExampleFPMultiplePredicate {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2,3,5,6,7,8,12,11,14,15);
        getEvenOddFromList(numbers, x -> x % 2 == 0);
        getEvenOddFromList(numbers, x -> x % 2 != 0);

        List<Integer> squaredNumberList = mapAndCreateNewList(numbers, x -> x * x);
        System.out.println("Squared NumberList :- " + squaredNumberList);

        List<Integer> cubedNumberList = mapAndCreateNewList(numbers, x->x*x*x);
        System.out.println("Cubed Number List :- "+ cubedNumberList);

        List<Integer> doubledNumberList = mapAndCreateNewList(numbers, x -> x+x);
        System.out.println("Doubled Number List :- " + doubledNumberList);

    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> integerIntegerFunction) {
        return numbers.stream().map(integerIntegerFunction).collect(Collectors.toList());
    }

    private static void getEvenOddFromList(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream().filter(integerPredicate).forEach(System.out::println);
    }




}
