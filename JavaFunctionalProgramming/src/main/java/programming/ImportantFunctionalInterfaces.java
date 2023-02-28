package programming;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class ImportantFunctionalInterfaces {

    public static void main(String[] args) {
        // -> symbol represent lambda operator
        // :: symbol represent method reference

        List<Integer> numbers = Arrays.asList(1,3,5,6,4,7,9,12,14,13);

        Predicate<Integer> isEvenPredicate = x -> x % 2==0;

        Function<Integer,Integer> squareFunction = x -> x*x;

        Function<Integer , String> stringOutputFunction = x -> x +"";

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y;

        //No input > Return Something
        Supplier<Integer> randomIntegerSupplier = () -> 2;
        System.out.println(randomIntegerSupplier.get());

        Supplier<Integer> randomIntegerSupplier1 = () ->{
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupplier1.get());

        UnaryOperator<Integer> unaryOperator =  (x) -> 3 *x;
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer,String> biPredicate = (num , str) -> true;

        BiPredicate<Integer,String> biPredicate1 = (numb , str1) ->{
            return numb<10 && str1.length()>5;
        };
        System.out.println(biPredicate1.test(15,"testing"));

        BiFunction<Integer,String,String> biFunction = (numbe, str) ->{
           return numbe + " " + str;
        };
        System.out.println(biFunction.apply(10,"testing"));

        BiConsumer<Integer,String> biConsumer = (s1,s2) ->{
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(15,"testing");

    }
}
