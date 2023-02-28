package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ExampleFPMethodReferences {

    private static void printCourse(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {

        List<String> course = Arrays.asList("AWS","Spring","Hibernate","Java","Cloud","Azure","SpringBoot","Microservices");
        course.stream()
                //.map(str -> str.toUpperCase())
                .map(String :: toUpperCase)
                .forEach(ExampleFPMethodReferences::printCourse);

        Supplier<String> stringSupplier = () -> new String();
        Supplier<String> stringSupplier1 = String :: new;
    }
}
