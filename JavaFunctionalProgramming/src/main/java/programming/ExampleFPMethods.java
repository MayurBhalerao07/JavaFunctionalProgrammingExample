package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExampleFPMethods {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Java","HTML","Spring","Hibernate","AWS","Jquery","CSS");
        List<Integer> intList = Arrays.asList(33,2,55,34,67,2,1,6,7,6,5,4,7,99);
        FpReducedMethodExp(intList);
        FpDistinctMethodExp(intList);
        FpSortedMethodExp(stringList);
    }

    public static void FpReducedMethodExp(List<Integer> list){
        // give the sum of total numbers present in list
        System.out.println("give the sum of total numbers present in list");
        System.out.println(list.stream().reduce(0,Integer::sum));

        // give square sum of each number present in list
        System.out.println("give square sum of each number present in list");
        System.out.println(list.stream().map(x -> x*x).reduce(0,Integer::sum));

        // give only odd number sum present in list
        System.out.println("give only odd number sum present in list");
        System.out.println(list.stream().filter(z -> z % 2 == 1).reduce(0,Integer::sum));
    }

    public static void FpDistinctMethodExp(List<Integer> list){
        // print distinct value from list
        System.out.println("print distinct value from list");
        list.stream().distinct().forEach(System.out::println);
    }

    public static void FpSortedMethodExp(List<String> list){
        //print sorted list in alphabetically / in case of integer min to max order
        System.out.println("print sorted list in alphabetically");
        list.stream().sorted().forEach(System.out::println);

        //print distinct sorted value in alphabetically / in case of integer min to max order
        System.out.println("print distinct sorted list in alphabetically");
        list.stream().distinct().sorted().forEach(System.out::println);

        //print sorted value in reverse / in case of integer max to min order
        System.out.println("print sorted value in reverse");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // print list as per length of String
        System.out.println("print list as per length of String");
        list.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }
}
