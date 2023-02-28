package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExampleFunctionalInterface {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(2,4,5,6,7,9,8,1);

        Predicate<Integer> integerPredicate = x -> x % 2 == 0; // use for boolean condition

        Predicate<Integer> integerPredicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Function<Integer, Integer> integerIntegerFunction = x -> x * x; // use for input and output

        Function<Integer , Integer> integerIntegerFunction1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> println = System.out::println; // take input but does not return anything back

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numberList.stream()
                .filter(integerPredicate1)
                .map(integerIntegerFunction1)
                .forEach(consumer);


        BinaryOperator<Integer> sum1 = Integer::sum; // use for binary operation
        BinaryOperator<Integer> sum2 = (x,y) -> x + y;
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b ;
            }
        };
        int sum = numberList.stream().reduce(0, binaryOperator);
        System.out.println("sum :- "+ sum);

    }



}
