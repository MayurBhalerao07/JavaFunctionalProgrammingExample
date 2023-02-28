package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleFPCollectFunction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,5,6,7,8,9,12,15);
        List<Integer> doubleNumberResultList =  doubleCollectList(numbers);
        System.out.println("Double Number ResultList :- "+ doubleNumberResultList);

        List<Integer> evenNumberResultList = evenNumberCollectList(numbers);
        System.out.println("Even Number ResultList :- "+ evenNumberResultList);

        List<String> course = Arrays.asList("AWS","Spring","Hibernate","Java","Cloud","Azure","SpringBoot","Microservices");
        List<Integer> courseLengthList = courseLengthList(course);
        System.out.println("Course Length List :- " + courseLengthList);
    }
    public static List<Integer> doubleCollectList(List<Integer> numbersList){
        return numbersList.stream().map(number -> number * number).collect(Collectors.toList());
    }
    public static List<Integer> evenNumberCollectList(List<Integer> numberList){
        return numberList.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    public static List<Integer> courseLengthList(List<String> courseList){
        return courseList.stream().map(x -> x.length()).collect(Collectors.toList());
    }
}
